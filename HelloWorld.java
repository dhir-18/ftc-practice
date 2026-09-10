package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class HelloWorld extends OpMode { // public all places can see this class

    @Override
    public void init() {
        telemetry.addData("Hello", "World");

    }

    @Override
    public void loop() {

    }
}
