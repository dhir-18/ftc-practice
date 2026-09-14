package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

@TeleOp
public class LimelightMegaTag2Practice extends OpMode {
    Limelight3A limelight;
    IMU imu;

    @Override
    public void init() {
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(0);
        limelight.start();

        imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
        )));
    }

    @Override
    public void loop() {
        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
        double yaw = orientation.getYaw(AngleUnit.DEGREES);

        limelight.updateRobotOrientation(yaw); // must be called before getLatestResult()
        LLResult result = limelight.getLatestResult();

        telemetry.addData("IMU Yaw (deg)", yaw);

        if (result != null && result.isValid()) {
            Pose3D botposeMT2 = result.getBotpose_MT2();
            telemetry.addData("Botpose (MT2)", botposeMT2.toString());
            telemetry.addData("Tags Used", result.getBotposeTagCount());
            telemetry.addData("Avg Tag Distance (m)", result.getBotposeAvgDist());
        } else {
            telemetry.addData("Botpose (MT2)", "No tags in view");
        }
    }

    @Override
    public void stop() {
        limelight.stop();
    }
}
