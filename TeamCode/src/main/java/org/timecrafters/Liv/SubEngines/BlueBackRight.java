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

public class BlueBackRight extends SubEngine {
    Engine engine;
    ReadCam readCam;

    public BlueBackRight(Engine engine, ReadCam readCam) {
        this.engine=engine;
        this.readCam = readCam;
    }

    @Override
    public void setProcesses() {
        //Right glyph goal
        addState(new DriveStraightForward(engine, -0.3, 4128));
        addState(new TurnRight(engine, 0.2, 410));
        addState(new RaiseArm(engine, 1, 560));
        addState(new DriveStraightForward(engine, 0.3, 430));
        addState(new ExtendArm(engine, 0.5, 1390));
        addState(new RightGrabber(engine, -0.5, 500));
        addState(new DriveStraightBackward(engine, 0.3, 500));
        addState(new TurnLeft(engine, 0.3, 2050));
        addState(new DriveStraightForward(engine, -0.3, 490));
        addState(new DriveStraightForward(engine, 0.3, 250));
        addState(new RaiseArm(engine, -1, 5060));
    }

    @Override
    public void evaluate() {
        Log.i(TAG, Objects.toString(this)+":"+Objects.toString(readCam.getVuMark()));
        if (readCam.getVuMark() == RelicRecoveryVuMark.RIGHT) {
            setRunable(true);
        }
    }
}
