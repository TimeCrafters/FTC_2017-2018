package org.timecrafters.gfp.engines;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.grabber.GrabberTeleop;

/**
 * Created by t420 on 9/14/2017.
 */
@TeleOp(name = "Test")
public class TestEngine extends Engine {

    @Override
    public void setProcesses(){
        addState(new GrabberTeleop(this,0.3));
    }

}
