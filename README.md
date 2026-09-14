# FTC Practice

Java practice programs for FTC (FIRST Tech Challenge) robotics, written against the FTC SDK (`OpMode`, `TeleOp`, `HardwareMap`, gamepad input, etc).

## Files

| File | Purpose |
|---|---|
| `HelloWorld.java` | Simplest possible `OpMode` — sends a "Hello, World" telemetry message on init. Starting point for learning the OpMode lifecycle. |
| `VariablePractice.java` | Declares variables of different types (`int`, `double`, `boolean`, `String`) and displays them via telemetry. Basic variable syntax practice. |
| `variables_classes.java` | Combines a class-level field (`initDone`) with a custom method (`squareInputWithSign`) that squares a joystick input while preserving its sign — used to give finer control at low stick values while keeping direction correct. |
| `IfPractice.java` | Reads the gamepad's A button and uses an `if` statement to print a message when it's pressed. Basic conditional logic practice. |
| `GamePadPractice.java` | Reads and displays multiple gamepad inputs (both joysticks, A/B buttons) via telemetry, including a computed value (difference between the two sticks' x-axes). |
| `ServosPractice.java` | Skeleton `OpMode` (empty `init`/`loop`) intended as a starting point for practicing servo control. |
| `TestBench.java` | Plain (non-OpMode) helper class that wraps a `DigitalChannel` touch sensor: initializes it from the `HardwareMap` and exposes a `getTouchSensorState()` getter. |
| `touchSensorPractice.java` | `OpMode` that uses `TestBench` to read and display the touch sensor's state via telemetry — demonstrates composing an OpMode from a separate hardware-wrapper class. |
| `RobotLocationPractice.java` | Plain class modeling robot position/heading: stores an angle and x-position, with a `getHeading()` method that normalizes the angle to the -180°..180° range, plus setters/getters and methods to incrementally turn or move. |
| `UseRobotLocation.java` | `OpMode` that drives a `RobotLocationPractice` instance from gamepad input — A/B buttons turn the robot, d-pad left/right change its x-position — and displays heading/angle/x via telemetry. |
| `LimelightBench.java` | Plain helper class that wraps a `Limelight3A` camera (mirrors `TestBench.java`) — init, per-loop `update()`, and getters for `hasTarget()`/`getTx()`/`getTy()`/`getTargetArea()`. |
| `LimelightPractice.java` | `OpMode` that uses `LimelightBench` to display basic targeting telemetry — demonstrates composing an OpMode from the Limelight wrapper class. |
| `LimelightAprilTagPractice.java` | `OpMode` that reads AprilTag/fiducial detections directly from a `Limelight3A`, displaying per-tag IDs/angles and the field-relative robot botpose. |
| `LimelightAimPractice.java` | `OpMode` that auto-aims the drivetrain at a target using proportional control on `tx` while a bumper is held — a practical "auto-aim assist" pattern. |
| `LimelightMegaTag2Practice.java` | `OpMode` that feeds IMU yaw into the Limelight each loop (`updateRobotOrientation`) and reads the gyro-assisted MegaTag2 botpose (`getBotpose_MT2`), plus tag-count/distance diagnostics. |

## Suggested reading order

1. `HelloWorld.java`
2. `VariablePractice.java` / `variables_classes.java`
3. `IfPractice.java`
4. `GamePadPractice.java`
5. `TestBench.java` → `touchSensorPractice.java`
6. `RobotLocationPractice.java` → `UseRobotLocation.java`
7. `ServosPractice.java`
8. `LimelightBench.java` → `LimelightPractice.java` → `LimelightAprilTagPractice.java` → `LimelightAimPractice.java` → `LimelightMegaTag2Practice.java`
