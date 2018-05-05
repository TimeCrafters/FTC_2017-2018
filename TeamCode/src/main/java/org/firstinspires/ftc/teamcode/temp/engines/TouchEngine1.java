package org.firstinspires.ftc.teamcode.temp.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.temp.states.DrivState;
import org.firstinspires.ftc.teamcode.temp.states.sensor.TouchSensor1;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 5/5/2018.
 */
@Autonomous (name = "touchsensorLB")
public class TouchEngine1 extends Engine {

    @Override
    public void setProcesses() {
        addState(new TouchSensor1(this,1.0));
    }
}
