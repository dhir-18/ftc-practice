package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

// Autonomous OpMode that drives a single straight-line path using Pedro Pathing's Follower.
@Autonomous
public class PedroPathingAutoPractice extends LinearOpMode {
    Follower follower;

    @Override
    public void runOpMode() {
        follower = PedroPathingConstants.createFollower(hardwareMap);

        Pose startPose = new Pose(0, 0, 0);
        Pose endPose = new Pose(24, 0, 0);
        follower.setStartingPose(startPose);

        PathChain forward = follower.pathBuilder()
                .addPath(new BezierLine(startPose, endPose))
                .setLinearHeadingInterpolation(startPose.getHeading(), endPose.getHeading())
                .build();

        waitForStart();
        if (isStopRequested()) return;

        follower.followPath(forward);
        while (opModeIsActive() && follower.isBusy()) {
            follower.update(); // must be called every loop or the follower does nothing

            telemetry.addData("X", follower.getPose().getX());
            telemetry.addData("Y", follower.getPose().getY());
            telemetry.addData("Heading", follower.getPose().getHeading());
            telemetry.update();
        }
    }
}
