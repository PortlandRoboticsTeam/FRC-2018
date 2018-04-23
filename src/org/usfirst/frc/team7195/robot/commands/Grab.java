package org.usfirst.frc.team7195.robot.commands;

import org.usfirst.frc.team7195.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Grab extends InstantCommand {

    public Grab() {
        super();
        requires(Robot.m_forklift);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.m_forklift.grab();
    }

}
