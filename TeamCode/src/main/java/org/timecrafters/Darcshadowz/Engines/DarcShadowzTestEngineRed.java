package org.timecrafters.Darcshadowz.Engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.Darcshadowz.State.RightGrabber;
import org.timecrafters.Darcshadowz.State.VeeringRight;
import org.timecrafters.Darcshadowz.SubEngines.Red.RedFrontCenterColumn;
import org.timecrafters.Darcshadowz.SubEngines.Red.RedFrontLeftColumn;
import org.timecrafters.Darcshadowz.SubEngines.Red.RedFrontRightColumn;
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
          addState(new DriveStraightForward(this, 0.15, 2500));
          addState(new TurnLeft(this, 0.3, 1000));//change from 1025 to 1000
          addState(new DriveStraightForward(this, 0.5, 3150));


     //     addSubEngine(new RedFrontRightColumn(this));

    //      addSubEngine(new RedFrontCenterColumn(this));

          addSubEngine(new RedFrontLeftColumn(this));

    }

}

