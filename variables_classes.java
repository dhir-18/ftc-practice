package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class variables_classes extends OpMode {

    boolean initDone; // class-level field, so it keeps its value across init()/loop() calls

    @Override
    public void init() {
        telemetry.addData("Init", initDone); // false here, since init() hasn't finished yet
        initDone = true;

    }

    // squares the joystick input for finer control near the center of the stick,
    // but re-applies the original sign afterwards (x*x always loses the sign) so the
    // robot still moves in the direction the driver pushed the stick
    double squareInputWithSign(double input) {
        double output = input * input;
        if (input < 0) {
            output *= -1;
        }
        return output;

    }

    @Override
    public void loop() {
        telemetry.addData("Init", initDone); // true here, since init() already ran
        double yAxis = gamepad1.left_stick_y;
        telemetry.addData("Left Stick Normal", yAxis);
        yAxis = squareInputWithSign(yAxis);
        telemetry.addData("Left Stick Modified", yAxis);

    }
}
