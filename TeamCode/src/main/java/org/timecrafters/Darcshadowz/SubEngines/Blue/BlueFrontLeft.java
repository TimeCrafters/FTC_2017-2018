package org.timecrafters.Darcshadowz.SubEngines.Blue;

import org.timecrafters.Darcshadowz.State.RightGrabber;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.SubEngine;
import org.timecrafters.gfp.state.arm.ExtendArm;
import org.timecrafters.gfp.state.arm.RaiseArm;
import org.timecrafters.gfp.state.drive.DriveStraightBackward;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnLeft;

/**
 * Created by Dylan on 12/17/2017.
 */

public class BlueFrontLeft extends SubEngine {
    Engine engine;
    public BlueFrontLeft(Engine engine){this.engine = engine;}


    @Override
    public void setProcesses() {

        addState(new DriveStraightBackward(engine, 0.15, 2500));
        addState(new TurnLeft(engine, 0.3, 1000));
        addState(new DriveStraightForward(engine, 0.5, 3000));
        addState(new TurnLeft(engine, 0.3, 1725));
        addState(new DriveStraightForward(engine, 0.5, 1400));
        addState(new ExtendArm(engine, 1, 1200));
        addState(new RightGrabber(engine, 0.5, 500));
        addState(new RaiseArm(engine, 1, 1950));
        addState(new TurnLeft(engine, 0.3, 1750));
        addState(new DriveStraightBackward(engine, 0.5, 400));
        addState(new DriveStraightForward(engine, 0.5, 200));
        addState(new RaiseArm(engine, -1, 1950));
    }

    @Override
    public void evaluate() {setRunable(true);

    }
}
