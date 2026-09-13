package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

// OpMode that uses LimelightBench to read and display basic targeting data via telemetry -
// mirrors how touchSensorPractice.java composes an OpMode from TestBench.java
@TeleOp
public class LimelightPractice extends OpMode {
    LimelightBench limelight = new LimelightBench();

    @Override
    public void init() {
        limelight.init(hardwareMap);
    }

    @Override
    public void loop() {
        limelight.update(); // refresh latest result each loop

        if (limelight.hasTarget()) {
            telemetry.addData("Target", "Found");
            telemetry.addData("tx (deg)", limelight.getTx());
            telemetry.addData("ty (deg)", limelight.getTy());
            telemetry.addData("Target Area", limelight.getTargetArea());
        } else {
            telemetry.addData("Target", "None");
        }
    }

    @Override
    public void stop() {
        limelight.stop();
    }
}
