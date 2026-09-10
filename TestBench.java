package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench {
    private DigitalChannel touchSensor;

    public void init(HardwareMap hwMap) {
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");
        // assigning the touch sensor from the hwMap to this variable
        touchSensor.setMode(DigitalChannel.Mode.INPUT);
    }

    // getter method
    public boolean getTouchSensorState() {
        return !touchSensor.getState();
    }
}
