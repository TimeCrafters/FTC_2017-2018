package org.timecrafters.gfp.engines.autonomous.red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.drive.DriveStraightForward;

/**
 * Created by t420 on 11/2/2017.
 */


@Autonomous(name = "Red Balancing Stone")
public class RedPlatform extends Engine {

    public void setProcesses(){
        addState(new DriveStraightForward(this,0.5,500));
        //addState(new ExtendArm(this,1.0,3));
    }

}
