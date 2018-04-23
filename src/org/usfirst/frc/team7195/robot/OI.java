/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7195.robot;

import org.usfirst.frc.team7195.robot.commands.CompressorToggleAndLog;
import org.usfirst.frc.team7195.robot.commands.ElevateDown;
import org.usfirst.frc.team7195.robot.commands.ElevateUp;
import org.usfirst.frc.team7195.robot.commands.Grab;
import org.usfirst.frc.team7195.robot.commands.Release;
import org.usfirst.frc.team7195.robot.commands.StopElevator;
import org.usfirst.frc.team7195.robot.commands.TogglePistonExtension;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick mainStick = new Joystick(0);
	public static JoystickButton button3 = new JoystickButton(mainStick, 3);
	public static JoystickButton button4 = new JoystickButton(mainStick, 4);
	public static boolean buttonThreeState = button3.get();
	public static boolean buttonFourState = button4.get();
	
	public OI() {
        new JoystickButton(mainStick, 2).whenPressed(new TogglePistonExtension());
		new JoystickButton(mainStick, 1).whileHeld(new Grab());
		new JoystickButton(mainStick, 1).whenReleased(new Release());
		button3.whileHeld(new ElevateDown());
		button3.whenReleased(new StopElevator());
		button4.whileHeld(new ElevateUp());
		button4.whenReleased(new StopElevator());
		new JoystickButton(mainStick, 5).whenPressed(new Grab());
		new JoystickButton(mainStick, 6).whenPressed(new CompressorToggleAndLog());
		
		
		/* Button trigger = new JoystickButton(mainStick, 1);
		Button button2 = new JoystickButton(mainStick, 2);
		Button button3 = new JoystickButton(mainStick, 3);
		Button button4 = new JoystickButton(mainStick, 4);
		Button button5 = new JoystickButton(mainStick, 5);
		Button button6 = new JoystickButton(mainStick, 6);
		Button button11 = new JoystickButton(mainStick, 11);
		Button button12 = new JoystickButton(mainStick, 12);*/
	}
	public Joystick getJoystick() {
		return mainStick;
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
