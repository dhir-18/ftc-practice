package org.firstinspires.ftc.teamcode;

import com.pedropathing.control.FilteredPIDFCoefficients;
import com.pedropathing.control.PIDFCoefficients;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.robotcore.hardware.HardwareMap;

// This is where Pedro Pathing's PIDF gains live - translational (holds X/Y position),
// heading (holds rotation), and drive (holds speed along the path). Tune these using
// PIDFTunerPractice.java, editing the numbers here and redeploying between attempts.
public class PedroPathingConstants {
    public static FollowerConstants followerConstants = new FollowerConstants()
            .translationalPIDFCoefficients(new PIDFCoefficients(0.1, 0, 0, 0.015))
            .headingPIDFCoefficients(new PIDFCoefficients(1, 0, 0, 0.01))
            .drivePIDFCoefficients(new FilteredPIDFCoefficients(0.025, 0, 0.00001, 0.6, 0.01));

    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100, 1, 1);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pathConstraints(pathConstraints)
                .build();
    }
}
