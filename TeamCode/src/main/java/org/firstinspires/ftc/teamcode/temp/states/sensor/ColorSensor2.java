package org.firstinspires.ftc.teamcode.temp.states.sensor;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 5/5/2018.
 */

public class ColorSensor2 extends State {
    private ColorSensor colorSensor;
    private DcMotor motor1;
    private int colorSensorRed;
    private TouchSensor touchSensor;
    private int colorSensorBlue;
    private DcMotor motor2;
    private Servo servo1;
    private long howLong;
    private boolean isPressed ;

    public ColorSensor2(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void init() {
        super.init();
        colorSensor = engine.hardwareMap.colorSensor.get("color");
        motor1 = engine.hardwareMap.dcMotor.get("motor1");
        motor2 = engine.hardwareMap.dcMotor.get("motor2");
        touchSensor = engine.hardwareMap.touchSensor.get("touch1");
        motor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        servo1 = engine.hardwareMap.servo.get("servo1");
        isPressed = false;
        howLong = 0;
    }

    @Override
    public void exec() {
        colorSensorRed = colorSensor.red();
        colorSensorBlue = colorSensor.blue();

        engine.telemetry.addData("red", colorSensor.red());
        engine.telemetry.addData("blue", colorSensor.blue());
        engine.telemetry.update();

        if (!touchSensor.isPressed()) {
            isPressed = false;
            servo1.setPosition(-1);
            motor1.setPower(colorSensorRed / 15.0);
            motor2.setPower((-1 * colorSensorBlue) / 15.0);


        } else if (touchSensor.isPressed()) {
            if (!isPressed) {
                howLong = System.currentTimeMillis();
            }
            isPressed = true;
            motor1.setPower((-1 * colorSensorBlue) / 15.0);
            motor2.setPower(colorSensorRed / 15.0);
        }
        if (isPressed) {
            if (System.currentTimeMillis() > howLong+2_000) {
                servo1.setPosition(1);
            }
        }
    }
}
