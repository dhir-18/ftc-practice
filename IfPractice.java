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
        boolean aButton = gamepad1.a;
        if (aButton == true) {
            telemetry.addLine("A button pressed");
        }

        telemetry.addData("A button state: ", aButton);
    }
}
