package org.firstinspires.ftc.teamcode.temp.states.sensor;

import android.graphics.Color;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 4/21/2018.
 */

public class TQcolor extends State {
    private ColorSensor color;
    private DcMotor motor;
    private double value;
    private double power;
    public TQcolor(Engine engine,double value) {
        this.engine = engine;
        this.value = value;
    }

    @Override
    public void init(){
      color = engine.hardwareMap.colorSensor.get("color");
      motor = engine.hardwareMap.dcMotor.get("motor");
      motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void exec() {
        motor.setTargetPosition(color.red()/100);
        engine.telemetry.addData("color data",color.red());
        motor.setTargetPosition(0);
    }
}
