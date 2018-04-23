package org.usfirst.frc.team7195.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class forklift extends Subsystem {
	// Devices
	Compressor m_compressor = new Compressor();
	DoubleSolenoid m_grabber = new DoubleSolenoid(0, 1);
	Solenoid m_piston = new Solenoid(2);
	Talon m_elevator = new Talon(2);
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

	public forklift() {
		//addChild("Compressor", m_compressor);
		//addChild("Piston Solenoid", m_piston);
		//addChild("Grabber Solenoid", m_grabber);
		
	}
	
	public void togglePiston()	{
		if (m_piston.get() == false) {
			m_piston.set(true);
		} else {
			m_piston.set(true);
		}
	}
	
	public void grab() {
		m_grabber.set(DoubleSolenoid.Value.kForward);
	}
		
	public void release() {
		m_grabber.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void lockgrabber() {
		m_grabber.set(DoubleSolenoid.Value.kForward);
	}
	
	public void elevateup() {
		m_elevator.set(-0.8);
	}
	
	public void elevatedown() {
		m_elevator.set(0.8);
	}
	
	public void stopelevator() {
		m_elevator.set(0);
	}
	
	public void comptoggle() {
		//m_compressor.setClosedLoopControl(true);
		//m_compressor.start();
		if (m_compressor.enabled() == false) {
			m_compressor.setClosedLoopControl(true);
			m_compressor.start();
		} else {
			m_compressor.setClosedLoopControl(false);
			m_compressor.stop();
			m_compressor.clearAllPCMStickyFaults();
		}
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

