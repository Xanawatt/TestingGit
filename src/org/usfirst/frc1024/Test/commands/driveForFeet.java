package org.usfirst.frc1024.Test.commands;

import edu.wpi.first.wpilibj.command.Command;

public class driveForFeet extends Command {
	boolean isDone;
	public static double feet = 0;
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		isDone = false;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		while(isDone == false){
			
			
			
			
			
			isDone = true;
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
