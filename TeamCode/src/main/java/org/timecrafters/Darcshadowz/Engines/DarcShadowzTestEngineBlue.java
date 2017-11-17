package org.timecrafters.Darcshadowz.Engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.drive.DriveStraightForward;

/**
 * Created by Dylan on 11/14/2017.
 */


@Autonomous(name = "DYLAN TEST")
public class DarcShadowzTestEngineBlue extends Engine {

    public void setProcesses() {
        addState(new DriveStraightForward(this, .3, 1500));





    }

}

