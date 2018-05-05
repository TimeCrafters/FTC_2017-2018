package org.firstinspires.ftc.teamcode.temp.states;

import com.qualcomm.hardware.motors.NeveRest20Gearmotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;


public class DrivState extends State {
    private DcMotor motor;
    private double power;
    private int ticks;
    private OpticalDistanceSensor distance;
    private double OdsV;
    private TouchSensor touch;
    //private int TouchSensor;
    private int PushButtonValue;

    public DrivState(Engine engine, double power, int ticks) {
        this.engine = engine;
        this.power = power;
        this.ticks = ticks;


    }
    @Override
    public void init() {
        motor = engine.hardwareMap.dcMotor.get("DcMotor1");
        distance = engine.hardwareMap.opticalDistanceSensor.get("distance1");
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        touch = engine.hardwareMap.touchSensor.get("touchs");
    }


    @Override
    public void exec() {
        PushButtonValue = (int) touch.getValue();
        OdsV = distance.getLightDetected();
if (PushButtonValue == 0){
    motor.setPower(OdsV*-1+2);
}else{
    motor.setPower(OdsV*1-2);
}

    engine.telemetry.addData("distance",distance.getLightDetected());
    engine.telemetry.addData("touch",touch.getValue());
    engine.telemetry.update();



    }
}
