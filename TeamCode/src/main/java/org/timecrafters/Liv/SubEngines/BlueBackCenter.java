package org.timecrafters.Liv.SubEngines;

        import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
        import org.timecrafters.Darcshadowz.State.RightGrabber;
        import org.timecrafters.Liv.engines.BlueBack;
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
 * Created by Liv on 1/2/2018.
 */

public class BlueBackCenter extends SubEngine{
    Engine engine;
    ReadCam readCam;

    public BlueBackCenter(Engine engine, ReadCam readCam) {
        this.engine=engine;
        this.readCam = readCam;
    }

    @Override
    public void setProcesses() {
        // center glyph goal
        addState(new DriveStraightBackward(engine, 0.3, 3305));
        addState(new TurnRight(engine, 0.3, 410));
        addState(new RaiseArm(engine, 1, 650));
        addState(new DriveStraightForward(engine, 0.3, 400));
        addState(new ExtendArm(engine, 0.5, 1290));
        addState(new RightGrabber(engine, -0.5, 500));
        addState(new DriveStraightForward(engine, -0.5, 516));
        addState(new TurnLeft(engine, 0.3, 1737));
        addState(new DriveStraightForward(engine, -0.3, 850));
        addState(new DriveStraightForward(engine, 0.5, 860));
    }

    @Override
    public void evaluate() {
        if (readCam.getVuMark() == RelicRecoveryVuMark.LEFT) {
            setRunable(true);
        }
    }}