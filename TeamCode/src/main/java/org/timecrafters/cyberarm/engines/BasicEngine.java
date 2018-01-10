package org.timecrafters.cyberarm.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.engine.Engine;

/**
 * Created by cyber on 1/10/2018.
 */

@Autonomous(name = "Finite")
public class BasicEngine extends Engine {

    public void setProcesses() {
        addSubEngine(new BasicSubEngine(this));
    }
}
