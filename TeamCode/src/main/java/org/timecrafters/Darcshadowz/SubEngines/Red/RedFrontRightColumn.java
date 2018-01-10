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
        addState(new TurnLeft(engine, 0.3, 1000));//change from 1025 to 1000
        addState(new DriveStraightForward(engine, 0.5, 3150));
        addState(new TurnRight(engine,0.3,1725));//change from 1537 to 1650
        addState(new DriveStraightForward(engine, 0.5, 1400));
        addState(new ExtendArm(engine, 1, 1200));
        addState(new LeftGrabber(engine, 0.5, 500));
        addState(new RaiseArm(engine, 1, 1950));
        addState(new TurnRight(engine, 0.3, 1750));//chancge from 2565 to 1700
        addState(new DriveStraightBackward(engine, 0.5, 650));
        addState(new DriveStraightForward(engine, 0.5, 500));
        addState(new RaiseArm(engine,-1, 1950));
        addState(new ExtendArm(engine, 0, 0));

    }

    @Override
    public void evaluate() {
        setPreInit(true);
        setRunable(true);
    }
}
