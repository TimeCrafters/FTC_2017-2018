package org.timecrafters.Liv.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.Arm.ExtendArm;
import org.timecrafters.gfp.state.drive.DriveStraightBackward;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnLeft;
import org.timecrafters.gfp.state.drive.TurnRight;
import org.timecrafters.gfp.state.grabber.LeftGrabber;

/**
 * Created by Liv on 11/14/2017.
 */
@Autonomous(name="IDK")
public class TestEngineBlue extends Engine {

    @Override
    public void setProcesses() {
        addState(new DriveStraightForward(this,0.3,1400));
        addState(new TurnRight(this, 0.3, 160));
        addState(new ExtendArm(this, 0.2, 60));


    }



}

