package org.timecrafters.Liv.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

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
public class RedBack extends Engine{
    @Override
    public void setProcesses() {
        switch (2) {
            case 1:
                // center glyph goal (WORKING!!!!!)
                addState(new DriveStraightForward(this, 0.3, 4730));
                addState(new TurnRight(this, 0.3, 1411));
                addState(new RaiseArm(this, 1, 450));
                addState(new DriveStraightForward(this, 0.3, 400));
                addState(new ExtendArm(this, 0.5, 1290));
                addState(new LeftGrabber(this, 0.5, 450));
                addState(new DriveStraightForward(this, -0.5, 516));
                addState(new TurnRight(this, 0.3, 1737));
                addState(new DriveStraightForward(this, -0.3, 1000));
                addState(new DriveStraightForward(this, 0.5, 860));
                break;
            case 2:
                //Right glyph goal
                addState(new DriveStraightForward(this, 0.2, 4930));
                addState(new TurnRight(this, 0.2, 1580));
                addState(new RaiseArm(this, 1, 450));
                addState(new DriveStraightForward(this, 0.3, 430));
                addState(new ExtendArm(this, 0.5, 1290));
                addState(new LeftGrabber(this, 0.5, 450));
                addState(new DriveStraightForward(this, -0.5, 516));
                addState(new TurnRight(this, 0.3, 1537));
                addState(new DriveStraightForward(this,  -0.3, 1000));
                addState(new DriveStraightForward(this, 0.5, 861));
            default:
                break;
            case 3:
                //Left glyph goal
                addState(new DriveStraightForward(this, 0.2, 4930));
                addState(new TurnRight(this, 0.2, 1481));
                addState(new RaiseArm(this, 1, 1950));
                addState(new ExtendArm(this, 0.5, 1290));
                addState(new LeftGrabber(this, 0.5, 450));
                addState(new DriveStraightForward(this, -0.5, 516));
                addState(new RaiseArm(this, 1, 1950));
                addState(new TurnRight(this, 0.3, 1537));
                addState(new DriveStraightForward(this,  -0.3, 1000));
                addState(new DriveStraightForward(this, 0.5, 860));



        }
    }

}
