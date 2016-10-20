// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1024.Test;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc1024.Test.commands.*;
import org.usfirst.frc1024.Test.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Command autonomousCommand;
	Command resetEncoders;

	public static OI oi;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static drivetrain drivetrain;
	boolean isDone = false;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		RobotMap.init();
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		drivetrain = new drivetrain();

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		//(which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// instantiate the command used for the autonomous period
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

		autonomousCommand = new AutonomousCommand();
		resetEncoders = new TeleopCommand();
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

		drivetrain.left.setInverted(true);
		drivetrain.right.setInverted(true);
		
		RobotMap.Ultra.setAutomaticMode(true);
	}

	/**
	 * This function is called when the disabled button is hit.
	 * You can use it to reset subsystems before shutting down.
	 */
	public void disabledInit(){

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		/*RobotMap.navx.zeroYaw();
    	RobotMap.navx.reset();
    	RobotMap.navx.resetDisplacement();
    	RobotMap.navx.startLiveWindowMode();*/
		if (autonomousCommand != null) autonomousCommand.start();
		RobotMap.leftEncoder.reset();
		RobotMap.rightEncoder.reset();

	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		while(isDone == false){
			/*while(RobotMap.leftEncoder.getDistance() < 2500 && RobotMap.rightEncoder.getDistance() > -2500){
    			drivetrain.left.set(0.3);
    			drivetrain.right.set(0.3);
    			SmartDashboard.putNumber("leftEncoder", RobotMap.leftEncoder.getDistance());
    			SmartDashboard.putNumber("rightEncoder", RobotMap.rightEncoder.getDistance());
    		}
    		drivetrain.left.set(0);
			drivetrain.right.set(0);
			SmartDashboard.putNumber("leftEncoder", RobotMap.leftEncoder.getDistance());
			SmartDashboard.putNumber("rightEncoder", RobotMap.rightEncoder.getDistance());
			isDone = true; */


			while(RobotMap.leftEncoder.getDistance() < 2500 && RobotMap.rightEncoder.getDistance() > -2500){

				while(Math.abs(RobotMap.leftEncoder.getDistance()) == Math.abs(RobotMap.rightEncoder.getDistance())){
					drivetrain.left.set(.5);
					drivetrain.right.set(.5);
				}
				while(Math.abs(RobotMap.leftEncoder.getDistance()) > Math.abs(RobotMap.rightEncoder.getDistance())){
					drivetrain.left.set(.4);
					drivetrain.right.set(.5);
				}
				while(Math.abs(RobotMap.leftEncoder.getDistance()) < Math.abs(RobotMap.rightEncoder.getDistance())){
					drivetrain.left.set(.5);
					drivetrain.right.set(.4);
				}

			}
		}

	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) autonomousCommand.cancel();
		/*  RobotMap.navx.zeroYaw();
    	RobotMap.navx.reset();
    	RobotMap.navx.resetDisplacement();
    	RobotMap.navx.startLiveWindowMode();*/
		RobotMap.gyro.reset();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//RobotMap.transmiter.set(true);
		//SmartDashboard.putBoolean("IR Breakbeam", RobotMap.reciever.get());
		//SmartDashboard.putNumber("TestEncoders", RobotMap.testEncoder.getDistance());
		//SmartDashboard.putData(resetEncoders);
		RobotMap.drivetrainleft.set(oi.logi.getRawAxis(1)*0.5);
		RobotMap.drivetrainright.set(oi.logi.getRawAxis(3)*0.5);
		//SmartDashboard.putNumber("Gyro", RobotMap.gyro.getAngle());
		//SmartDashboard.putNumber("Gyrospeed", RobotMap.gyrospeed.getRate());
		SmartDashboard.putNumber("Ultra", RobotMap.Ultra.getRangeInches());
		SmartDashboard.putNumber("Ping", RobotMap.Ultrasonic.getVoltage());
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
