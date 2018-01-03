package org.timecrafters.Liv.SubEngines;

import org.timecrafters.Liv.engines.RedBack;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.SubEngine;
import org.timecrafters.gfp.state.arm.ExtendArm;
import org.timecrafters.gfp.state.arm.RaiseArm;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnRight;
import org.timecrafters.gfp.state.grabber.LeftGrabber;

/**
 * Created by Liv on 1/2/2018.
 */

public class BlueBackCenter extends SubEngine{
    Engine engine;
    public BlueBackCenter(RedBack redBack) {
        this.engine=engine;
    }

    @Override
    public void setProcesses() {
        // center glyph goal
        addState(new DriveStraightForward(engine, 0.3, 4730));
        addState(new TurnRight(engine, 0.3, 1411));
        addState(new RaiseArm(engine, 1, 450));
        addState(new DriveStraightForward(engine, 0.3, 400));
        addState(new ExtendArm(engine, 0.5, 1290));
        addState(new LeftGrabber(engine, 0.5, 450));
        addState(new DriveStraightForward(engine, -0.5, 516));
        addState(new TurnRight(engine, 0.3, 1737));
        addState(new DriveStraightForward(engine, -0.3, 1000));
        addState(new DriveStraightForward(engine, 0.5, 860));
    }

    @Override
    public void evaluate() {
        setRunable(true);
    }
}
