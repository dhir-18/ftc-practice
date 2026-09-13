package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class UseRobotLocation extends OpMode {
    RobotLocationPractice robotLocationPractice = new RobotLocationPractice(0);

    @Override
    public void init() {
        robotLocationPractice.setAngle(0);
        robotLocationPractice.setX(0);

    }

    @Override
    public void loop() {

        // A/B nudge the heading left/right by a small fixed amount each loop while held
        if (gamepad1.a) {
            robotLocationPractice.turnRobot(0.1);
        }

        else if (gamepad1.b) {
            robotLocationPractice.turnRobot(-0.1);
        }

        telemetry.addData("Heading", robotLocationPractice.getHeading()); // normalized -180..180
        telemetry.addData("Angle", robotLocationPractice.getAngle()); // raw, unbounded

        // d-pad left/right nudge the x-position the same way
        if (gamepad1.dpad_left) {
            robotLocationPractice.changeX(-0.1);
        }

        else if (gamepad1.dpad_right) {
            robotLocationPractice.changeX(0.1);
        }

        telemetry.addData("X", robotLocationPractice.getX());

    }
}
