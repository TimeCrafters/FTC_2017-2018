package org.firstinspires.ftc.teamcode.temp.states;

import com.qualcomm.hardware.motors.NeveRest20Gearmotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
//import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;


public class DrivState extends State {
    private DcMotor motor;
    private double power;
    private int ticks;
    private OpticalDistanceSensor distance;
    //private int TouchSensor;

    public DrivState(Engine engine, double power, int ticks) {
        this.engine = engine;
        this.power = power;
        this.ticks = ticks;

    }
    @Override
    public void init() {
        motor = engine.hardwareMap.dcMotor.get("DcMotor1");
        distance= engine.hardwareMap.opticalDistanceSensor.get("distance");
        //motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }


    @Override
    public void exec() {
        //random=Math.random();
    //motor.setTargetPosition(ticks);
    motor.setPower(power);
    if (distance.getLightDetected() <= 0.1) {
        motor.setPower(1);
    }
    engine.telemetry.addData("distance",distance.getLightDetected());
    engine.telemetry.update();
    //sleep(100);
    //motor.setTargetPosition((int) random);
    //engine.telemetry.addData("ticks",motor.getCurrentPosition());

    }
}
