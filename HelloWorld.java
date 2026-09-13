package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class HelloWorld extends OpMode { // public all places can see this class

    // init() runs once when the driver hits INIT, before START is pressed
    @Override
    public void init() {
        telemetry.addData("Hello", "World"); // shows "Hello: World" on the Driver Station

    }

    // loop() runs repeatedly (about 50x/second) after START is pressed
    @Override
    public void loop() {

    }
}
