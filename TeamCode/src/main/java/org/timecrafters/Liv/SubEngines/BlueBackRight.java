package org.timecrafters.Liv.SubEngines;

import org.timecrafters.Darcshadowz.State.RightGrabber;
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

public class BlueBackRight extends SubEngine {
    Engine engine;
    public BlueBackRight(Engine engine) {
        this.engine=engine;
    }

    @Override
    public void setProcesses() {
        //Right glyph goal
        addState(new DriveStraightForward(engine, -0.3, 4930));
        addState(new TurnRight(engine, 0.2, 390));
        addState(new RaiseArm(engine, 1, 450));
        addState(new DriveStraightForward(engine, 0.3, 430));
        addState(new ExtendArm(engine, 0.5, 1290));
        addState(new RightGrabber(engine, 0.5, 450));
        addState(new DriveStraightBackward(engine, 0.3, 500));
        addState(new TurnLeft(engine, 0.3, 2050));
        addState(new DriveStraightForward(engine, -0.3, 490));
        addState(new DriveStraightForward(engine, 0.3, 250));


    }

    @Override
    public void evaluate() {setRunable(true);

    }
}

