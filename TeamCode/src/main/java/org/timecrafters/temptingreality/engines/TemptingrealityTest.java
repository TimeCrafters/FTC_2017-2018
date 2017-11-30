package org.timecrafters.temptingreality.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.Arm.ExtendArm;
import org.timecrafters.gfp.state.Arm.RaiseArm;
import org.timecrafters.gfp.state.drive.DriveStraightForward;

/**
 * Created by t420-1 on 11/28/2017.
 */
@Autonomous(name = "cooldude")
public class TemptingrealityTest extends Engine {
    @Override
    public void setProcesses() {
        addState(new DriveStraightForward(this,.5,100));

        addState(new RaiseArm(this,1,400));

        addState(new ExtendArm(this,1,600));

    }
}
