package org.firstinspires.ftc.teamcode;

public class RobotLocationPractice {
    double angle;

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

    public void turnRobot(double angleChange) {
        angle += angleChange;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return this.angle;
    }

    double x;

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
