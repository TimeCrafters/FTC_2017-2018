package org.timecrafters.Darcshadowz.Engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.Darcshadowz.State.RightGrabber;
import org.timecrafters.Darcshadowz.State.VeeringRight;
import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.arm.ExtendArm;
import org.timecrafters.gfp.state.arm.RaiseArm;
import org.timecrafters.gfp.state.drive.DriveStraightBackward;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnLeft;
import org.timecrafters.gfp.state.drive.TurnRight;
import org.timecrafters.gfp.state.grabber.LeftGrabber;

/**
 * Created by Dylan on 11/14/2017.
 */

//1000Ticks = 23.5CM

@Autonomous(name = "DYLAN TEST")
public class DarcShadowzTestEngineRed extends Engine {

    public void setProcesses() {

        //center Column
          addState(new DriveStraightForward(this, 0.15, 2400));
          addState(new TurnLeft(this, .2, 1000));//change from 1025 to 1000
          addState(new DriveStraightForward(this, 0.3, 3150));
          addState(new TurnRight(this,0.2,1600));//change from 1537 to 1600
          addState(new DriveStraightForward(this, 0.2, 1000));
          addState(new ExtendArm(this, 1, 1200));
          addState(new LeftGrabber(this, .5, 500));
          addState(new RaiseArm(this, 1, 1950));
          addState(new TurnRight(this, 0.2, 2000));//chancge from 2565 to 2000
          addState(new DriveStraightBackward(this, 0.3, 950));
          addState(new DriveStraightForward(this, 0.1, 200));
          addState(new RaiseArm(this,-1, 1950));



        //left Column
//        addState(new DriveStraightForward(this, 0.15, 2400));
//        addState(new TurnLeft(this, .2, 1000));//change from 1025 to 1000
//        addState(new DriveStraightForward(this, 0.3, 3150));
//        addState(new TurnRight(this,0.2,1600));//change from 1537 to 1600
//        addState(new DriveStraightForward(this, 0.2, 1000));
//        addState(new ExtendArm(this, 1, 1200));
//        addState(new LeftGrabber(this, .5, 500));
//        addState(new RaiseArm(this, 1, 1950));
//        addState(new TurnRight(this, 0.2, 2000));//chancge from 2565 to 2000
//        addState(new DriveStraightBackward(this, 0.3, 950));
//        addState(new DriveStraightForward(this, 0.1, 200));
//        addState(new RaiseArm(this,-1, 1950));


        //Right Column
//          addState(new DriveStraightForward(this, 0.15, 2400));
//          addState(new TurnLeft(this, .2, 1000));//change from 1025 to 1000
//          addState(new DriveStraightForward(this, 0.3, 3150));
//          addState(new TurnRight(this,0.2,1625));//change from 1537 to 1625
//          addState(new DriveStraightForward(this, 0.2, 1000));
//          addState(new ExtendArm(this, 1, 1200));
//          addState(new LeftGrabber(this, .5, 500));
//          addState(new RaiseArm(this, 1, 1950));
//          addState(new TurnRight(this, 0.2, 2465));//chancge from 2565 to 2465
//          addState(new DriveStraightBackward(this, 0.3, 950));
//          addState(new DriveStraightForward(this, 0.1, 200));
//          addState(new RaiseArm(this,-1, 1950));

    }

}

