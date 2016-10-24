package org.usfirst.frc1024.Test.commands;

import org.usfirst.frc1024.Test.RobotMap;
import org.usfirst.frc1024.Test.subsystems.drivetrain;

import edu.wpi.first.wpilibj.Timer;

public class Movement {
	public static void drive(double leftPower, double rightPower){
		drivetrain.left.set(leftPower);
		drivetrain.right.set(rightPower);
	}
	public static void driveForFeet(int feet, double power){
		int ticks = (int) ((500*feet)/Math.PI);
		while(RobotMap.leftEncoder.getDistance() < ticks){
			Movement.drive(power, power);
		}
		Movement.drive(power, power);
	}
	public static void driveForSeconds(int time, double power){
		Movement.drive(power, power);
		Timer.delay(time);
		Movement.drive(power, power);
	}
	public static void driveForInches(int inches, double power){
		int ticks = (int) ((500*inches)/Math.PI)*12;
		while(RobotMap.leftEncoder.getDistance() < ticks){
			Movement.drive(power, power);
		}
	}
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
}