package org.usfirst.frc.team7195.robot.subsystems;

import org.usfirst.frc.team7195.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class drivetrain extends Subsystem {
	// Constants for some useful speeds
	public static final double kForward = 1;
	public static final double kStop = 0;
	public static final double kReverse = -1;

	// Subsystem devices
	private SpeedController m_leftSpark = new Spark(0);
	private SpeedController m_rightSpark = new Spark(1);
	private DifferentialDrive m_drive;
	
	public drivetrain() {
		// Configure drive motors
		addChild("Left Wheels", (Spark) m_leftSpark);
		addChild("Right Wheel", (Spark) m_rightSpark);
		
		m_drive = new DifferentialDrive(m_leftSpark, m_rightSpark);
		m_drive.setSafetyEnabled(true);
		m_drive.setExpiration(0.5);
		m_drive.setMaxOutput(1.0);
	}
		
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void arcadeDriveJoy(Joystick joy) {
    	double throttle = ((-joy.getRawAxis(3))+1)/2;
		double drive = -(joy.getY()*throttle);
		double turning = (joy.getX()*throttle);
		m_drive.arcadeDrive(drive, turning);
		//m_drive.arcadeDrive(-joy.getY(), joy.getX());
	}
    
	public void tankDriveJoy(Joystick rightJoy, Joystick leftJoy) {
		m_drive.tankDrive(rightJoy.getY(), leftJoy.getY());
	}
	
	public void arcadeDrive() {
		m_drive.arcadeDrive(0.5, 0);
	}
    
	public void tankDrive(double m_rightForwardSpeed, double m_leftForwardSpeed) {
		//m_drive.tankDrive(m_rightForwardSpeed, m_leftForwardSpeed);
		m_drive.tankDrive(m_rightForwardSpeed, m_leftForwardSpeed);

	}
	
	public void stop() {
		m_drive.tankDrive(0, 0);
	}

}

