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
    }

    @Override
    public void exec() {
       if (color.red() > value)
        {   engine.telemetry.addData("finished",true);
            setFinished(true);
            motor.setPower(0);
        }else{
           motor.setPower(1);
           engine.telemetry.addData("color data",color.red());
        }
        engine.telemetry.update();
    }
}
