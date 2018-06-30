package org.firstinspires.ftc.teamcode.temp.states.sensor;

import com.qualcomm.robotcore.hardware.ColorSensor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 6/30/2018.
 */

public class TCcolorSensor extends State {
    private ColorSensor ColorSensor12;

    public TCcolorSensor(Engine engine) {
        this.engine = engine;
        ColorSensor12 = engine.hardwareMap.colorSensor.get("colorSensor");
    }

    @Override
    public void init() {
        super.init();

    }

    @Override
    public void exec() {
    }

    public int valueValueGetBLueValue() {
        return ColorSensor12.blue();
    }
}
