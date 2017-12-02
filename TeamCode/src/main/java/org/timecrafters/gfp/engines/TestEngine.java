package org.timecrafters.gfp.engines;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.state.drive.DriveStraightForward;
import org.timecrafters.gfp.state.ultrasonic.ReadFrontRightRange;
import org.timecrafters.gfp.state.ultrasonic.UltraSonic;


/**
 * Created by t420 on 9/14/2017.
 */
@TeleOp(name = "Test")
public class TestEngine extends Engine {

    @Override
    public void setProcesses(){
        //Setup range sensor
        ReadFrontRightRange readFrontRightRange = new ReadFrontRightRange(this, 60);
        readFrontRightRange.runUntillDistance(6);

        //Setup drive to use range sensor to stop instead of ticks
        DriveStraightForward driveStraightForward = new DriveStraightForward(this,
                0.2,600);
        driveStraightForward.runUntillStateFinished(readFrontRightRange);



        //addState(new ButtClass(this));
        //addState(new DriveTest(this));
    }

}
