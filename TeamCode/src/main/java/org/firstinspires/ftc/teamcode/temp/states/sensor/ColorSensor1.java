package org.firstinspires.ftc.teamcode.temp.states.sensor;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 5/5/2018.
 */

public class ColorSensor1 extends State {
    private ColorSensor colorSensor;
    private DcMotor motor1;
    private int colorSensorRed;
    private TouchSensor touchSensor;
    private int colorSensorBlue;

    public ColorSensor1(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void init() {
        super.init();
        colorSensor = engine.hardwareMap.colorSensor.get("color");
        motor1 = engine.hardwareMap.dcMotor.get("motor1");
        touchSensor = engine.hardwareMap.touchSensor.get("touch1");
        motor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    @Override
    public void exec() {
        colorSensorRed = colorSensor.red();
        colorSensorBlue = colorSensor.blue();
        engine.telemetry.addData("red", colorSensor.red());
        engine.telemetry.addData("blue", colorSensor.blue());
        engine.telemetry.update();
        if (touchSensor.isPressed()){
            motor1.setPower(colorSensorRed /17);
        }else{
            motor1.setPower((-1* colorSensorBlue)/17);


        }

    }
}
