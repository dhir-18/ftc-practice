package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class GamePadPractice extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        // runs 50x a second

        double speedForward = -gamepad1.left_stick_y / 2.0;
        double difference = gamepad1.left_stick_x - gamepad1.right_stick_x;

        telemetry.addData("x", gamepad1.left_stick_x);  // check which gamepad you need to use for this
        telemetry.addData("y", speedForward);
        telemetry.addData(" a button ", gamepad1.a);

        telemetry.addData("x2", gamepad1.right_stick_x);
        telemetry.addData("y2", gamepad1.right_stick_y);

        telemetry.addData("b button", gamepad1.b);
        telemetry.addData("difference between right x and left x", difference);

    }
}
