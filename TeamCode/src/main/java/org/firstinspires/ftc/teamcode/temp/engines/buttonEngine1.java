package org.firstinspires.ftc.teamcode.temp.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.temp.states.button2;
import org.timecrafters.engine.Engine;

/**
 * Created by t420-1 on 5/7/2018.
 */
@Autonomous (name = "lukes Button")
public class buttonEngine1 extends Engine {
    @Override
    public void setProcesses () {
        addState(new button2(this));

    }
}
