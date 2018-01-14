package org.timecrafters.gfp.engines;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.engines.autonomous.jewelBump.Red.RedBumpLeft;
import org.timecrafters.gfp.engines.autonomous.jewelBump.Red.RedBumpRight;
import org.timecrafters.gfp.state.TestState;
import org.timecrafters.gfp.state.cam.ReadCam;
import org.timecrafters.gfp.state.color.ReadColor;
import org.timecrafters.gfp.state.jewelBump.Beam;
import org.timecrafters.gfp.state.jewelBump.Flipper;
import org.timecrafters.gfp.subEngine.TestSubEngine;


/**
 * Created by t420 on 9/14/2017.
 */
@TeleOp(name = "Test")
public class TestEngine extends Engine {


    @Override
    public void setProcesses(){

        ReadColor readColor = new ReadColor(this,3,5,0);
        addState(readColor);
        addSubEngine(new RedBumpLeft(this, readColor));
        addSubEngine(new RedBumpRight(this, readColor));
    }

}
