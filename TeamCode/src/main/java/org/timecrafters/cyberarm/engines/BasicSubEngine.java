package org.timecrafters.cyberarm.engines;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.timecrafters.cyberarm.states.TestState;
import org.timecrafters.engine.Engine;
import org.timecrafters.engine.SubEngine;

/**
 * Created by cyber on 1/10/2018.
 */

public class BasicSubEngine extends SubEngine {
    Engine engine;
    public BasicSubEngine(Engine engine) {
        this.engine = engine;
    }
    public void setProcesses() {
        addState(new TestState(engine));
        addState(new TestState(engine));
        addState(new TestState(engine));
        addState(new TestState(engine));
        addState(new TestState(engine));
        addState(new TestState(engine));
        addState(new TestState(engine));
        addState(new TestState(engine));
        addState(new TestState(engine));
        addState(new TestState(engine));
        addState(new TestState(engine));
        addState(new TestState(engine));
        addState(new TestState(engine));
        addState(new TestState(engine));
        addState(new TestState(engine));
        addState(new TestState(engine));
    }

    public void evaluate() {
        setPreInit(true);
        setRunable(true);
    }
}