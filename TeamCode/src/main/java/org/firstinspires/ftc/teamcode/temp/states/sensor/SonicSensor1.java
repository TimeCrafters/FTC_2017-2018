package org.firstinspires.ftc.teamcode.temp.states.sensor;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

import org.firstinspires.ftc.teamcode.temp.engines.SonicSensor;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 5/4/2018.
 */

public class SonicSensor1 extends State {
    private UltrasonicSensor sonic;
    private double uss;
    private DcMotor dm;



    public SonicSensor1(Engine engine) {
this.engine = engine;


    }
    @Override
    public void init () {

        sonic = engine.hardwareMap.ultrasonicSensor.get("SonicSensor");
        dm = engine.hardwareMap.dcMotor.get("motor1");
    }

    @Override
    public void exec() {
sonic.getUltrasonicLevel();
engine.telemetry.addData("SonicSenor",sonic.getUltrasonicLevel());
engine.telemetry.update();
    }
}
