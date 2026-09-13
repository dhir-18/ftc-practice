package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;

import java.util.List;

// OpMode that reads AprilTag (fiducial) detections directly from a Limelight running an
// AprilTag pipeline, and shows the field-relative robot pose ("botpose") once a tag is visible.
@TeleOp
public class LimelightAprilTagPractice extends OpMode {
    Limelight3A limelight;

    @Override
    public void init() {
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(0); // pipeline 0 configured as AprilTag on the Limelight web UI
        limelight.start();
    }

    @Override
    public void loop() {
        LLResult result = limelight.getLatestResult();

        if (result != null && result.isValid()) {
            List<LLResultTypes.FiducialResult> tags = result.getFiducialResults();
            telemetry.addData("Tags Seen", tags.size());

            for (LLResultTypes.FiducialResult tag : tags) {
                telemetry.addData("Tag ID", tag.getFiducialId());
                telemetry.addData("  tx (deg)", tag.getTargetXDegrees());
                telemetry.addData("  ty (deg)", tag.getTargetYDegrees());
            }

            // field-relative robot pose from AprilTags (needs the field map set up on the Limelight)
            Pose3D botpose = result.getBotpose();
            if (botpose != null) {
                telemetry.addData("Botpose", botpose.toString());
            }
        } else {
            telemetry.addData("AprilTag", "No tags in view");
        }
    }

    @Override
    public void stop() {
        limelight.stop();
    }
}
