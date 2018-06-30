package org.firstinspires.ftc.teamcode.temp.subengine;

import org.firstinspires.ftc.teamcode.temp.states.motors.motorDrive;
import org.firstinspires.ftc.teamcode.temp.states.sensor.TCcolorSensor;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.SubEngine;

/**
 * Created by t420-1 on 6/23/2018.
 */

public class ExampleSubEngine extends SubEngine{
    Engine engine;
    TCcolorSensor ColorSensor12;
    public ExampleSubEngine(Engine engine, TCcolorSensor ColorSensor12) {
        this.engine = engine;
        this.ColorSensor12 = ColorSensor12;
    }

    @Override
    public void setProcesses() {
//        this.ColorSensor12 = (new TCcolorSensor(engine));
        addState(new motorDrive(engine));
        addState(ColorSensor12);

    }

    @Override
    public void evaluate() {
        if (ColorSensor12.valueValueGetBLueValue() <= 20) {
            setRunable(true);
        } else {
            setRunable(false);
        }
    }
}
