package org.timecrafters.Liv.SubEngines;

import org.timecrafters.Darcshadowz.State.RightGrabber;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.SubEngine;
import org.timecrafters.gfp.state.arm.ExtendArm;
import org.timecrafters.gfp.state.arm.RaiseArm;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnLeft;
import org.timecrafters.gfp.state.drive.TurnRight;

/**
 * Created by Liv on 12/21/2017.
 */

public class RedBackLeft extends SubEngine{
    Engine engine;
    public RedBackLeft(Engine engine) {
        this.engine=engine;
    }

    @Override
    public void setProcesses() {
        addState(new DriveStraightForward(engine, 0.3, 3510));
        addState(new TurnRight(engine, 0.2, 533));
        addState(new RaiseArm(engine, 1, 450));
        addState(new DriveStraightForward(engine, 0.2, 290));
        addState(new ExtendArm(engine, 0.5, 1140));
        addState(new RightGrabber(engine, -0.5, 500));
        addState(new DriveStraightForward(engine, -0.5, 800));
        addState(new TurnLeft(this, 0.3, 430,));

    }

    @Override
    public void evaluate() {
        setRunable(true);
    }
}
