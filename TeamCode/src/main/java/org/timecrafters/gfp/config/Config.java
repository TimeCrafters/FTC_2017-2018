package org.timecrafters.gfp.config;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
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

    public DcMotor dcWinch;

    public TouchSensor winchTouch;
    public TouchSensor flipperTouch;
    public TouchSensor beamTouch;

    public ModernRoboticsI2cRangeSensor frontRightDistanceSensor;
    public ModernRoboticsI2cRangeSensor backRightDistanceSensor;
    public ModernRoboticsI2cRangeSensor frontDistanceSensor;

    public CRServo crFlipper;
    public CRServo crBeam;
    public CRServo crGrabber;

    public ColorSensor colorSensor;

    long time = 100;


    public void init(){

        //Grabbers
        dcRightGrabber = engine.hardwareMap.dcMotor.get("dcRightGrabber");

        dcLeftGrabber = engine.hardwareMap.dcMotor.get("dcLeftGrabber");

//        sleep(time);

        //Drive Train
        dcFrontLeft  = engine.hardwareMap.dcMotor.get("dcFrontLeft");
        dcFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dcFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        dcFrontRight = engine.hardwareMap.dcMotor.get("dcFrontRight");
        dcFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dcFrontRight.setDirection(DcMotorSimple.Direction.FORWARD);

        dcBackRight  = engine.hardwareMap.dcMotor.get("dcBackRight");
        dcBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dcBackRight.setDirection(DcMotorSimple.Direction.FORWARD);


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

        //winchTouch = engine.hardwareMap.touchSensor.get("winchTouch");
        flipperTouch = engine.hardwareMap.touchSensor.get("flipperTouch");
        beamTouch = engine.hardwareMap.touchSensor.get("beamTouch");

        //frontRightDistanceSensor = engine.hardwareMap.get(ModernRoboticsI2cRangeSensor.class,
        //        "frontRightDistanceSensor");

        colorSensor = engine.hardwareMap.colorSensor.get("colorSensor");

        crFlipper = engine.hardwareMap.crservo.get("crFlipper");
        crBeam = engine.hardwareMap.crservo.get("crBeam");
        crGrabber = engine.hardwareMap.crservo.get("crGrabber");


    }

    public void exec(){
        setFinished(true);
    }

}
