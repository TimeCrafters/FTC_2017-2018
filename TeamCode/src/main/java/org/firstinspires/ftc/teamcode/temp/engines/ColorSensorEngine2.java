package org.firstinspires.ftc.teamcode.temp.engines;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.temp.states.sensor.ColorSensor1;
import org.firstinspires.ftc.teamcode.temp.states.sensor.ColorSensor2;
import org.timecrafters.engine.Engine;

/**
 * Created by t420-1 on 5/5/2018.
 */
@TeleOp(name = ("lukes10"))
public class ColorSensorEngine2 extends Engine {
    @Override
    public void setProcesses() {
        addState(new ColorSensor2(this));
    }
}
