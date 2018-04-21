package org.firstinspires.ftc.teamcode.temp.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.temp.states.sensor.TQcolor;
import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.engines.TestEngine;

/**
 * Created by t420-1 on 4/21/2018.
 */
@Autonomous(name= "ColorSensor")
public class ServoEngine1 extends Engine {
    @Override
    public void setProcesses() {
        addState(new TQcolor(this,20));
    }
}
