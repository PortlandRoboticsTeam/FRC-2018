package org.usfirst.frc.team7195.robot.commands;

import org.usfirst.frc.team7195.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GrabWithUpDown extends CommandGroup {
	
    public GrabWithUpDown() {
    	requires(Robot.m_forklift);
    	addParallel(new Grab());
    	/*Joystick mainStick = OI.getJoystick();
    	JoystickButton button3 = new JoystickButton(mainStick, 3);
    	JoystickButton button4 = new JoystickButton(mainStick, 4);
    	boolean buttonThreeState = button3.get();
    	boolean buttonFourState = button4.get();
    	
    	
    	if (buttonThreeState == true) {
    		addParallel(new ElevateDown());
    	}
    	
    	if (buttonFourState == true) {
    		addParallel(new ElevateUp());
    	} */
    	// Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
