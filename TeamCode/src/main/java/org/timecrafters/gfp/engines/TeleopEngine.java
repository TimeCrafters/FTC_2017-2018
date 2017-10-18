package org.timecrafters.gfp.engines;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.Teleop.DriveTrain;

/**
 * Created by t420 on 10/5/2017.
 */
@TeleOp(name="OOOOOH BOY")
public class TeleopEngine extends Engine {

    public void setProcesses(){
        addState(new DriveTrain(this));
        //addStateProcess(new Winch(this,1.0));
    }
}   