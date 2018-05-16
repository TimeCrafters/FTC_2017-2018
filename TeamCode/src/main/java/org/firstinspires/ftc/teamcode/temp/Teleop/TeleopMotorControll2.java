package org.firstinspires.ftc.teamcode.temp.Teleop;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 5/12/2018.
 */

public class TeleopMotorControll2 extends State {
    DcMotor motor1;
    private double leftStickAmount;
    private double motorSpeed;
    private double lastMotorSpeed;

    public TeleopMotorControll2(Engine engine) {
        this.engine = engine;

    }

    @Override
    public void init() {
        super.init();
        motor1 = engine.hardwareMap.dcMotor.get("leftmotor");
        motor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lastMotorSpeed = 0;
    }

    @Override
    public void exec() {
        if (engine.gamepad2.dpad_up) {
            motorSpeed = lastMotorSpeed - 0.25;
            motor1.setPower(motorSpeed);
            sleep(100);
            lastMotorSpeed = motorSpeed;
           /* if (engine.gamepad2.dpad_up == false){
                lastMotorSpeed = 0;
            }*/
        } else if (engine.gamepad2.dpad_down) {
            motorSpeed = lastMotorSpeed + 0.25;
            motor1.setPower(motorSpeed);
            sleep(100);
            lastMotorSpeed = motorSpeed;
            /*if (engine.gamepad2.dpad_down == false){
                lastMotorSpeed = 0;
            }*/
            engine.telemetry.addData("motor1", motor1.getPower());
        } else if (engine.gamepad2.right_bumper){
            leftStickAmount = engine.gamepad2.left_stick_y;
            motor1.setPower(leftStickAmount);
        }
    }
}
