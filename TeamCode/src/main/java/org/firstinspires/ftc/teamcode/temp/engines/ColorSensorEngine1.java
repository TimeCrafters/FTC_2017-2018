package org.firstinspires.ftc.teamcode.temp.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.temp.states.sensor.ColorSensor1;
import org.timecrafters.engine.Engine;

/**
 * Created by t420-1 on 5/5/2018.
 */
@Autonomous (name = ("lukesTS"))
public class ColorSensorEngine1 extends Engine {
    @Override
    public void setProcesses() {
        addState(new ColorSensor1(this));
    }
}
