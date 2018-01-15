package org.timecrafters.Darcshadowz.Engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.Liv.SubEngines.RedBumpLeft;
import org.timecrafters.Liv.SubEngines.RedBumpRight;
import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.HardWareConfig;
import org.timecrafters.gfp.engines.autonomous.jewelBump.Red.BlueBumpLeft;
import org.timecrafters.gfp.engines.autonomous.jewelBump.Red.BlueBumpRight;
import org.timecrafters.gfp.state.arm.ExtendArm;
import org.timecrafters.gfp.state.arm.RaiseArm;
import org.timecrafters.gfp.state.cam.ReadCam;
import org.timecrafters.gfp.state.color.ReadColor;
import org.timecrafters.gfp.state.drive.DriveStraightBackward;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.drive.TurnLeft;
import org.timecrafters.gfp.state.drive.TurnRight;
import org.timecrafters.gfp.state.grabber.LeftGrabber;
import org.timecrafters.gfp.state.jewelBump.Beam;
import org.timecrafters.gfp.state.jewelBump.Flipper;
import org.timecrafters.gfp.state.util.Sleep;

/**
 * Created by Dylan on 11/14/2017.
 */


@Autonomous(name = "DYLAN RED FRONT")
public class DarcShadowzTestEngineRed extends Engine {

    private ReadCam readCam;

    public void setProcesses() {

        readCam = new ReadCam(this);
        hardWareConfig = new HardWareConfig(this);
        addState(hardWareConfig);
        addState(readCam);

        ReadColor readColor = new ReadColor(this, 3, 5, 0);

        addState(new Beam(this, 1, 1500));
        addState(new Flipper(this, 1, 725));
        addState(new Beam(this, 1, 2500));
        addState(readColor);

        addSubEngine(new RedBumpLeft(this, readColor));
        addSubEngine(new RedBumpRight(this, readColor));

        addState(new Beam(this, -1, 2500));
        addState(new Flipper(this, -1, 750));
        addState(new Beam(this, -1, 1700));

        addState(new Sleep(this, 50));

        addState(new DriveStraightForward(this, 0.15, 2500));
        addState(new TurnLeft(this, 0.3, 1000));
        addState(new DriveStraightForward(this, 0.5, 3150));
        addState(new TurnRight(this, 0.3, 1650));
        addState(new DriveStraightForward(this, 0.5, 500));
        addState(new ExtendArm(this, 1, 2800));
        addState(new LeftGrabber(this, 0.5, 500));
        addState(new RaiseArm(this, 1, 1950));
        addState(new DriveStraightBackward(this, 0.5, 700));
        addState(new TurnRight(this, 0.3, 1750));
        addState(new DriveStraightBackward(this, 0.5, 700));
        addState(new DriveStraightForward(this, 0.5, 100));
        addState(new RaiseArm(this, -1, 1950));
        addState(new ExtendArm(this, 0, 0));


     //   addSubEngine(new RedFrontCenterColumn(this, readCam));

        //    addSubEngine(new RedFrontRightColumn(this, readCam));

     //   addSubEngine(new RedFrontLeftColumn(this, readCam));

    }

}