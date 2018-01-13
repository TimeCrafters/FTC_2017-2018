package org.timecrafters.Liv.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.Liv.SubEngines.BlueBackCenter;
import org.timecrafters.Liv.SubEngines.BlueBackLeft;
import org.timecrafters.Liv.SubEngines.BlueBackRight;
import org.timecrafters.Liv.SubEngines.RedBackLeft;
import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.cam.ReadCam;

/**
 * Created by Liv on 12/21/2017.
 */

  @Autonomous(name="Blue Back")
  public class BlueBack extends Engine {


    ReadCam readCam = new ReadCam(this);

    public void setProcesses() {

        addState(readCam);

        addSubEngine(new BlueBackRight(this,readCam));

        addSubEngine(new BlueBackLeft(this,readCam));

        addSubEngine(new BlueBackCenter(this,readCam));



        }

    }











