package org.timecrafters.Darcshadowz.Engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

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
          addState(new DriveStraightForward(this, 0.3, 2400));
          addState(new TurnLeft(this, .2, 1025));
          addState(new DriveStraightForward(this, 0.3, 3150));
          addState(new TurnRight(this,0.2,1537));
          addState(new DriveStraightForward(this, 0.2, 500));
          addState(new ExtendArm(this, 1, 1700));
          addState(new LeftGrabber(this, .5, 500));
          addState(new RaiseArm(this, 1, 1950));
          addState(new TurnRight(this, 0.2, 2565));
          addState(new DriveStraightBackward(this, 0.3, 750));



        //left Column
  //      addState(new DriveStraightForward(this, .1, 2200));
  //      addState(new TurnLeft(this, .2, 1025));
  //      addState(new DriveStraightForward(this, 0.2, 1300)); // change to make smaller distance
  //      addState(new TurnRight(this,0.2,1025));
  //      addState(new DriveStraightForward(this, 0.1, 500));
  //      addState(new ExtendArm(this, 1, 1700));
   //     addState(new LeftGrabber(this, 0.5, 500));


        //Right Column
   //     addState(new DriveStraightForward(this, .1, 2200));
  //      addState(new TurnLeft(this, .2, 1025));
  //      addState(new DriveStraightForward(this, 0.2, 1300)); // change to make smaller distance
  //      addState(new TurnRight(this,0.2,1025));
  //      addState(new DriveStraightForward(this, 0.1, 500));
  //      addState(new ExtendArm(this, 1, 1700));
  //      addState(new LeftGrabber(this, 0.5, 500));


    }

}

