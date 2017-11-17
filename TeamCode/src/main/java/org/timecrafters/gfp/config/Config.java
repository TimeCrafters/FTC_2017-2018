package org.timecrafters.gfp.config;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.I2cDevice;
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

    public I2cDevice frontRightSensor;
    public I2cDevice frontLeftSensor;
    public I2cDevice frontSensor;


    public void init(){

        //Grabbers
        dcRightGrabber = engine.hardwareMap.dcMotor.get("dcRightGrabber");

        dcLeftGrabber = engine.hardwareMap.dcMotor.get("dcLeftGrabber");

        //Drive Train
        dcFrontRight = engine.hardwareMap.dcMotor.get("dcFrontRight");
        dcFrontLeft  = engine.hardwareMap.dcMotor.get("dcFrontLeft");

        dcBackRight  = engine.hardwareMap.dcMotor.get("dcBackRight");
        dcBackLeft   = engine.hardwareMap.dcMotor.get("dcBackLeft");

        dcBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        dcFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        dcWinch = engine.hardwareMap.dcMotor.get("dcWinch");
        dcWinch.setDirection(DcMotorSimple.Direction.REVERSE);
        dcWinch.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //dcWinch.setDirection(DcMotorSimple.Direction.REVERSE);

        dcArm = engine.hardwareMap.dcMotor.get("dcArm");
        dcArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dcArm.setDirection(DcMotorSimple.Direction.FORWARD);

        winchTouch = engine.hardwareMap.touchSensor.get("winchTouch");

    }

    public void exec(){
        setFinished(true);
    }
}
