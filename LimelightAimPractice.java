package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class LimelightAimPractice extends OpMode {
    LimelightBench limelight = new LimelightBench();
    DcMotor leftDrive;
    DcMotor rightDrive;

    static final double AIM_GAIN = 0.02; // turn power per degree of tx error
    static final double AIM_TOLERANCE_DEGREES = 1.0;

    @Override
    public void init() {
        limelight.init(hardwareMap);
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
    }

    @Override
    public void loop() {
        limelight.update();

        double drive = -gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;

        if (gamepad1.right_bumper && limelight.hasTarget()) {
            double tx = limelight.getTx();
            if (Math.abs(tx) > AIM_TOLERANCE_DEGREES) {
                turn = tx * AIM_GAIN;
            } else {
                turn = 0;
            }
            telemetry.addData("Auto-Aim", "tx=%.2f deg, turn=%.2f", tx, turn);
        } else {
            telemetry.addData("Auto-Aim", gamepad1.right_bumper ? "No Target" : "Off");
        }

        leftDrive.setPower(drive + turn);
        rightDrive.setPower(drive - turn);
    }

    @Override
    public void stop() {
        limelight.stop();
    }
}
