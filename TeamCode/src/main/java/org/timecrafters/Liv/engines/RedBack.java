package org.timecrafters.Liv.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.Liv.SubEngines.RedBackCenter;
import org.timecrafters.Liv.SubEngines.RedBackLeft;
import org.timecrafters.Liv.SubEngines.RedBackRight;
import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.HardWareConfig;
import org.timecrafters.gfp.engines.autonomous.jewelBump.Red.RedBumpLeft;
import org.timecrafters.gfp.engines.autonomous.jewelBump.Red.RedBumpRight;
import org.timecrafters.gfp.state.cam.ReadCam;
import org.timecrafters.gfp.state.color.ReadColor;
import org.timecrafters.gfp.state.jewelBump.Beam;
import org.timecrafters.gfp.state.jewelBump.Flipper;
import org.timecrafters.gfp.state.util.Sleep;

/**
 * Created by Liv on 12/5/2017.
 */


@Autonomous(name="Red Back")
public class RedBack extends Engine {




    public void setProcesses() {

        ReadColor readColor = new ReadColor(this,3,5,0);
        ReadCam readCam = new ReadCam(this);
        hardWareConfig = new HardWareConfig(this);
        addState(hardWareConfig);
        addState(readCam);
        addState(new Beam(this,-1.0,1450));
        addThreadedState(new Flipper(this,1.0,1000));
        addThreadedState(new Beam(this, -1.0, 2650));
        addState(readColor);

        //addSubEngine(new RedBumpLeft(this, readColor));
        addSubEngine(new RedBumpRight(this, readColor));

        addState(new Beam(this, 1, 2500));
        addThreadedState(new Flipper(this, -1, 431));
        addThreadedState(new Beam(this, 1, 1700));

        addState(new Sleep(this,50));

        addSubEngine(new RedBackLeft(this,readCam));
        addSubEngine(new RedBackCenter(this,readCam));
        addSubEngine(new RedBackRight(this,readCam));

        }
    }


