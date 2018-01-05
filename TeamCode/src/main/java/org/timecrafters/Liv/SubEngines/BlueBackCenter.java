package org.timecrafters.Liv.SubEngines;

import org.timecrafters.Darcshadowz.State.RightGrabber;
import org.timecrafters.Liv.engines.BlueBack;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.SubEngine;
import org.timecrafters.gfp.state.arm.ExtendArm;
import org.timecrafters.gfp.state.arm.RaiseArm;
import org.timecrafters.gfp.state.drive.DriveStraightBackward;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnLeft;
import org.timecrafters.gfp.state.drive.TurnRight;
import org.timecrafters.gfp.state.grabber.LeftGrabber;

/**
 * Created by Liv on 1/2/2018.
 */

public class BlueBackCenter extends SubEngine{
    Engine engine;
    public BlueBackCenter(Engine engine) {
        this.engine=engine;
    }

    @Override
    public void setProcesses() {
        // center glyph goal
        addState(new DriveStraightBackward(engine, 0.3, 3731));
        addState(new TurnLeft(engine, 0.3, 1411));
        addState(new RaiseArm(engine, 1, 450));
        addState(new DriveStraightForward(engine, 0.3, 400));
        addState(new ExtendArm(engine, 0.5, 1290));
        addState(new RightGrabber(engine, 0.5, 450));
        addState(new DriveStraightForward(engine, -0.5, 516));
        addState(new TurnLeft(engine, 0.3, 1737));
        addState(new DriveStraightForward(engine, -0.3, 1000));
        addState(new DriveStraightForward(engine, 0.5, 860));
    }

    @Override
    public void evaluate() {
        setRunable(true);
    }
}
