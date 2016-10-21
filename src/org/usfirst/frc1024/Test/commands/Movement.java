package org.usfirst.frc1024.Test.commands;

import org.usfirst.frc1024.Test.RobotMap;
import org.usfirst.frc1024.Test.subsystems.drivetrain;

import edu.wpi.first.wpilibj.Timer;

public class Movement {

	public static void driveForFeet(int feet, double power){
		RobotMap.drivetrainleft
		int ticks = (int) ((500*feet)/Math.PI);
		while(RobotMap.leftEncoder.getDistance() < ticks){
			drivetrain.left.set(power);
			drivetrain.right.set(power);
		}
		drivetrain.left.set(0);
		drivetrain.right.set(0);
	}
	public static void driveForSeconds(int time, double power){
		drivetrain.left.set(power);
		drivetrain.right.set(power);
		Timer.delay(time);
		drivetrain.left.set(power);
		drivetrain.right.set(power);
	}
}

