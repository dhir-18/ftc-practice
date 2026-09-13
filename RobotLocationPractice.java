package org.firstinspires.ftc.teamcode;

// Plain (non-OpMode) class that models the robot's heading and x-position, so location
// tracking logic can be tested/reused separately from any particular OpMode.
public class RobotLocationPractice {
    double angle; // heading in degrees, can grow unbounded (not normalized until getHeading())

    public RobotLocationPractice(double angle) {
        this.angle = angle;
    }

    // this method normalises robot heading between -180 and 180
    // this is useful for calculating turn angles
    public double getHeading() {
        double angle = this.angle;
        while (angle > 180) {
            angle -= 360;
        }

        while (angle <= -180) {
            angle += 360;
        }

        return angle;
    }

    // incrementally adjusts heading, e.g. from a turn command each loop iteration
    public void turnRobot(double angleChange) {
        angle += angleChange;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    // raw (non-normalized) angle — use getHeading() if you need it in -180..180 range
    public double getAngle() {
        return this.angle;
    }

    double x; // robot's position along the x-axis

    // incrementally adjusts x, e.g. from a strafe/drive command each loop iteration
    public void changeX(double changeAmount) {
        x += changeAmount;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return this.x;
    }
}
