package org.timecrafters.Liv.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.Darcshadowz.State.RightGrabber;
import org.timecrafters.Liv.SubEngines.BlueBackCenter;
import org.timecrafters.Liv.SubEngines.RedBackCenter;
import org.timecrafters.Liv.SubEngines.RedBackLeft;
import org.timecrafters.Liv.SubEngines.RedBackRight;
import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.arm.*;
import org.timecrafters.gfp.state.drive.DriveStraightBackward;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnLeft;
import org.timecrafters.gfp.state.drive.TurnRight;
import org.timecrafters.gfp.state.grabber.LeftGrabber;

/**
 * Created by Liv on 12/5/2017.
 */


@Autonomous(name="Red Back")
public class RedBack extends Engine {


    public void setProcesses() {

        switch (1) {
            case 1:
                addSubEngine(new RedBackLeft(this));
                break;
            case 2:
                addSubEngine(new RedBackCenter(this));
                break;
            case 3:
                addSubEngine(new RedBackRight(this));





        }

        }
    }


