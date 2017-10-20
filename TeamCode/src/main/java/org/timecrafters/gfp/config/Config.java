package org.timecrafters.gfp.config;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420 on 9/14/2017.
 */

public class Config extends State {

    public Config(Engine engine){
        this.engine = engine;
    }

    public DcMotor dcGrabberOne;
    public DcMotor dcGrabberTwo;

    public DcMotor dcFrontRight;
    public DcMotor dcFrontLeft;
    public DcMotor dcBackRight;
    public DcMotor dcBackLeft;

    public CRServo svWinch;


    public void init(){

        //Grabbers
        dcGrabberOne = engine.hardwareMap.dcMotor.get("dcGrabberOne");

        dcGrabberTwo = engine.hardwareMap.dcMotor.get("dcGrabberTwo");

        //Drive Train
            dcFrontRight = engine.hardwareMap.dcMotor.get("dcFrontRight");
            dcFrontLeft  = engine.hardwareMap.dcMotor.get("dcFrontLeft");

            dcBackRight  = engine.hardwareMap.dcMotor.get("dcBackRight");
            dcBackLeft   = engine.hardwareMap.dcMotor.get("dcBackLeft");

            /*svWinch = engine.hardwareMap.crservo.get("svWinch");*/


        //Reset Encoders
        /*dcGrabberOne.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        dcGrabberTwo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);*/
    }

    public void exec(){
        setFinished(true);
    }
}
