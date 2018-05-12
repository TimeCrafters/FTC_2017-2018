package org.firstinspires.ftc.teamcode.temp.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.temp.states.DriveTest23;
import org.timecrafters.engine.Engine;

/**
 * Created by t420-1 on 5/11/2018.
 */
@Autonomous (name = "DriveTest23")
public class DriveTest23Engine extends Engine {
    @Override
    public void setProcesses() {
      addState(new DriveTest23(this));
    }
}
