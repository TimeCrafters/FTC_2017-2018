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


     //     addSubEngine(new RedFrontRightColumn(this));

    //      addSubEngine(new RedFrontCenterColumn(this));

          addSubEngine(new RedFrontLeftColumn(this));

    }

}

