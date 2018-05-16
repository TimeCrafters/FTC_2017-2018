package org.firstinspires.ftc.teamcode.temp.Teleop;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 5/12/2018.
 */

public class TeleopMotorControll extends State {
    DcMotor motor1;
    private double rightStickAmount;
    private double motorSpeed;
    private double lastMotorSpeed;

    public TeleopMotorControll(Engine engine) {
        this.engine = engine;

    }

    @Override
    public void init() {
        super.init();
        motor1 = engine.hardwareMap.dcMotor.get("rightmotor");
        motor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lastMotorSpeed = 0;
    }

    @Override
    public void exec() {
        if (engine.gamepad2.y){
            motorSpeed = lastMotorSpeed+0.25;
            motor1.setPower(motorSpeed);
            sleep(100);
            lastMotorSpeed = motorSpeed;
           /* if (engine.gamepad2.y == false){
                lastMotorSpeed = 0;
            }*/
        }else if (engine.gamepad2.a){
            motorSpeed = lastMotorSpeed-0.25;
            motor1.setPower(motorSpeed);
            sleep(100);
            lastMotorSpeed = motorSpeed;
          /*  if (engine.gamepad2.a == false){
                lastMotorSpeed = 0;
            }*/
            engine.telemetry.addData("motor2",motor1.getPower());
        }else if (engine.gamepad2.right_bumper){
            rightStickAmount = engine.gamepad2.right_stick_y;
            motor1.setPower(-1*rightStickAmount);
        }
    }
}
