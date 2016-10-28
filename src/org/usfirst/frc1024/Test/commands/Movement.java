package org.usfirst.frc1024.Test.commands;

import org.usfirst.frc1024.Test.Robot;
import org.usfirst.frc1024.Test.RobotMap;
import org.usfirst.frc1024.Test.subsystems.driveleft;
import org.usfirst.frc1024.Test.subsystems.driveright;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Movement {
	
	public static final driveleft left = new driveleft();
	public static final driveright right = new driveright();
	
	public static void drive(double leftPower, double rightPower){
		driveleft.left.set(leftPower);
		driveright.right.set(rightPower);
	}
	public static void driveForFeet(int feet, double power){
		int ticks = (int) ((500*feet)/Math.PI);
		while(RobotMap.leftEncoder.getDistance() < ticks){
			Movement.drive(power, power);
		}
		Movement.drive(0, 0);
	}
	public static void driveStraightSeconds(int time, double power){
		Movement.drive(power, power);
		Timer.delay(time);
		Movement.drive(0, 0);
	}
	/*public static void driveStraightInches(int inches, double power){
		RobotMap.gyro.reset();
		power = -power;
		RobotMap.leftEncoder.reset();
		RobotMap.rightEncoder.reset();
		int ticks = (int) ((500*inches)/Math.PI)*12;
		while(RobotMap.leftEncoder.getDistance() < ticks){
			double angle = RobotMap.gyro.getAngle();
			Movement.drive(power - RobotMap.gyro.getAngle() / 10, power + RobotMap.gyro.getAngle() / 10);
			SmartDashboard.putNumber("Gyro", angle);
		}
		RobotMap.myRobot.drive(0, 0); 
	}*/
	
	public static void driveToAngle(double angle, double power){
		double gyroAngle = RobotMap.gyro.getAngle();
		while(angle != gyroAngle){
			while(angle < gyroAngle){
				Movement.drive(1,-1);
			}
			while(angle > gyroAngle){
				Movement.drive(-1, 1);
			}
		}
		Movement.drive(0, 0);
	}
	//Method for going in a specific direction with Mecanum wheels.
	//When implementing, assign the 4 values accordingly.
	//
	public static void driveAtAngle(double angle, double power){
		double leftFront = power * Math.sin(angle + (Math.PI/4));
		double rightFront = power * Math.cos(angle + (Math.PI/4));
		double leftRear = power * Math.cos(angle + (Math.PI/4));
		double rightRear = power * Math.sin(angle + (Math.PI/4));
	}
	public static void driveAtAngle(double angle, double power, double rotationSpeed){
		double leftFront = power * Math.sin(angle + (Math.PI/4)) + rotationSpeed;
		double rightFront = power * Math.cos(angle + (Math.PI/4)) - rotationSpeed;
		double leftRear = power * Math.cos(angle + (Math.PI/4)) + rotationSpeed;
		double rightRear = power * Math.sin(angle + (Math.PI/4)) - rotationSpeed;
	}
	
	public static void pidDrive(double distance){
		left.pidWrite(distance);
		right.pidWrite(distance);
		left.pid.enable();
		right.pid.enable();
	}
	public static void pidStopDrive(){
		left.pidWrite(0.0);
		right.pidWrite(0.0);
		left.pid.enable();
		right.pid.enable();
	}
	
	
	
	
	
	
	
}