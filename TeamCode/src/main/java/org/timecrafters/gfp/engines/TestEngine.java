package org.timecrafters.gfp.engines;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.UnstableEngine;
import org.timecrafters.gfp.state.TestState;

/**
 * Created by t420 on 9/14/2017.
 */
@TeleOp(name = "Test")
public class TestEngine extends UnstableEngine {

    @Override
    public void setProcesses(){
        addState(new TestState());
        addState(new TestState());
        //addState(new DriveTest(this));
    }

}
