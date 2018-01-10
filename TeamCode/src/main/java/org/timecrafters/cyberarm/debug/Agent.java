package org.timecrafters.cyberarm.debug;

/**
 * Created by cyberarm on 1/9/2018.
 */

/**
 * Service for monitoring time of things
 * `
 * ` Agent.setMilliseconds("String for curiousness")
 * ` thingThatYouWantToTrack();
 * ` Agent.reportMilliseconds();
 * `
 */
public class Agent {
    static long activeMilliseconds;
    static String activeTag;

    static public void setMilliseconds(String tag) {
        activeTag = tag;
        activeMilliseconds = System.currentTimeMillis();
    }

    static public long getMilliseconds() { return activeMilliseconds;}

    static public void puts(String string) {
        System.out.println(string);
    }

    static public void reportMilliseconds() {
        puts(""+activeTag+": Time in milliseconds "+(System.currentTimeMillis()-getMilliseconds()));
    }
}
