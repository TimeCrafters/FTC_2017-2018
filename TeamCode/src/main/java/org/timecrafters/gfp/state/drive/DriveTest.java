package org.timecrafters.gfp.state.drive;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.Config;

/**
 * Created by t420 on 9/26/2017.
 */

public class DriveTest extends Config {

    public DriveTest(Engine engine){
        super(engine);

    }

    public void init(){
        super.init();
        dcGrabberOne.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void exec(){
        dcGrabberOne.setPower(1.0);
        dcGrabberOne.setTargetPosition(500);

        if(!dcGrabberOne.isBusy()){
            dcGrabberOne.setPower(0.0);
            setFinished(true);
        }
    }

}
