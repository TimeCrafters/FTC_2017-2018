package org.firstinspires.ftc.teamcode.temp.engines;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.teamcode.temp.states.sensor.TCcolorSensor;
import org.firstinspires.ftc.teamcode.temp.subengine.ExampleSubEngine;
import org.timecrafters.engine.Engine;

/**
 * Created by t420-1 on 6/23/2018.
 */
@TeleOp (name = "dude")
public class testEngine2 extends Engine{

    @Override
    public void setProcesses() {
        TCcolorSensor colorsensor = new TCcolorSensor (this);
        addSubEngine(new ExampleSubEngine(this, colorsensor));

    }
}
