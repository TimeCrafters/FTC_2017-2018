package org.firstinspires.ftc.teamcode.temp.states.sensor;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 5/5/2018.
 */

public class TouchSensor1 extends State {
    private TouchSensor touch;
   private DcMotor motor;
   private double power;

    public TouchSensor1(Engine engine,double power) {
        this.engine = engine;
        this.power = power;

    }

    @Override
    public void init() {
        super.init();
        touch = engine.hardwareMap.touchSensor.get("touch1");
        motor = engine.hardwareMap.dcMotor.get("motor1");
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    @Override
    public void exec() {
        if (touch.isPressed()){
            engine.telemetry.addData("touchsensor","pressed");
            motor.setPower(power);
        }else{
            engine.telemetry.addData("touchsensor","not preesed");
            motor.setPower(0);
        }
      engine.telemetry.update();
    }
}
