package org.timecrafters.gfp.engines;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.engines.autonomous.jewelBump.Red.BlueBumpLeft;
import org.timecrafters.gfp.engines.autonomous.jewelBump.Red.BlueBumpRight;
import org.timecrafters.gfp.state.color.ReadColor;
import org.timecrafters.gfp.state.jewelBump.Beam;
import org.timecrafters.gfp.state.jewelBump.Flipper;


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
        addSubEngine(new BlueBumpLeft(this, readColor));
        addSubEngine(new BlueBumpRight(this, readColor));
        addState(new Beam(this, 1, 2500));
        addState(new Flipper(this, -1, 410));
        addState(new Beam(this, 1, 1500));
    }

}
