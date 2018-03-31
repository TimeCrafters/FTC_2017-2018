package org.firstinspires.ftc.teamcode.temp.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.states.motors.DcDrive;
import org.firstinspires.ftc.teamcode.states.motors.DcDrive;
import org.timecrafters.engine.Engine;

/**
 * Created by temp on 3/31/2018.
 */
@Autonomous(name="Temp_Test")
public class TestEngine extends Engine {
    @Override
    public void setProcesses() {
    addState(new DcDrive(this));
    }
}
