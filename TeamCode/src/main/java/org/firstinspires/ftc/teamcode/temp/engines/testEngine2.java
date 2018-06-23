package org.firstinspires.ftc.teamcode.temp.engines;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.temp.subengine.ExampleSubEngine;
import org.timecrafters.engine.Engine;

/**
 * Created by t420-1 on 6/23/2018.
 */
@TeleOp (name = "dude")
public class testEngine2 extends Engine{

    @Override
    public void setProcesses() {
        addSubEngine(new ExampleSubEngine(this));
    }
}
