package org.firstinspires.ftc.teamcode.temp.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.temp.states.DrivState;
import org.timecrafters.engine.Engine;
import com.qualcomm.robotcore.hardware.TouchSensor;

@Autonomous(name="DriveTest")
public class TestEngine extends Engine {
    @Override
    public void setProcesses() {
    addState(new DrivState(this,1.0,800));

    }
}
