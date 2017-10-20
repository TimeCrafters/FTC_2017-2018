package org.timecrafters.gfp.Teleop;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.Config;

/**
 * Created by t420 on 10/19/2017.
 */

public class Grabbers extends Config {


    double power;
    public Grabbers(Engine engine,double power){
        super(engine);
        this.power = power;
    }

    @Override
    public void exec(){

        //Grabbers Out
        if(engine.gamepad1.b) {
            dcGrabberOne.setPower(power);
            dcGrabberTwo.setPower(-power);
        }
        // Grabbers In
        else if(engine.gamepad1.x){
            dcGrabberOne.setPower(-power);
            dcGrabberTwo.setPower(power);
        }
        else{
            dcGrabberOne.setPower(0.0);
            dcGrabberTwo.setPower(0.0);
        }

    }
}