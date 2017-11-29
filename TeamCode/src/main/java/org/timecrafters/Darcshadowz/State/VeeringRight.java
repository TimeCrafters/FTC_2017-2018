package org.timecrafters.Darcshadowz.State;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;
import org.timecrafters.gfp.config.Config;

/**
 * Created by Dylan on 11/28/2017.
 */

public class VeeringRight extends Config {

public VeeringRight(Engine engine) {
super(engine);
}

    @Override
    public void exec() {

        dcFrontLeft.setPower(.25);
        dcFrontRight.setPower(.75);
        dcBackLeft.setPower(.25);
        dcBackRight.setPower(.75);

        if(dcFrontRight.getCurrentPosition()>= 1000){
            dcFrontLeft.setPower(0);
            dcFrontRight.setPower(0);
            dcBackLeft.setPower(0);
            dcBackRight.setPower(0);
            setFinished(true);
        }


    }
}
