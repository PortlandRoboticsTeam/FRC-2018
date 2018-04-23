package org.usfirst.frc.team7195.robot.commands;

import org.usfirst.frc.team7195.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveForward extends Command {
	Timer autoTimer = new Timer();
	
	//private long m_startTime;
	
    public AutoDriveForward() {
        
    	requires(Robot.m_drivetrain);
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	autoTimer.reset();
    	autoTimer.start();
    	//m_startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_drivetrain.tankDrive(0.5, 0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return (autoTimer < 8)
    	return autoTimer.get() >= 8; //(System.currentTimeMillis() > (m_startTime + 8000));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	autoTimer.stop();
    }
}
