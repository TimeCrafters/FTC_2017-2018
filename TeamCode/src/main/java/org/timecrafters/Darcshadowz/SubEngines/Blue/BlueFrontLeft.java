package org.timecrafters.Darcshadowz.SubEngines.Blue;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.timecrafters.Darcshadowz.State.RightGrabber;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.SubEngine;
import org.timecrafters.gfp.state.arm.ExtendArm;
import org.timecrafters.gfp.state.arm.RaiseArm;
import org.timecrafters.gfp.state.cam.ReadCam;
import org.timecrafters.gfp.state.drive.DriveStraightBackward;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnLeft;
import org.timecrafters.gfp.state.grabber.LeftGrabber;

/**
 * Created by Dylan on 12/17/2017.
 */

public class BlueFrontLeft extends SubEngine {
    Engine engine;
    ReadCam readCam;

    public BlueFrontLeft(Engine engine) {
        this.engine = engine;
        this.readCam = readCam;
    }

    ReadCam read = new ReadCam(engine);
    @Override
    public void setProcesses() {

        addState(new DriveStraightBackward(engine, 0.2, 1700));
        addState(new TurnLeft(engine, 0.3, 800));
        addState(new DriveStraightForward(engine, 0.5, 3000));
        addState(new TurnLeft(engine, 0.3, 1850));
        addState(new DriveStraightForward(engine, 0.5, 900));
        addState(new ExtendArm(engine, 1, 2000));
        addState(new RightGrabber(engine, -0.5, 500));
        addState(new RaiseArm(engine, 1, 1950));
        addState(new DriveStraightBackward(engine, 0.5, 500));
        addState(new TurnLeft(engine, 0.3, 1750));
        addState(new DriveStraightBackward(engine, 0.5, 500));
        addState(new DriveStraightForward(engine, 0.5, 200));
        addState(new RaiseArm(engine, -1, 1950));
        addState(new LeftGrabber(engine, 0.5, 500));
    }

    @Override
    public void evaluate() {
  //      setPreInit(true);
        if (readCam.getVuMark() == RelicRecoveryVuMark.LEFT)
        setRunable(true);

    }
}
