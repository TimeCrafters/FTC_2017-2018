package org.timecrafters.Darcshadowz.Engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.Darcshadowz.SubEngines.Blue.BlueFrontCenter;
import org.timecrafters.Darcshadowz.SubEngines.Blue.BlueFrontLeft;
import org.timecrafters.Darcshadowz.SubEngines.Blue.BlueFrontRight;
import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.cam.ReadCam;

/**
 * Created by Dylan on 12/17/2017.
 */
@Autonomous(name = "DYLAN BLUE FRONT")
public class DarcshadowzTestEngineBlue extends Engine {

    private ReadCam readCam;

    public void setProcesses(){

        readCam = new ReadCam(this);

        addState(readCam);

        addSubEngine(new BlueFrontCenter(this,readCam));
        addSubEngine(new BlueFrontLeft(this, readCam));

        //addSubEngine(new BlueFrontRight(this,readCam));
    }


}


