package org.timecrafters.gfp.config;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 9/14/2017.
 */

public class Config extends State {

    public Config(Engine engine){
        this.engine = engine;
    }

    public DcMotor dcRightGrabber;
    public DcMotor dcLeftGrabber;

    public DcMotor dcFrontRight;
    public DcMotor dcFrontLeft;
    public DcMotor dcBackRight;
    public DcMotor dcBackLeft;

    public DcMotor dcArm;

    public DcMotor dcWinch;

    public TouchSensor winchTouch;

    public OpticalDistanceSensor frontRightDistanceSensor;
    public OpticalDistanceSensor backRightDistanceSensor;
    public OpticalDistanceSensor frontDistanceSensor;

    long time = 100;


    public void init(){

        //Grabbers
        dcRightGrabber = engine.hardwareMap.dcMotor.get("dcRightGrabber");

        dcLeftGrabber = engine.hardwareMap.dcMotor.get("dcLeftGrabber");

        sleep(time);

        //Drive Train
        dcFrontLeft  = engine.hardwareMap.dcMotor.get("dcFrontLeft");
        dcFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dcFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        dcFrontRight = engine.hardwareMap.dcMotor.get("dcFrontRight");
        dcFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dcFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);

        dcBackRight  = engine.hardwareMap.dcMotor.get("dcBackRight");
        dcBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dcBackRight.setDirection(DcMotorSimple.Direction.REVERSE);


        dcBackLeft   = engine.hardwareMap.dcMotor.get("dcBackLeft");
        dcBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dcBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        dcWinch = engine.hardwareMap.dcMotor.get("dcWinch");
        dcWinch.setDirection(DcMotorSimple.Direction.REVERSE);
        dcWinch.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //dcWinch.setDirection(DcMotorSimple.Direction.REVERSE);

        dcArm = engine.hardwareMap.dcMotor.get("dcArm");
        dcArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dcArm.setDirection(DcMotorSimple.Direction.FORWARD);

        winchTouch = engine.hardwareMap.touchSensor.get("winchTouch");
        //frontRightDistanceSensor = engine.hardwareMap.get(OpticalDistanceSensor.class, "frontRightDistanceSensor");

    }

    public void exec(){
        setFinished(true);
    }

    public void sleep(long timems){
        try {
            Thread.sleep(timems);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
