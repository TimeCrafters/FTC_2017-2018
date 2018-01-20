package org.timecrafters.Liv.SubEngines;

import android.util.Log;

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
import org.timecrafters.gfp.state.drive.TurnRight;
import org.timecrafters.gfp.state.grabber.LeftGrabber;

import java.util.Objects;

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

        addState(new DriveStraightBackward(engine, 0.3, 4128));
        addState(new TurnRight(engine, 0.3, 1025));
        addState(new RaiseArm(engine, 1, 550));
        addState(new ExtendArm(engine, 0.5, 700));
        addState(new RightGrabber(engine, -0.5, 500));
        addState(new DriveStraightBackward(engine,   0.5, 500));
        addState(new TurnLeft(engine, 0.3, 2050));
        addState(new DriveStraightBackward(engine, 0.3, 300));
        addState(new DriveStraightForward(engine, 0.3, 100));
        addState(new RaiseArm(engine, -1, 550));

    }

    @Override
    public void evaluate() {
        Log.i(TAG, Objects.toString(this)+":"+Objects.toString(readCam.getVuMark()));
        if(readCam.getVuMark() == RelicRecoveryVuMark.LEFT) {
            setRunable(true);
        }
    }
}
