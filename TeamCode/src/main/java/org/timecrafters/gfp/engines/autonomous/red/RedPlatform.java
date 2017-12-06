package org.timecrafters.gfp.engines.autonomous.red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.Arm.ExtendArm;
import org.timecrafters.gfp.state.Arm.RaiseArm;
import org.timecrafters.gfp.state.cam.ReadCam;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnRight;
import org.timecrafters.gfp.state.grabber.LeftGrabber;

/**
 * Created by t420 on 11/2/2017.
 */


@Autonomous(name = "Red Front")
public class RedPlatform extends Engine {

    public void setProcesses(){

            ReadCam readCam = new ReadCam(this);


    }

}
