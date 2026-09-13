package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class VariablePractice extends OpMode {
    @Override
    public void init() {
        // one example of each basic Java type, just to practice declaring/displaying them
        int teamNumber = 23014;       // whole numbers
        double motorSpeed = 0.75;     // decimal numbers (motor power is always -1.0 to 1.0)
        boolean clawClosed = true;    // true/false
        String teamName = "Wilsonic Boom"; // text

        telemetry.addData("Team Number", teamNumber);
        telemetry.addData("motor speed", motorSpeed);
        telemetry.addData("Claw Closed", clawClosed);
        telemetry.addData("Team Name", teamName);
    }

    @Override
    public void loop() {

    }
}
