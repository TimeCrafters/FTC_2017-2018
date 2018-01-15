package org.timecrafters.Liv.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.Liv.SubEngines.RedBumpLeft;
import org.timecrafters.Liv.SubEngines.RedBumpRight;
import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.HardWareConfig;
import org.timecrafters.gfp.state.cam.ReadCam;
import org.timecrafters.gfp.state.color.ReadColor;
import org.timecrafters.gfp.state.drive.DriveStraightBackward;
import org.timecrafters.gfp.state.jewelBump.Beam;
import org.timecrafters.gfp.state.jewelBump.Flipper;
import org.timecrafters.gfp.state.util.Sleep;

/**
 * Created by Liv on 12/21/2017.
 */

  @Autonomous(name="Blue Back")
  public class BlueBack extends Engine {



    ReadCam readCam;

    public void setProcesses() {


        ReadColor readColor = new ReadColor(this,3,5,0);
        readCam = new ReadCam(this);
        hardWareConfig = new HardWareConfig(this);
        addState(hardWareConfig);
        addState(new Beam(this,-1.0,1500));
        addState(new Flipper(this,1.0,725));
        addState(new Beam(this, -1.0, 2500));
        addState(readColor);

        addSubEngine(new RedBumpLeft(this, readColor));
        addSubEngine(new RedBumpRight(this, readColor));

        addState(new Beam(this, 1, 2500));
        addState(new Flipper(this, -1, 750));
        addState(new Beam(this, 1, 1701));

        addState(new Sleep(this,50));

        addState(new DriveStraightBackward(this, 0.5, 3305));
        addState(new TurnRight(this, 0.3, 410));
        addState(new RaiseArm(this, 1, 650));
        addState(new DriveStraightForward(this, 0.5, 400));
        addState(new ExtendArm(this, 0.5, 1290));
        addState(new RightGrabber(this, -0.5, 500));
        addState(new DriveStraightForward(this, -0.5, 516));
        addState(new TurnLeft(this, 0.3, 1737));
        addState(new DriveStraightForward(this, -0.5, 850));
        addState(new DriveStraightForward(this, 0.5, 860));

        //readCam = new ReadCam(this);
        //addState(readCam);

        /*addSubEngine(new BlueBackLeft(this,readCam));
        addSubEngine(new BlueBackRight(this,readCam));*/
        //addSubEngine(new BlueBackCenter(this,readCam));



        }

    }











