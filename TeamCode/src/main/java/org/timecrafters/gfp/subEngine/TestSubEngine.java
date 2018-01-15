package org.timecrafters.gfp.subEngine;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.timecrafters.engine.State;
import org.timecrafters.engine.SubEngine;
import org.timecrafters.gfp.state.TestState;
import org.timecrafters.gfp.state.cam.ReadCam;
import org.timecrafters.gfp.state.color.ReadColor;

/**
 * Created by goldfishpi on 12/2/17.
 */

public class TestSubEngine extends SubEngine {

    ReadCam readCam;

    public TestSubEngine(ReadCam readCam) {
        this.readCam = readCam;
    }

    @Override
    public void setProcesses() {
        addState(new TestState());
    }

    @Override
    public void evaluate() {
        //Log.i(TAG, Boolean.toString(state.getIsFinished()));
        /*if(readCam.getVuMark() == RelicRecoveryVuMark.CENTER) {
            setRunable(state.getIsFinished());
        }*/
        if(readCam.getVuMark() == RelicRecoveryVuMark.CENTER){setRunable(true);}
    }
}
