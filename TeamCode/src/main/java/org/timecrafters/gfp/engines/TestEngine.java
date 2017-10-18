package org.timecrafters.gfp.engines;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.drive.Coast;

/**
 * Created by t420 on 9/14/2017.
 */
@TeleOp(name = "Test")
public class TestEngine extends Engine {

    @Override
    public void setProcesses(){
        addState(new Coast(this,1.0,20000,1000,0.05));
        addState(new Coast(this,1.0,50000,1000,0.05));
        //addState(new DriveTest(this));
    }

}
