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

        //Right Grabber
        /*if(engine.gamepad2.right_bumper) {
            dcRightGrabber.setPower(upPower);

        }else if (engine.gamepad2.right_trigger > 0){
            dcRightGrabber.setPower(-upPower);
        }else{
            dcRightGrabber.setPower(0);
        }

        if(engine.gamepad2.left_bumper){
            dcLeftGrabber.setPower(-upPower);
        }else if(engine.gamepad2.left_trigger > 0){
            dcLeftGrabber.setPower(upPower);
        }else{
            dcLeftGrabber.setPower(0);
        }
*/
        dcRightGrabber.setPower(engine.gamepad2.right_stick_x);
        dcLeftGrabber.setPower(engine.gamepad2.left_stick_x);


    }
}