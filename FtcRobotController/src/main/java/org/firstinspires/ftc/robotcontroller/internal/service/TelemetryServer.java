package org.firstinspires.ftc.robotcontroller.internal.service;

import android.content.Context;
import android.util.Log;

import com.qualcomm.robotcore.eventloop.EventLoop;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * Created by cyber on 1/17/2018.
 */

public class TelemetryServer {
    protected int port;
    protected ServerSocket server;
    protected Context context;
    protected boolean allowServer = true;
    protected HardwareMap hardwareMap;
    protected EventLoop eventLoop;
    protected boolean lookupFaulty = false;

    protected DcMotor dcFrontRight;
    protected DcMotor dcFrontLeft;
    protected DcMotor dcBackRight;
    protected DcMotor dcBackLeft;

    protected DcMotor dcArm;
    protected DcMotor dcWinch;

    protected DcMotor dcLeftGrabber;
    protected DcMotor dcRightGrabber;

    protected CRServo crBeam;
    protected CRServo crFlipper;
    protected CRServo crRelic;

    protected ColorSensor colorSensor;
    protected TouchSensor flipperTouch;
    protected TouchSensor beamTouch;
    protected TouchSensor winchTouch;

    public TelemetryServer(Context _context, EventLoop _eventLoop) {
        eventLoop = _eventLoop;
        context = _context;
        port = 4567;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {

        }
        if (server != null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    runServer();
                }
            }).start();
        }
    }

    void log(String string) {
        Log.d("TelemetryServer", string);
    }

    void runServer() {
        while(allowServer) {
            try {
                Socket client = server.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                String readLine;
                String get = "";
                while ((readLine = in.readLine()) != null) {
                    if (readLine.toUpperCase().contains("GET")) {
                        String[] line = readLine.split(" ");
                        get = line[1];
                    }
                    if (readLine.isEmpty()) {
                        break;
                    }
                }
                out.write("HTTP/1.1 200 OK\r\n");
                out.write("Date: Fri \r\n");
                out.write("Server: Telemetry\r\n");
                out.write("Content-Type: text/html\r\n");
                out.write("\r\n");
                if (get.equals("/")) {
                    indexPage(out);
                } else {
                    attemptHardwareSetup();
                    if (!lookupFaulty) {
                        try {
                            telemetryJSON(out);
                        } catch (NullPointerException e) {
                            out.write("{\"error\":\""+e.getMessage()+"\"}");
                        }
                    } else {
                        out.write("{\"error\":\"Lookup was Faulty check lookup names!\"}");
                    }
                }
                out.close();
                in.close();
                client.close();


            } catch(IOException e) {
                log("RunServer IOException");
                log(e.toString());
            }
        }
    }

    public void haltServer() {
        allowServer = false;
        try {
            if (server != null) {
                server.close();
            }
        } catch(IOException e) {
            log("Halt Server error: "+e);
            // Failed to close server!
        }
    }

    void attemptHardwareSetup() {
        if (eventLoop.getOpModeManager().getHardwareMap() != null) {
            hardwareMap = eventLoop.getOpModeManager().getHardwareMap();
        }
        try {
            if (hardwareMap != null && hardwareMap.size() >= 15) {
                dcFrontLeft = getMotor("dcFrontLeft");
                dcFrontRight = getMotor("dcFrontRight");
                dcBackLeft = getMotor("dcBackLeft");
                dcBackRight = getMotor("dcBackRight");
//                log("Drive Train A.O.K.");

                dcArm = getMotor("dcArm");
                dcWinch = getMotor("dcWinch");
//                log("Winch A.O.K.");

                dcLeftGrabber = getMotor("dcLeftGrabber");
                dcRightGrabber = getMotor("dcRightGrabber");
//                log("Grabbers A.O.K.");

                crBeam = getcrServo("crBeam");
                crFlipper = getcrServo("crFlipper");
                crRelic = getcrServo("crGrabber");
//                log("Servos A.O.K.");

                colorSensor = hardwareMap.colorSensor.get("colorSensor");
//                log("ColorSensor A.O.K.");

                beamTouch = hardwareMap.touchSensor.get("beamTouch");
                flipperTouch = hardwareMap.touchSensor.get("flipperTouch");
                winchTouch = hardwareMap.touchSensor.get("winchTouch");
//                log("TouchSensors A.O.K.");
                lookupFaulty = false;
            }
        } catch (IllegalArgumentException e) {
            log(e.toString());
            badLookup();
            hardwareMap = null;
        }
    }

    void badLookup() {
        lookupFaulty = true;
    }

    DcMotor getMotor(String motor) throws IllegalArgumentException {
        return hardwareMap.dcMotor.get(motor);
    }
    CRServo getcrServo(String servo) throws IllegalArgumentException {
        return hardwareMap.crservo.get(servo);
    }
    Servo getServo(String servo) throws IllegalArgumentException {
        return hardwareMap.servo.get(servo);
    }

    void telemetryJSON(BufferedWriter out) throws NullPointerException,IOException {
        String json = "{\"motors\":[" +
                "{\"name\":\"dcFrontLeft\",\"power\":"+dcFrontLeft.getPower()+",\"encoder\":"+dcFrontLeft.getCurrentPosition()+"}," +
                "{\"name\":\"dcFrontRight\",\"power\":"+dcFrontRight.getPower()+",\"encoder\":"+dcFrontRight.getCurrentPosition()+"}," +
                "{\"name\":\"dcBackLeft\",\"power\":"+dcBackLeft.getPower()+",\"encoder\":"+dcBackLeft.getCurrentPosition()+"}," +
                "{\"name\":\"dcBackRight\",\"power\":"+dcBackRight.getPower()+",\"encoder\":"+dcBackRight.getCurrentPosition()+"}," +
                "{\"name\":\"dcArm\",\"power\":"+dcArm.getPower()+",\"encoder\":"+dcArm.getCurrentPosition()+"}," +
                "{\"name\":\"dcWinch\",\"power\":"+dcWinch.getPower()+",\"encoder\":"+dcWinch.getCurrentPosition()+"}," +
                "{\"name\":\"dcLeftGrabber\",\"power\":"+dcLeftGrabber.getPower()+",\"encoder\":"+dcLeftGrabber.getCurrentPosition()+"}," +
                "{\"name\":\"dcRightGrabber\",\"power\":"+dcRightGrabber.getPower()+",\"encoder\":"+dcRightGrabber.getCurrentPosition()+"}]," +
                "\"servos\":[" +
                "{\"name\":\"crBeam\",\"position\":"+crBeam.getPower()+"}," +
                "{\"name\":\"crFlipper\",\"position\":"+crFlipper.getPower()+"}," +
                "{\"name\":\"crRelic\",\"position\":"+crRelic.getPower()+"}]," +
                "\"sensors\":[" +
                "{\"name\":\"colorSensor\",\"value\":{\"red\":"+colorSensor.red()+",\"green\":"+colorSensor.green()+",\"blue\":"+colorSensor.blue()+"}}," +
                "{\"name\":\"beamTouch\",\"value\":"+beamTouch.isPressed()+"}," +
                "{\"name\":\"flipperTouch\",\"value\":"+flipperTouch.isPressed()+"}," +
                "{\"name\":\"winchTouch\",\"value\":"+winchTouch.isPressed()+"}]}";
        out.write(json);
//        log("TeleMetry");
    }

    void indexPage(BufferedWriter out) throws IOException {
        out.write("<!doctype html>\n");
        out.write("<html>\n");
        out.write("<head>\n");
        out.write("<script>\n");
        out.write("function refreshTelemetry() {\n");
        out.write("var request = new XMLHttpRequest();\n");
        out.write("request.open('GET', '/telemetry', true);\n");
        out.write("request.onload = function() {\n");
        out.write("if (request.status >= 200 && request.status < 400) {\n");
        out.write("// Success!\n");
        out.write("var data = null;\n");
        out.write("var manual_error = false;\n");
        out.write("if (request.responseText.length >= 2) {\n");
        out.write("data = JSON.parse(request.responseText)\n");
        out.write("} else {\n");
        out.write("manual_error = true;\n");
        out.write("document.getElementById(\"error\").textContent=(\"Server returned empty data!\")\n");
        out.write("}\n");
        out.write("if (data && data.motors) {\n");
        out.write("data.motors.forEach(function(motor, index) {\n");
        out.write("document.getElementById(motor.name+\"_encoder\").textContent=(motor.encoder);\n");
        out.write("document.getElementById(motor.name+\"_power\").textContent=(motor.power);\n");
        out.write("})\n");
        out.write("data.servos.forEach(function(servo, index){\n");
        out.write("document.getElementById(servo.name).textContent=(servo.position)\n");
        out.write("})\n");
        out.write("data.sensors.forEach(function(sensor, index) {\n");
        out.write("if (typeof(sensor.value.red) === 'number') {\n");
        out.write("// Color Sensor\n");
        out.write("document.getElementById(sensor.name+\"_red\").textContent=(sensor.value.red)\n");
        out.write("document.getElementById(sensor.name+\"_green\").textContent=(sensor.value.green)\n");
        out.write("document.getElementById(sensor.name+\"_blue\").textContent=(sensor.value.blue)\n");
        out.write("} else {\n");
        out.write("// Assuming touch sensors\n");
        out.write("document.getElementById(sensor.name).textContent=(sensor.value)\n");
        out.write("}\n");
        out.write("})\n");
        out.write("} else {\n");
        out.write("// No or broken data\n");
        out.write("}\n");
        out.write("if (data && data.error) {\n");
        out.write("document.getElementById(\"error\").textContent=(data.error)\n");
        out.write("console.log(\"Data: \"+data)\n");
        out.write("} else {\n");
        out.write("if (manual_error) {\n");
        out.write("} else {\n");
        out.write("document.getElementById(\"error\").textContent=\"\"\n");
        out.write("}\n");
        out.write("}\n");
        out.write("} else {\n");
        out.write("// We reached our target server, but it returned an error\n");
        out.write("}\n");
        out.write("};\n");
        out.write("\n");
        out.write("request.onerror = function() {\n");
        out.write("// There was a connection error of some sort\n");
        out.write("document.getElementById(\"error\").innerHTML=\"Connection Error Occurred. <br />Server might not be running or you're not connected to the phones wi-fi network.\"\n");
        out.write("};\n");
        out.write("\n");
        out.write("request.send();\n");
        out.write("}\n");
        out.write("\n");
        out.write("document.onreadystatechange = function () {\n");
        out.write("var state = document.readyState;\n");
        out.write("if (state == 'interactive') {\n");
        out.write("} else if (state == 'complete') {\n");
        out.write("console.log(\"Ready\")\n");
        out.write("window.setInterval(function() {\n");
        out.write("refreshTelemetry();\n");
        out.write("}, 100);\n");
        out.write("}\n");
        out.write("}\n");
        out.write("</script>\n");
        out.write("<style>\n");
        out.write("body {\n");
        out.write("background: #222;\n");
        out.write("color: white;\n");
        out.write("font-family: sans-serif;\n");
        out.write("text-shadow: 0 0 1pt black;\n");
        out.write("word-wrap: break-word;\n");
        out.write("}\n");
        out.write("p {\n");
        out.write("font-weight: bolder;\n");
        out.write("margin: 3pt;\n");
        out.write("}\n");
        out.write("h1 { margin: 1pt; }\n");
        out.write("h2 {\n");
        out.write("margin: 1pt;\n");
        out.write("text-align: center;\n");
        out.write("}\n");
        out.write("h3 { margin: 1pt; }\n");
        out.write("#name { font-size: 3em; margin: 1pt;}\n");
        out.write(".container {\n");
        out.write("float: left;\n");
        out.write("overflow: hidden;\n");
        out.write("display: block;\n");
        out.write("position: relative;\n");
        out.write("border: solid #080 2pt;\n");
        out.write("padding: 2pt;\n");
        out.write("margin: 0.5em;\n");
        out.write("height: 290pt;\n");
        out.write("border-radius: 3pt;\n");
        out.write("}\n");
        out.write("#robot {\n");
        out.write("overflow: hidden;\n");
        out.write("position: relative;\n");
        out.write("}\n");
        out.write("#robotBase {\n");
        out.write("width: 170pt;\n");
        out.write("height: 180pt;\n");
        out.write("background: #444;\n");
        out.write("margin: 1em;\n");
        out.write("padding: 0.5em;\n");
        out.write("}\n");
        out.write("#robotWinch {\n");
        out.write("width: 50pt;\n");
        out.write("height: 180pt;\n");
        out.write("background: #444;\n");
        out.write("margin: 1em;\n");
        out.write("padding: 0.5em;\n");
        out.write("}\n");
        out.write("#robotGrabbers {\n");
        out.write("width: 150pt;\n");
        out.write("height: 50pt;\n");
        out.write("background: #444;\n");
        out.write("margin: 1em;\n");
        out.write("padding: 0.5em;\n");
        out.write("}\n");
        out.write("#robotSensors {\n");
        out.write("background: #444;\n");
        out.write("margin: 1em;\n");
        out.write("padding: 0.5em;\n");
        out.write("float: left;\n");
        out.write("}\n");
        out.write("#robotServos {\n");
        out.write("background: #444;\n");
        out.write("margin: 1em;\n");
        out.write("padding: 0.5em;\n");
        out.write("}\n");
        out.write(".mini_container {\n");
        out.write("float: left;\n");
        out.write("position: relative;\n");
        out.write("height: 75%;\n");
        out.write("}\n");
        out.write(".top {\n");
        out.write("\n");
        out.write("}\n");
        out.write(".bottom {\n");
        out.write("position: absolute;\n");
        out.write("bottom: 2pt;\n");
        out.write("}\n");
        out.write(".red { color: red; }\n");
        out.write(".green { color: lime; }\n");
        out.write(".blue { color: blue; }\n");
        out.write("</style>\n");
        out.write("<title>Steward - Robot Telemetry</title>\n");
        out.write("</head>\n");
        out.write("<body>\n");
        out.write("<center>\n");
        out.write("<p id=\"name\">Steward</p>\n");
        out.write("<h1>Robot Telemetry</h1>\n");
        out.write("<h2 id=\"error\" class=\"red\"></h2>\n");
        out.write("</center>\n");
        out.write("<div id=\"robot\">\n");
        out.write("<div class=\"container\">\n");
        out.write("<h2>Drive Train</h2>\n");
        out.write("<div class=\"mini_container\">\n");
        out.write("<p>Front Left</p>\n");
        out.write("<p id=\"dcFrontLeft\" class=\"top\">Encoder: <span id=\"dcFrontLeft_encoder\">0</span><br/>Power: <span id=\"dcFrontLeft_power\">0.0</span></p>\n");
        out.write("<div class=\"bottom\">\n");
        out.write("<p>Back Left</p>\n");
        out.write("<p id=\"dcBackLeft\">Encoder: <span id=\"dcBackLeft_encoder\">0</span><br/>Power: <span id=\"dcBackLeft_power\">0.0</span></p>\n");
        out.write("</div>\n");
        out.write("</div>\n");
        out.write("<div id=\"robotBase\" class=\"mini_container\">\n");
        out.write("</div>\n");
        out.write("<div class=\"mini_container\">\n");
        out.write("<p>Front Right</p>\n");
        out.write("<p id=\"dcFrontRight\" class=\"top\">Encoder: <span id=\"dcFrontRight_encoder\">0</span><br/>Power: <span id=\"dcFrontRight_power\">0.0</span></p>\n");
        out.write("<div  class=\"bottom\">\n");
        out.write("<p>Back Right</p>\n");
        out.write("<p id=\"dcBackRight\">Encoder: <span id=\"dcBackRight_encoder\">0</span><br/>Power: <span id=\"dcBackRight_power\">0.0</span></p>\n");
        out.write("</div>\n");
        out.write("</div>\n");
        out.write("</div>\n");
        out.write("<div class=\"container\">\n");
        out.write("<h2>Winch</h2>\n");
        out.write("<div class=\"mini_container\">\n");
        out.write("<p>Arm</p>\n");
        out.write("<p id=\"dcArm\" class=\"topLeft\">Encoder: <span id=\"dcArm_encoder\">0</span><br/>Power: <span id=\"dcArm_power\">0.0</span></p>\n");
        out.write("</div>\n");
        out.write("<div id=\"robotWinch\" class=\"mini_container\">\n");
        out.write("</div>\n");
        out.write("<div class=\"mini_container\">\n");
        out.write("<p>Winch</p>\n");
        out.write("<p id=\"dcWinch\">Encoder: <span id=\"dcWinch_encoder\">0</span><br/>Power: <span id=\"dcWinch_power\">0.0</span></p>\n");
        out.write("</div>\n");
        out.write("</div>\n");
        out.write("<div class=\"container\">\n");
        out.write("<h2>Grabbers</h2>\n");
        out.write("<div class=\"mini_container\">\n");
        out.write("<p>Left Grabber</p>\n");
        out.write("<p id=\"dcLeftGrabber\">Encoder: <span id=\"dcLeftGrabber_encoder\">0</span><br/>Power: <span id=\"dcLeftGrabber_power\">0.0</span></p>\n");
        out.write("</div>\n");
        out.write("<div id=\"robotGrabbers\" class=\"mini_container\">\n");
        out.write("</div>\n");
        out.write("<div class=\"mini_container\">\n");
        out.write("<p>Right Grabber</p>\n");
        out.write("<p id=\"dcRightGrabber\">Encoder: <span id=\"dcRightGrabber_encoder\">0</span><br/>Power: <span id=\"dcRightGrabber_power\">0.0</span></p>\n");
        out.write("</div>\n");
        out.write("</div>\n");
        out.write("</div>\n");
        out.write("<div id=\"robot\">\n");
        out.write("<div class=\"container\">\n");
        out.write("<h2>Sensors</h2>\n");
        out.write("<div id=\"robotSensors\">\n");
        out.write("<h3>Color Sensors</h3>\n");
        out.write("<p id=\"colorSensor\">colorSensor: Red <span id=\"colorSensor_red\" class=\"red\">0.0</span>, Green <span id=\"colorSensor_green\" class=\"green\">0.0</span>, Blue <span id=\"colorSensor_blue\" class=\"blue\">0.0</span></p>\n");
        out.write("<hr/>\n");
        out.write("<h3>Touch Sensors</h3>\n");
        out.write("<p>flipperTouch <span id=\"flipperTouch\">True</span></p>\n");
        out.write("<p>beamTouch <span id=\"beamTouch\">True</span></p>\n");
        out.write("<p>winchTouch <span id=\"winchTouch\">True</span></p>\n");
        out.write("</div>\n");
        out.write("</div>\n");
        out.write("<div class=\"container\">\n");
        out.write("<h2>Servos</h2>\n");
        out.write("<div id=\"robotServos\">\n");
        out.write("<p>crBeam Position: <span id=\"crBeam\">0</span></p>\n");
        out.write("<p>crFlipper Position: <span id=\"crFlipper\">0</p>\n");
        out.write("<p>crRelic Position: <span id=\"crRelic\">0</span></p>\n");
        out.write("</div>\n");
        out.write("</div>\n");
        out.write("</div>\n");
        out.write("</body>\n");
        out.write("</html>\n");
    }
}
