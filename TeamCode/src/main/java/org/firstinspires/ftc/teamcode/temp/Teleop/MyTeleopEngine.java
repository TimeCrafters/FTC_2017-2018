package org.firstinspires.ftc.teamcode.temp.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.timecrafters.engine.Engine;

/**
 * Created by t420-1 on 5/12/2018.
 */
@TeleOp (name = ("lukeTestTeleop"))
public class MyTeleopEngine extends Engine {
    @Override
    public void setProcesses() {

    addState(new TeleopMotorControll(this));

    addThreadedState(new TeleopMotorControll2(this));
    }
}
