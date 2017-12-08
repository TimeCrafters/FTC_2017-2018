package org.timecrafters.engine;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by t420 on 9/29/2016.
 * First sucess ful test was 5:00 6 thur oct 2016
 */
/*

::::::::: ::::::::::: :::        :::
:+:    :+:    :+:     :+:        :+:
+:+    +:+    +:+     +:+        +:+
+#++:++#+     +#+     +#+        +#+
+#+    +#+    +#+     +#+        +#+
#+#    #+#    #+#     #+#        #+#
######### ########### ########## ##########

 */


public abstract class Engine extends OpMode {

    //Array To Hold States
    public State[][] processes = new State[100][100];

    //Array For Holding Threads
    private Thread[] threads = new Thread[100];

    //Array For Holding SubEngins
    private SubEngine[] subEngines = new SubEngine[100];

    //Sub Process States array
    private State[][] subProcesses;

    //Keep Track of processes X and Y
    private int processesX = 0;
    private int processesY = 0;

    //Keep Track of sub Processes X and Y
    private int subX = 0;

    private boolean checkingStates = true;

    boolean isSubEngineinit = false;

    private static String TAG = "PROGRAM.ENGINE: ";
    private static String SUBTAG = "PROGRAM.SUBENGINE";
    private int x = 0;
    private boolean machineFinished = false;
    private boolean opFininished = true;

    private boolean subProcessFinished = true;


    //sets processes
    public void init() {
        //Call Set Processes to fill arrays with states
        setProcesses();

        //Loop through to processes array and initialize states
        for (int i = 0; i < processes.length; i++) {
            for (int y = 0; y < processes.length; y++) {
                if (processes[i][y] != null) {
                    processes[i][y].init();
                    Log.i(TAG, "INIT" + "[" + Integer.toString(i) + "]" + "[" + Integer.toString(y) + "]");
                }
            }
        }
    }

    //checks if ops are finished
    public void loop() {

        //check if we are checking states
        if(checkingStates) {
            checkStateFinished();

        //Check if we are checking states inside sub engines
        }else{

            //Run evaluate on sub engines
            subEngines[x].evaluate();

            //Check if sub engine is runnable
            if(subEngines[x].isRunable()) {

                //check sub engines
                checkSubEngines();
            }else{
                //if engine is not runnable than incrament x and switch to "checking states"
                Log.i(TAG, "SUB ENGINE NOT RUNNABLE : " + "[" + Integer.toString(x) + "]" + "[0]");
                checkingStates = true;
                x++;
            }
        }

    }

    //kills all processes running when program endes
    @Override
    public void stop() {
        for (int x = 0; x < processes.length; x++) {
            for (int y = 0; y < processes.length; y++) {
                if (processes[x][y] != null) {
                    processes[x][y].setFinished(true);
                    processes[x][y].stop();
                    Log.i(TAG, "KILLED OP : " + "[" + Integer.toString(x) + "]" + "[" + Integer.toString(y) + "]");
                } else {
                    break;
                }
            }
        }
    }

    public void checkStateFinished(){

        //check to make sure the current state or whole machine isnt finished
        if (!opFininished && !machineFinished) {

            //Loop through to check if all sections of the current
            // state are finished, if so set opFinsished to true
            for (int y = 0; y < processes.length; y++) {

                if (processes[x][y] != null) {
                    if (processes[x][y].getIsFinished()) {
                        opFininished = true;
                        Log.i(TAG, "FINISHED OP : " + "[" + Integer.toString(x) + "]" + "[" + Integer.toString(y) + "]");
                    } else {
                        opFininished = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (opFininished) {
                x++;
            }


        } else {
            //If opmode is finished than set up the next set of processes or
            if (processes[x][0] != null) {
                //set next state
                for (int i = 0; i < processes.length; i++) {
                    threads[i] = new Thread(processes[x][i]);
                    threads[i].start();
                }
                opFininished = false;
                Log.i(TAG, "Started State : " + Integer.toString(x));


            }else if(subEngines[x] != null){
                checkingStates = false;
            }
            else if (processes[x][0] == null && !machineFinished) {
                Log.i(TAG, "MACHINE TERMINATED");
                machineFinished = true;
                stop();
            }

        }
    }

    public void checkSubEngines(){


        // Check if sub engines need to be initialized
        if(!isSubEngineinit){
            //Run set Proccesses on the sub engine
            subEngines[x].setProcesses();

            //Add all the processes of the sub engine to the subProcesses array
            subProcesses = subEngines[x].getProcesses();

            Log.i(TAG, "CREATED SUB ENGINE : " + "[" + Integer.toString(x) + "]" + "[0]");

            //Loop through all the sub processes and initialize them
            for(int i = 0; i < subProcesses.length; i ++){
                for(int y = 0; y < subProcesses.length; y ++ ){
                    if(subProcesses[i][y] != null){
                        String msg ="INTITALIZED SUBSTATE : " +"[" + Integer.toString(i) +"]" + "["+Integer.toString(y)+"]";
                        Log.i(SUBTAG,msg );
                        subProcesses[i][y].init();
                    }
                }
            }

            //set subEngineInit to true so this only runs through once
            isSubEngineinit = true;
        }

        //if the sub processes is finished then set up next sub state
        if(subProcessFinished){
            if(subProcesses[subX][0] != null){

                for (int i = 0; i < subProcesses.length; i++) {
                    threads[i] = new Thread(subProcesses[subX][i]);
                    threads[i].start();
                }
                subProcessFinished = false;
                Log.i(SUBTAG, "STARTED SUB STATE : " + Integer.toString(subX));

            }else{
                x++;
                checkingStates = true;
            }
        }else{

            //looping through sub processes to check if they are finished
            for(int i = 0; i < subProcesses.length; i ++){
                if(subProcesses[subX][i]!= null){
                    if(subProcesses[subX][i].getIsFinished()){
                        subProcessFinished = true;
                        Log.i(SUBTAG, "FINISHED SUB OP : " + "[" + Integer.toString(subX) + "]" + "[" + Integer.toString(i) + "]");
                    }else{
                        subProcessFinished = false;
                    }
                }else{
                    break;
                }

                if(subProcessFinished){
                    subX++;
                }
            }
        }

    }

    //set processes in extended classes
    public abstract void setProcesses();

    public int getProcessIndex() {
        return x;
    }

    //adds the ability to add processes inside states
    public void addInLineProcess(State state,boolean init) {
        for(int i = 0; i < processes.length;i ++){
            if(processes[x][i] == null || processes[x][i].getIsFinished()){
                if(init){
                    state.init();
                }
                processes[x][i] = state;
                Thread thread = new Thread(processes[x][i]);
                thread.start();
                Log.i(TAG, "ADDED THREAD AT : " + "[" + Integer.toString(getProcessIndex()) + "]" + "[" + Integer.toString(i) + "]");
                break;
            }
        }

    }

    //For adding states when setProcesses is called
    public void addState(State state){

        processesY = 0;

        processes[processesX][processesY] = state;

        processesY++;
        processesX++;

        Log.i(TAG, "ADDED NEW STATE AT : " + Integer.toString(processesX) );

    }

    public void addThreadedState(State state){
        processes[processesX -1][processesY] = state;
        processesY++;
    }

    public void addSubEngine(SubEngine subEngine){
        subEngines[processesX] = subEngine;
        processesX++;
    }

}
