package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

// Practices Pedro Pathing's PIDF tuning workflow: the follower holds a fixed point, and you
// physically push/turn the robot to see how hard the translational and heading PIDFs correct
// back to that point. Tune by editing the coefficients in PedroPathingConstants.java and
// redeploying - too weak and the robot won't return, too strong and it oscillates/shakes.
@TeleOp
public class PIDFTunerPractice extends OpMode {
    Follower follower;
    Pose holdPose;

    @Override
    public void init() {
        follower = PedroPathingConstants.createFollower(hardwareMap);
        holdPose = new Pose(0, 0, 0);
        follower.setStartingPose(holdPose);
    }

    @Override
    public void start() {
        follower.activateAllPIDFs(); // turns on translational + heading + drive correction
        follower.holdPoint(holdPose);
    }

    @Override
    public void loop() {
        follower.update();

        Pose current = follower.getPose();
        telemetry.addData("Target X/Y/Heading", "%.2f, %.2f, %.2f",
                holdPose.getX(), holdPose.getY(), holdPose.getHeading());
        telemetry.addData("Actual X/Y/Heading", "%.2f, %.2f, %.2f",
                current.getX(), current.getY(), current.getHeading());
    }

    @Override
    public void stop() {
        follower.deactivateAllPIDFs();
    }
}
