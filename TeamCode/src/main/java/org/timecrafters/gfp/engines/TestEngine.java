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
import org.timecrafters.gfp.state.util.Sleep;
import org.timecrafters.gfp.subEngine.TestSubEngine;


/**
 * Created by t420 on 9/14/2017.
 */
@TeleOp(name = "Test")
public class TestEngine extends Engine {


    @Override
    public void setProcesses(){

        ReadColor readColor = new ReadColor(this,3,5,0);
        addState(new Beam(this,-1.0,1500));
        //addState(new Flipper(this,1.0,530));
        addState(new Flipper(this,1.0,610));
        addState(new Beam(this, -1.0, 2500));
        addState(readColor);
        addSubEngine(new RedBumpLeft(this, readColor));
        addSubEngine(new RedBumpRight(this, readColor));
        addState(new Beam(this, 1, 2500));
        addState(new Flipper(this, -1, 410));
        addState(new Beam(this, 1, 1500));
    }

}
