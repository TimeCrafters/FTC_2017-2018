package org.timecrafters.Darcshadowz.Engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.Darcshadowz.SubEngines.Red.RedFrontCenterColumn;
import org.timecrafters.Darcshadowz.SubEngines.Red.RedFrontLeftColumn;
import org.timecrafters.Darcshadowz.SubEngines.Red.RedFrontRightColumn;
import org.timecrafters.Liv.SubEngines.BlueBumpRight;
import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.HardWareConfig;
import org.timecrafters.gfp.engines.autonomous.jewelBump.Red.RedBumpLeft;
import org.timecrafters.gfp.engines.autonomous.jewelBump.Red.RedBumpRight;
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

        addState(new Beam(this, -1, 1500));
        addState(new Flipper(this, 1, 725));
        addState(new Beam(this, -1, 2500));

//        addState(new ReadColor(this, 3, 5, 0));
        addState(readColor);
//        this.telemetry.addData("ColorSensor", "Blue "+this.hardwareMap.colorSensor.get("colorSensor").blue()+" Red: "+this.hardwareMap.colorSensor.get("colorSensor").red());

//        addState(new ReadColor(this, 3, 5, 0));
//        this.telemetry.addData("ColorSensor", "Blue "+this.hardwareMap.colorSensor.get("colorSensor").blue()+" Red: "+this.hardwareMap.colorSensor.get("colorSensor").red());

        addSubEngine(new RedBumpLeft(this, readColor));
 //       addSubEngine(new BlueBumpRight(this, readColor));

        addState(new Beam(this, 1, 2500));
        addState(new Flipper(this, -1, 750));
        addState(new Beam(this, 1, 1700));
        addState(new Sleep(this, 50));

        addSubEngine(new RedFrontCenterColumn(this, readCam));

        addSubEngine(new RedFrontRightColumn(this, readCam));

        addSubEngine(new RedFrontLeftColumn(this, readCam));

    }

}