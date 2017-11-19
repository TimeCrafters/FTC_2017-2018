package org.timecrafters.Darcshadowz.Engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.Arm.ExtendArm;
import org.timecrafters.gfp.state.Arm.RaiseArm;
import org.timecrafters.gfp.state.drive.DriveStraightBackward;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnLeft;
import org.timecrafters.gfp.state.grabber.LeftGrabber;

/**
 * Created by Dylan on 11/14/2017.
 */

//84.24 ticks = 1" IMPORTANT!!!!!!!!


@Autonomous(name = "DYLAN TEST")
public class DarcShadowzTestEngineBlue extends Engine {

    public void setProcesses() {
        addState(new DriveStraightForward(this, .2, 1853)); // 22" * 84.24 = 1853.28
//        addState(new RaiseArm(this, 1, 500));
//        addState(new ExtendArm(this, 1, 1550));
//        addState(new LeftGrabber(this, 0.5, 150));
//        addState(new DriveStraightBackward(this, .2, 500));
//        addState(new TurnLeft(this, .3, 750));
//        addState(new RaiseArm(this, -0.5, 500));
//        addState(new DriveStraightForward(this, .3, 1000));

    }

}

