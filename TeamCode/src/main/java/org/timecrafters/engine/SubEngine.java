package org.timecrafters.engine;

import android.util.Log;

/**
 * Created by goldfishpi on 12/2/17.
 */

public abstract class SubEngine {

    State[][] processes = new State[100][100];
    int stateX = 0;
    int stateY = 0;

    int currentX = 0;
    int currentY = 0;

    public boolean runable = false;

    public static String TAG = "PROGRAM.SUBENGINE";

    public abstract void setProcesses();

    public abstract void evaluate();

    public void addState(State state){
        stateY = 0;
        processes[stateX][stateY] = state;
        Log.i(TAG, "CREATED NEW STATE : " + "["+stateX + "]" + "[" + stateY +"]" );
        stateX ++;
    }

    public void addStateProcesses(State state){
        stateY ++;
        processes[stateX-1][stateY] = state;
        Log.i(TAG, "ADDED PROCCES TO STATE : " + "["+stateX + "]" + "[" + stateY +"]" );
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public State[][] getProcesses() {
        return processes;
    }

    public boolean isRunable() {
        return runable;
    }

    public void setRunable(boolean runable) {
        this.runable = runable;
    }
}
