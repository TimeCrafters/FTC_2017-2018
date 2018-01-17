package org.timecrafters.gfp.engines;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.HardWareConfig;
import org.timecrafters.gfp.state.TestState;
import org.timecrafters.gfp.state.cam.ReadCam;
import org.timecrafters.gfp.state.color.ReadColor;
import org.timecrafters.gfp.state.jewelBump.Beam;
import org.timecrafters.gfp.state.jewelBump.Flipper;
import org.timecrafters.gfp.state.util.Sleep;
import org.timecrafters.gfp.subEngine.TestCamCenter;
import org.timecrafters.gfp.subEngine.TestCamLeft;
import org.timecrafters.gfp.subEngine.TestCamRight;
import org.timecrafters.gfp.subEngine.TestSubEngine;


/**
 * Created by t420 on 9/14/2017.
 */
@TeleOp(name = "Test")
public class TestEngine extends Engine {

    ReadCam readCam;

    @Override
    public void setProcesses(){
        hardWareConfig = new HardWareConfig(this);
        addState(hardWareConfig);
        readCam= new ReadCam(this);
        addState(readCam);

        addSubEngine(new TestCamLeft(this,readCam));
        addSubEngine(new TestCamCenter(this,readCam));
        addSubEngine(new TestCamRight(this,readCam));
    }

}
