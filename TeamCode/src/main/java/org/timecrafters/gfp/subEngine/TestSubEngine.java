package org.timecrafters.gfp.subEngine;

import android.util.Log;

import org.timecrafters.engine.State;
import org.timecrafters.engine.SubEngine;
import org.timecrafters.gfp.state.TestState;

/**
 * Created by goldfishpi on 12/2/17.
 */

public class TestSubEngine extends SubEngine {

    volatile State state;

    public TestSubEngine(State state) {
        this.state = state;
    }

    @Override
    public void setProcesses() {
        addState(new TestState());
        addStateProcesses(new TestState());
    }

    @Override
    public void evaluate() {
        Log.i(TAG, Boolean.toString(state.getIsFinished()));
        setRunable(state.getIsFinished());
    }
}
