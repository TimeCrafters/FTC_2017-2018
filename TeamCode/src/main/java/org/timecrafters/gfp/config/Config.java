package org.timecrafters.gfp.config;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
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

    public CRServo svWinch;

    public TouchSensor winchTouch;


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

        svWinch = engine.hardwareMap.crservo.get("svWinch");
        //svWinch.setDirection(DcMotorSimple.Direction.REVERSE);

        dcArm = engine.hardwareMap.dcMotor.get("dcArm");

        winchTouch = engine.hardwareMap.touchSensor.get("winchTouch");

    }

    public void exec(){
        setFinished(true);
    }
}
