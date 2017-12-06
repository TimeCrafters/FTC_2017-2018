package org.timecrafters.gfp.engines;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.TestState;
import org.timecrafters.gfp.subEngine.TestSubEngine;


/**
 * Created by t420 on 9/14/2017.
 */
@TeleOp(name = "Test")
public class TestEngine extends Engine {

    @Override
    public void setProcesses(){
        //addThreadedState(driveStraightForward);
        /*addState(new TestState());
        addThreadedState(new TestState());*/
        TestState testState = new TestState();

        addState(testState);
        addSubEngine(new TestSubEngine(testState));

        //addState(new ButtClass(this));
        //addState(new DriveTest(this));
    }

}
