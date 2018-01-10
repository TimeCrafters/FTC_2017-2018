package org.timecrafters.Darcshadowz.Engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.Darcshadowz.SubEngines.Blue.BlueFrontCenter;
import org.timecrafters.Darcshadowz.SubEngines.Blue.BlueFrontLeft;
import org.timecrafters.Darcshadowz.SubEngines.Blue.BlueFrontRight;
import org.timecrafters.engine.Engine;

/**
 * Created by Dylan on 12/17/2017.
 */
@Autonomous(name = "DYLAN TEST BLUE")
public class DarcshadowzTestEngineBlue extends Engine {

    public void setProcesses(){

//        addSubEngine(new BlueFrontCenter(this));
//
//        addSubEngine(new BlueFrontLeft(this));
//
        addSubEngine(new BlueFrontRight(this));
    }


}


