package org.timecrafters.gfp.Teleop;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.Config;

/**
 * Created by goldfishpi on 1/20/18.
 */

public class RelicGrabber extends Config {
    double power;
    public RelicGrabber(Engine engine,double power) {
        super(engine);
        this.power = power;
    }

    public void exec(){
        if(engine.gamepad2.dpad_up){
            crGrabber.setPower(power);
        }else if(engine.gamepad2.dpad_down){
            crGrabber.setPower(-power);
        }else{
            crGrabber.setPower(0.0);
        }
    }
}
