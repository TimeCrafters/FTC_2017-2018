package org.firstinspires.ftc.teamcode.temp.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.temp.states.servostate;
import org.timecrafters.engine.Engine;

/**
 * Created by t420-1 on 4/7/2018.
 */
@Autonomous(name="sero drive")
public class ServoEngine extends Engine {
    @Override
    public void setProcesses() {
        addState(new servostate(this, (1)));

    }
}
