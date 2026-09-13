package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class IfPractice extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        boolean aButton = gamepad1.a; // true while the A button is held down
        if (aButton == true) { // could also just write "if (aButton)" since it's already a boolean
            telemetry.addLine("A button pressed");
        }

        telemetry.addData("A button state: ", aButton);
    }
}
