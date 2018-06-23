package org.firstinspires.ftc.teamcode.temp.states.motors;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.engine.State;

/**
 * Created by t420-1 on 6/23/2018.
 */

public class MotorDrive3 extends State{
   public DcMotor motor2;
   private double power;
   private int ticks;
    public MotorDrive3(Engine engine, double power, int ticks) {
        this.engine = engine;
        this.power = power;
        this.ticks = ticks;


    }

    @Override
    public void init() {
        super.init();
        motor2 = engine.hardwareMap.dcMotor.get("motor1");
        motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void exec() throws InterruptedException {
        motor2.setTargetPosition(ticks);
        motor2.setPower(power);
    }
}
