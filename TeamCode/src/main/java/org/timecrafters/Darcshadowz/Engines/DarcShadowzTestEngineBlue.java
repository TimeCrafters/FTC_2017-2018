package org.timecrafters.Darcshadowz.Engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.Darcshadowz.State.VeeringRight;
import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.Arm.ExtendArm;
import org.timecrafters.gfp.state.Arm.RaiseArm;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnLeft;
import org.timecrafters.gfp.state.drive.TurnRight;
import org.timecrafters.gfp.state.grabber.LeftGrabber;

/**
 * Created by Dylan on 11/14/2017.
 */

//1000Ticks = 23.5 Centimeters 23.5 cm

@Autonomous(name = "DYLAN TEST")
public class DarcShadowzTestEngineBlue extends Engine {

    public void setProcesses() {

          addState(new DriveStraightForward(this, .1, 2200));
          //addState(new ExtendArm(this, 1, 1000));
         // addState(new RaiseArm(this, 1, 2500));
          addState(new TurnLeft(this, .2, 1025));
          addState(new DriveStraightForward(this, 0.2, 1300));
          addState(new TurnRight(this,0.2,1025));
          addState(new DriveStraightForward(this, 0.1, 500));
          addState(new ExtendArm(this, 1, 1700));
   //       addState(new RaiseArm(this, -1, 1750));
          addState(new LeftGrabber(this, 0.5, 500));


    }

}

