package org.firstinspires.ftc.teamcode.temp.states.motors;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 6/2/2018.
 */

public class motorDrive extends State {
    private DcMotor motor1, motor2;
    private double motorPercentageDistance,motorDistance,motorRampDistance,motorLastSpeed,motorspeed1,done;
    private double motorEndingDistance, motorRampSpeed;
    public motorDrive(Engine engine) {
        this.engine = engine;

    }

    @Override
    public void init () {
     motor1 = engine.hardwareMap.dcMotor.get("motor1");
     motor2 = engine.hardwareMap.dcMotor.get("motor2");
     motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
     motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
     motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
     motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
     //set motor distance
     motorDistance = 10000;
     //set motor rampage percentage
     motorPercentageDistance = .5;
     //combine them
     motorRampDistance = motorDistance*motorPercentageDistance;
     //begining motor speed
     motorLastSpeed = 0;
     done = 0;
    }

    @Override
    public void exec() {
        engine.telemetry.addData("motor1 power",motor1. getPower());
        engine.telemetry.update();
        motorspeed1 = motorLastSpeed;
        motorRampSpeed = (1/motorRampDistance)*20;
        if (motor1.getCurrentPosition()< motorRampDistance ){
            motor1.setPower(motorspeed1);
            motorLastSpeed = motorLastSpeed + motorRampSpeed;
            motorEndingDistance = motor1.getCurrentPosition();
            engine.telemetry.addData("position", motor1.getCurrentPosition());
        }else {
            motor1.setPower(motorspeed1);
            engine.telemetry.addData("done", done);
            engine.telemetry.addData("ended on", motorEndingDistance);
            engine.telemetry.update();
            if (done == 0) {
                done = done + 1;
            }
        }

    }
}