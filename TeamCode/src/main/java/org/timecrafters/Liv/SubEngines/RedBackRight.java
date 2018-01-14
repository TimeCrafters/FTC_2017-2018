package org.timecrafters.Liv.SubEngines;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.timecrafters.Darcshadowz.State.RightGrabber;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.SubEngine;
import org.timecrafters.gfp.state.arm.ExtendArm;
import org.timecrafters.gfp.state.arm.RaiseArm;
import org.timecrafters.gfp.state.cam.ReadCam;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnRight;
import org.timecrafters.gfp.state.grabber.LeftGrabber;

/**
 * Created by Liv on 12/21/2017.
 */

public class RedBackRight  extends SubEngine{
    Engine engine;
    ReadCam readCam;

    public RedBackRight (Engine engine, ReadCam readCam) {
        this.engine=engine;
        this.readCam = readCam;
    }

    @Override
    public void setProcesses() {
        //Right glyph goal
        addState(new DriveStraightForward(engine, 0.2, 4930));
        addState(new TurnRight(engine, 0.2, 1580));
        addState(new RaiseArm(engine, 1, 450));
        addState(new DriveStraightForward(engine, 0.3, 430));
        addState(new ExtendArm(engine, 0.5, 1290));
        addState(new LeftGrabber(engine, 0.5, 450));
        addState(new DriveStraightForward(engine, -0.5, 516));
        addState(new TurnRight(engine, 0.3, 1537));
        addState(new DriveStraightForward(engine,  -0.3, 1000));
        addState(new DriveStraightForward(engine, 0.5, 860));

    }

    @Override
    public void evaluate() {
        if (readCam.getVuMark() == RelicRecoveryVuMark.RIGHT) {
            setRunable(true);
        }
    }}