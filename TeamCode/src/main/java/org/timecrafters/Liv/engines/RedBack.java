package org.timecrafters.Liv.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.arm.*;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnRight;

/**
 * Created by Liv on 12/5/2017.
 */
@Autonomous(name="Red Back")
public class RedBack extends Engine{
    @Override
    public void setProcesses() {
        addState(new DriveStraightForward(this, 0.2, 4085 ));
        addState(new TurnRight(this, 0.2, 1281));
        addState(new ExtendArm(this, 0.5, 860));



    }
}
