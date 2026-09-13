package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

// Plain helper class that wraps a Limelight3A camera, similar in spirit to TestBench.java
public class LimelightBench {
    private Limelight3A limelight;
    private LLResult latestResult;

    public void init(HardwareMap hwMap) {
        limelight = hwMap.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(0); // pipeline 0 = whatever was set up on the Limelight web UI
        limelight.start(); // must call start(), or getLatestResult() always returns null
    }

    // call once per loop before reading tx/ty/hasTarget so they reflect the newest frame
    public void update() {
        latestResult = limelight.getLatestResult();
    }

    public boolean hasTarget() {
        return latestResult != null && latestResult.isValid();
    }

    // horizontal offset from crosshair to target, in degrees (+ = target is right of crosshair)
    public double getTx() {
        return hasTarget() ? latestResult.getTx() : 0.0;
    }

    // vertical offset from crosshair to target, in degrees (+ = target is above crosshair)
    public double getTy() {
        return hasTarget() ? latestResult.getTy() : 0.0;
    }

    // approximate percentage of the image the target takes up, useful as a distance proxy
    public double getTargetArea() {
        return hasTarget() ? latestResult.getTa() : 0.0;
    }

    public void setPipeline(int index) {
        limelight.pipelineSwitch(index);
    }

    public void stop() {
        limelight.stop();
    }
}
