package org.usfirst.frc.team7195.robot.commands;

import org.usfirst.frc.team7195.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoystick extends Command {
	public DriveWithJoystick() {
		requires(Robot.m_drivetrain);
	}

	@Override
	protected void execute() {
		Robot.m_drivetrain.arcadeDriveJoy(Robot.m_oi.getJoystick());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.m_drivetrain.stop();
	}
}
