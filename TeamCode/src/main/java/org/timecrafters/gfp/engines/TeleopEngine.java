package org.timecrafters.gfp.engines;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.Teleop.Arm;
import org.timecrafters.gfp.Teleop.DriveTrain;
import org.timecrafters.gfp.Teleop.Grabbers;
import org.timecrafters.gfp.Teleop.Winch;

/**
 * Created by t420 on 10/5/2017.
 */
@TeleOp(name="Main Teleop")
public class TeleopEngine extends Engine {

    public void setProcesses(){
        addState(new DriveTrain(this));
        addStateProcess(new Grabbers(this,0.3));
        addStateProcess(new Winch(this,1.0));
        addStateProcess(new Arm(this,1.0,0.05));
    }
}