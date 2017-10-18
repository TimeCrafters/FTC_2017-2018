package org.timecrafters.gfp.Teleop;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.Config;

/**
 * Created by t420 on 9/30/2017.
 */

public class DriveTrain extends Config {

    public DriveTrain(Engine engine){
        super(engine);
    }

    @Override
    public void exec(){



        dcFrontRight.setPower(engine.gamepad1.right_stick_y);
        dcBackRight.setPower(engine.gamepad1.right_stick_y);

        dcFrontLeft.setPower(-engine.gamepad1.left_stick_y);
        dcBackLeft.setPower(-engine.gamepad1.left_stick_y);
    }
}