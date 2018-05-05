package org.firstinspires.ftc.teamcode.temp.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.temp.states.sensor.SonicSensor1;
import org.timecrafters.engine.Engine;

/**
 * Created by t420-1 on 5/4/2018.
 */
@Autonomous (name="LukeSonic")
public class SonicSensor extends Engine {
    @Override
    public void setProcesses() {
        addState(new SonicSensor1(this));

    }
}
