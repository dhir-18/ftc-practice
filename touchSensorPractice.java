package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class touchSensorPractice extends OpMode {
    TestBench bench = new TestBench();

    @Override
    public void init() {
        bench.init(hardwareMap); // init method from other class

    }

    @Override
    public void loop() {
        telemetry.addData("Touch Sensor State", bench.getTouchSensorState());

    }
}
