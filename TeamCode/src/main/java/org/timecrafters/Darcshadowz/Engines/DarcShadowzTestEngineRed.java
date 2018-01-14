package org.timecrafters.Darcshadowz.Engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.Darcshadowz.SubEngines.Red.RedFrontCenterColumn;
import org.timecrafters.Darcshadowz.SubEngines.Red.RedFrontLeftColumn;
import org.timecrafters.Darcshadowz.SubEngines.Red.RedFrontRightColumn;
import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.cam.ReadCam;

/**
 * Created by Dylan on 11/14/2017.
 */


@Autonomous(name = "DYLAN RED FRONT")
public class DarcShadowzTestEngineRed extends Engine {



    public void setProcesses() {

        ReadCam readCam = new ReadCam(this);

        addState(readCam);

        //addSubEngine(new RedFrontRightColumn(this));

        addSubEngine(new RedFrontCenterColumn(this, readCam));

        //addSubEngine(new RedFrontLeftColumn(this));

    }

}

