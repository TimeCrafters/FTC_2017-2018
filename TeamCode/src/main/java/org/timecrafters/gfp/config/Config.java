package org.timecrafters.gfp.config;

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


    public void init(){
        dcGrabberOne = engine.hardwareMap.dcMotor.get("dcGrabberOne");

        dcGrabberTwo = engine.hardwareMap.dcMotor.get("dcGrabberTwo");

        //Reset Encoders
        dcGrabberOne.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        dcGrabberTwo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void exec(){
        setFinished(true);
    }
}
