package org.timecrafters.Liv.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.drive.DriveStraightForward;

/**
 * Created by Liv on 11/14/2017.
 */
@Autonomous(name="IDK")
public class TestEngineBlue extends Engine {

    @Override
    public void setProcesses() {
        addState(new DriveStraightForward(this,0.4,1500));
    }
}
