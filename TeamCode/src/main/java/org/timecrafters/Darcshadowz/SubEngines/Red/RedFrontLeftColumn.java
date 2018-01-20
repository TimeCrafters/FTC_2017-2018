package org.timecrafters.Darcshadowz.SubEngines.Red;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
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

/**
 * Created by Dylan on 12/9/2017.
 */

public class RedFrontLeftColumn extends SubEngine {
    Engine engine;
    ReadCam readCam;
    public RedFrontLeftColumn(Engine engine, ReadCam readCam){
        this.engine = engine;
        this.readCam = readCam;
    }

    ReadCam read = new ReadCam(engine);
    @Override


    public void setProcesses() {

        addState(new TurnRight(engine,0.3,1500));
        addState(new DriveStraightForward(engine, 0.5, 500));
        addState(new ExtendArm(engine, 1, 2100));
        addState(new LeftGrabber(engine, 0.5, 500));
        addState(new RaiseArm(engine, 1, 1950));
        addState(new DriveStraightBackward(engine, 0.5, 300));
        addState(new TurnRight(engine, 0.3, 1400));
        addState(new DriveStraightBackward(engine, 0.5, 350));
        addState(new DriveStraightForward(engine, 0.5, 100));
        addState(new RaiseArm(engine,-1, 1950));
        addState(new ExtendArm(engine, 0, 0));

    }
    @Override
    public void evaluate() {
  //      setPreInit(true);
        /*if(readCam.getVuMark() == RelicRecoveryVuMark.LEFT)
        setRunable(true);*/
    }
}
