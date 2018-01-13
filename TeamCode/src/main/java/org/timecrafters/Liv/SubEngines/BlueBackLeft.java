package org.timecrafters.Liv.SubEngines;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.SubEngine;
import org.timecrafters.gfp.state.arm.ExtendArm;
import org.timecrafters.gfp.state.arm.RaiseArm;
import org.timecrafters.gfp.state.cam.ReadCam;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnLeft;
import org.timecrafters.gfp.state.grabber.LeftGrabber;

/**
 * Created by Liv on 1/2/2018.
 */

public class BlueBackLeft extends SubEngine{
    Engine engine;
    ReadCam readCam;
    public BlueBackLeft(Engine engine, ReadCam readCam) {
        this.engine=engine;
        this.readCam = readCam;
    }

    @Override
    public void setProcesses() {

        addState(new DriveStraightForward(engine, -0.3, 3510));
        addState(new TurnLeft(engine, 0.3, 2564));
        addState(new RaiseArm(engine, 1, 750));
        addState(new ExtendArm(engine, 0.5, 1140));
        addState(new LeftGrabber(engine, 0.5, 465));
        addState(new DriveStraightForward(engine,   -0.5, 800));
        addState(new TurnLeft(engine, 0.3, 2050));
        addState(new DriveStraightForward(engine, -0.3, 500));
        addState(new DriveStraightForward(engine, 0.3, 430));
        addState(new RaiseArm(engine, -1, 650));

    }

    @Override
    public void evaluate() {
        if(readCam.getVuMark() == RelicRecoveryVuMark.LEFT) {
            setRunable(true);
        }
    }
}
