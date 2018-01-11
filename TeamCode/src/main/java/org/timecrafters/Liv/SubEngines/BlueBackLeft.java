package org.timecrafters.Liv.SubEngines;

import org.timecrafters.Darcshadowz.State.RightGrabber;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.SubEngine;
import org.timecrafters.gfp.state.arm.ExtendArm;
import org.timecrafters.gfp.state.arm.RaiseArm;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnLeft;
import org.timecrafters.gfp.state.drive.TurnRight;
import org.timecrafters.gfp.state.grabber.LeftGrabber;

/**
 * Created by Liv on 1/2/2018.
 */

public class BlueBackLeft extends SubEngine{
    Engine engine;
    public BlueBackLeft(Engine engine) {
        this.engine=engine;
    }

    @Override
    public void setProcesses() {
        addState(new DriveStraightForward(engine, -0.3, 3510));
        addState(new TurnLeft(engine, 0.3, 2553));
        addState(new RaiseArm(engine, 1, 650));
        addState(new ExtendArm(engine, 0.5, 1140));
        addState(new LeftGrabber(engine, -0.5, 450));
        addState(new DriveStraightForward(engine,   -0.5, 800));
        addState(new TurnLeft(engine, 0.3, 2050));
        addState(new DriveStraightForward(engine, -0.3, 500));
        addState(new DriveStraightForward(engine, 0.3, 430));
        addState(new RaiseArm(engine, -1, 650));

    }

    @Override
    public void evaluate() {
        setRunable(true);
    }
}
