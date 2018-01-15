package org.timecrafters.Liv.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.Liv.SubEngines.BlueBackCenter;
import org.timecrafters.Liv.SubEngines.BlueBackLeft;
import org.timecrafters.Liv.SubEngines.BlueBackRight;
import org.timecrafters.Liv.SubEngines.RedBackLeft;
import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.engines.autonomous.jewelBump.Red.RedBumpLeft;
import org.timecrafters.gfp.engines.autonomous.jewelBump.Red.RedBumpRight;
import org.timecrafters.gfp.state.cam.ReadCam;
import org.timecrafters.gfp.state.color.ReadColor;
import org.timecrafters.gfp.state.jewelBump.Beam;
import org.timecrafters.gfp.state.jewelBump.Flipper;

/**
 * Created by Liv on 12/21/2017.
 */

  @Autonomous(name="Blue Back")
  public class BlueBack extends Engine {




    public void setProcesses() {

        ReadColor readColor = new ReadColor(this,3,5,0);
        addState(new Beam(this,-1.0,1500));
        addState(new Flipper(this,1.0,530));
        addState(new Beam(this, -1.0, 2500));
        addState(readColor);
        addSubEngine(new RedBumpLeft(this, readColor));
        addSubEngine(new RedBumpRight(this, readColor));
        addState(new Beam(this, 1, 2500));
        addState(new Flipper(this, -1, 430));
        addState(new Beam(this, 1, 1700));
        ReadCam readCam = new ReadCam(this);
        addState(readCam);
        addSubEngine(new BlueBackRight(this,readCam));
        addSubEngine(new BlueBackLeft(this,readCam));
        addSubEngine(new BlueBackCenter(this,readCam));



        }

    }











