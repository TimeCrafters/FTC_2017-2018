package org.timecrafters.gfp.engines.autonomous.blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.Arm.ExtendArm;
import org.timecrafters.gfp.state.Arm.RaiseArm;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.grabber.LeftGrabber;

/**
 * Created by t420 on 11/10/2017.
 */

@Autonomous(name="Blue Front")
public class BlueFront extends Engine {

    public void setProcesses(){
        addState(new DriveStraightForward(this, 0.5,800));
        addState(new ExtendArm(this,1.0,1550));
        addState(new RaiseArm(this,1.0,1750));
        addState(new ExtendArm(this,1.0,1150));
        addState(new DriveStraightForward(this, -0.5, 100));
        addState(new RaiseArm(this,-0.5,1750));
        addState(new LeftGrabber(this,0.5,500));
    }

}
