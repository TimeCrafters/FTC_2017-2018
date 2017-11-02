package org.timecrafters.gfp.Teleop;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.Config;

/**
 * Created by t420 on 10/28/2017.
 */

public class Arm extends Config {

    double power;

    public Arm(Engine engine, double power){
        super(engine);
        this.power = power;
    }

    public void exec(){
        if(engine.gamepad2.dpad_down){
            dcArm.setPower(power);
        }else if (engine.gamepad2.dpad_up){
            dcArm.setPower(-power);
        }else{
            dcArm.setPower(0.0);
        }
    }
}
