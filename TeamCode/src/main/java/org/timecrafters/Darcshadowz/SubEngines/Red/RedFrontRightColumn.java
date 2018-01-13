package org.timecrafters.Darcshadowz.SubEngines.Red;

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
 * Created by Dylan on 12/9/2017.
 */

public class RedFrontRightColumn extends SubEngine {
    Engine engine;
    public RedFrontRightColumn(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setProcesses() {
        addState(new DriveStraightForward(engine, 0.15, 2500));
        addState(new TurnLeft(engine, 0.3, 1000));
        addState(new DriveStraightForward(engine, 0.5, 3150));
        addState(new TurnRight(engine,0.3,1720));
        addState(new DriveStraightForward(engine, 0.5, 1100));
        addState(new ExtendArm(engine, 1, 2800));
        addState(new LeftGrabber(engine, 0.5, 500));
        addState(new RaiseArm(engine, 1, 1950));
        addState(new DriveStraightBackward(engine, 0.5, 700));
        addState(new TurnRight(engine, 0.3, 1750));
        addState(new DriveStraightBackward(engine, 0.5, 700));
        addState(new DriveStraightForward(engine, 0.5, 100));
        addState(new RaiseArm(engine,-1, 1950));
        addState(new ExtendArm(engine, 0, 0));

    }

    @Override
    public void evaluate() {
    //    setPreInit(true);
        setRunable(true);
    }
}
