package org.timecrafters.Liv.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.Liv.SubEngines.BlueBackCenter;
import org.timecrafters.Liv.SubEngines.RedBackLeft;
import org.timecrafters.engine.Engine;

/**
 * Created by Liv on 12/21/2017.
 */

@Autonomous(name="Blue Back")
public class BlueBack extends Engine {
    @Override
    public void setProcesses() {
        addSubEngine(new BlueBackCenter(this));






    }
}










