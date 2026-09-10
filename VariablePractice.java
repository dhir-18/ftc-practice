package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class VariablePractice extends OpMode {
    @Override
    public void init() {
        int teamNumber = 23014;
        double motorSpeed = 0.75;
        boolean clawClosed = true;
        String teamName = "Wilsonic Boom";

        telemetry.addData("Team Number", teamNumber);
        telemetry.addData("motor speed", motorSpeed);
        telemetry.addData("Claw Closed", clawClosed);
        telemetry.addData("Team Name", teamName);
    }

    @Override
    public void loop() {

    }
}
