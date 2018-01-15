package org.timecrafters.Liv.SubEngines;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.timecrafters.Darcshadowz.State.RightGrabber;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.SubEngine;
import org.timecrafters.gfp.state.arm.ExtendArm;
import org.timecrafters.gfp.state.arm.RaiseArm;
import org.timecrafters.gfp.state.cam.ReadCam;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnLeft;
import org.timecrafters.gfp.state.drive.TurnRight;

/**
 * Created by Liv on 12/21/2017.
 */

public class RedBackLeft extends SubEngine{
    Engine engine;
    ReadCam readCam;
    public RedBackLeft(Engine engine, ReadCam readCam) {
        this.engine=engine;
        this.readCam = readCam;
    }

    @Override
    public void setProcesses() {
        addState(new DriveStraightForward(engine, 0.3, 4128));
        addState(new TurnRight(engine, 0.2, 1025));
        addState(new RaiseArm(engine, 1, 650));
        addState(new ExtendArm(engine, 0.5, 1140));
        addState(new RightGrabber(engine, -0.5, 450));
        addState(new DriveStraightForward(engine, -0.5, 800));
        addState(new TurnLeft(engine, 0.3, 860));
        addState(new DriveStraightForward(engine, 0.3, 500));
        addState(new TurnLeft(engine, 0.3, 450));
        addState(new DriveStraightForward(engine, -0.3, 430));

    }

    @Override
    public void evaluate() {
        if(readCam.getVuMark() == RelicRecoveryVuMark.LEFT) {
            setRunable(true);
        }
    }
}
