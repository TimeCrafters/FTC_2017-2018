package org.timecrafters.engine;

/**
 * Created by goldfishpi on 12/2/17.
 */

public abstract class SubEngine {

    State[][] processes = new State[100][100];
    int stateX = 0;
    int stateY = 0;

    int currentX = 0;
    int currentY = 0;

    public abstract void setProcesses();

    public void addStateProcess(State state){
        processes[stateX-1][stateY] = state;
        stateY ++;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

}
