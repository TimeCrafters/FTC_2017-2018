package org.timecrafters.gfp.state.cam;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.timecrafters.engine.Engine;
import org.timecrafters.gfp.config.Config;

/**
 * Created by t420 on 9/16/2017.
 */

public class ReadCam extends Config {

    public ReadCam(Engine engine){
        super(engine);
    }

    VuforiaLocalizer vuforia;

    int cameraMonitorViewId = engine.hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", engine.hardwareMap.appContext.getPackageName());
    VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

    public static final String LICENSE_KEY = "AcU+kbn/////AAAAGWDmHA7mS0gCoiMy9pA5e1AVyLZeqKejLOtP9c3COfi9g9m4Cs1XuVQVdqRFhyrFkNUynXwrhQyV65hPnPkGgRky9MjHlLLCWuqdpHzDLJonuOSBh5zVO11PleXH+2utK1lCnbBxvOM+/OrB9EAHUBrcB0ItRxjzFQOe8TXrjGGe1IyjC/Ljke3lZf/LVVinej3zjGNqwsNQoZ0+ahxYNPCJOdzRFkXjyMDXJVDQYMtVQcWKpbEM6dJ9jQ9f0UFIVXANJ7CC8ZDyrl2DQ8o4sOX981OktCKWW0d4PH0IwAw/c2nGgt1t2V/7PwTwysBYM1N+SjVpMNRg52u9gNl9os4ulF6AZw+U2LcVj4kqGZDi";


    //Trackables
    VuforiaTrackables relicTrackables;
    VuforiaTrackable relicTemplate;

    private RelicRecoveryVuMark vuMark;

    int count = 0;

    public void init(){
        super.init();

        //add license key
        parameters.vuforiaLicenseKey = LICENSE_KEY;

        //specify camera
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;

        //create vuforia
        vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        relicTrackables = vuforia.loadTrackablesFromAsset("RelicVuMark");
        relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate");

        relicTrackables.activate();

        //Load data set containing VuMarks for relic recovery tracking

    }
    public void exec(){

        vuMark = RelicRecoveryVuMark.from(relicTemplate);


        if (vuMark != RelicRecoveryVuMark.UNKNOWN) {

            engine.telemetry.addData("VuMark", "%s visible", vuMark);
            setFinished(true);

        }else {
            engine.telemetry.addData("VuMark", "not visible");
        }



        engine.telemetry.update();
    }



    String format(OpenGLMatrix transformationMatrix) {
        return (transformationMatrix != null) ? transformationMatrix.formatAsTransform() : "null";
    }

    public RelicRecoveryVuMark getVuMark() {
        return vuMark;
    }
}
