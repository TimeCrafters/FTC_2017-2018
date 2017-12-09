package org.timecrafters.Darcshadowz.SubEngines.Red;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.SubEngine;
import org.timecrafters.gfp.state.arm.ExtendArm;
import org.timecrafters.gfp.state.arm.RaiseArm;
import org.timecrafters.gfp.state.drive.DriveStraightBackward;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnRight;
import org.timecrafters.gfp.state.grabber.LeftGrabber;

/**
 * Created by Dylan on 12/9/2017.
 */

public class RedFrontLeftColumn extends SubEngine {
    Engine engine;
    public RedFrontLeftColumn(Engine engine){
        this.engine = engine;
    }
    @Override
    public void setProcesses() {
        addState(new TurnRight(engine,0.2,1600));//change from 1537 to 1600
        addState(new DriveStraightForward(engine, 0.2, 1000));
        addState(new ExtendArm(engine, 1, 1200));
        addState(new LeftGrabber(engine, .5, 500));
        addState(new RaiseArm(engine, 1, 1950));
        addState(new TurnRight(engine, 0.2, 2000));//chancge from 2565 to 2000
        addState(new DriveStraightBackward(engine, 0.3, 950));
        addState(new DriveStraightForward(engine, 0.1, 200));
        addState(new RaiseArm(engine,-1, 1950));

    }

    @Override
    public void evaluate() {
        setRunable(true);
    }
}
