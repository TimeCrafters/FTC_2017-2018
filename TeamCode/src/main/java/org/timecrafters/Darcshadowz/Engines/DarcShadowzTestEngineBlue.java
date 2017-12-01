package org.timecrafters.Darcshadowz.Engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.Darcshadowz.State.VeeringRight;
import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.drive.DriveStraightForward;

/**
 * Created by Dylan on 11/14/2017.
 */



@Autonomous(name = "DYLAN TEST")
public class DarcShadowzTestEngineBlue extends Engine {

    public void setProcesses() {

  //      addState(new VeeringRight(this));
     addState(new DriveStraightForward(this, 1.0, 500));
//        addState(new RaiseArm(this, 1, 500));
//        addState(new ExtendArm(this, 1, 1550));
//        addState(new LeftGrabber(this, 0.5, 150));
//        addState(new DriveStraightBackward(this, .2, 500));
//        addState(new TurnLeft(this, .3, 750));
//        addState(new RaiseArm(this, -0.5, 500));
//        addState(new DriveStraightForward(this, .3, 1000));


    }

}

