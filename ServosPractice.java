package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

// Practices driving a single servo (a motor that holds a fixed position, 0.0 to 1.0)
// using gamepad input, plus toggling it between two preset positions.
@TeleOp
public class ServosPractice extends OpMode {
    Servo claw;

    // preset positions for an open/close claw servo
    static final double CLAW_OPEN = 0.0;
    static final double CLAW_CLOSED = 0.5;

    boolean clawOpen = true;
    boolean lastAState; // used to detect the moment A is first pressed, not held

    @Override
    public void init() {
        claw = hardwareMap.get(Servo.class, "claw"); // must match the name set in the robot config
        claw.setPosition(CLAW_OPEN);
    }

    @Override
    public void loop() {
        boolean aState = gamepad1.a;

        // toggle only on the rising edge (the loop the button first becomes pressed),
        // so holding A doesn't rapidly flip the claw open/closed every loop iteration
        if (aState && !lastAState) {
            clawOpen = !clawOpen;
            claw.setPosition(clawOpen ? CLAW_OPEN : CLAW_CLOSED);
        }
        lastAState = aState;

        // right trigger drives the servo directly to any position between open and closed,
        // for manual/analog control instead of the A button preset toggle
        if (gamepad1.right_trigger > 0.05) {
            claw.setPosition(gamepad1.right_trigger);
        }

        telemetry.addData("Claw Open", clawOpen);
        telemetry.addData("Servo Position", claw.getPosition());
    }
}
