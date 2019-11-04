/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.commands.SetElevator;
import frc.robot.commands.StartIntake;
import frc.robot.commands.WristMove;
import frc.robot.subsystems.Wrist;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);
    public Joystick leftJoystick = new Joystick(RobotMap.leftJoystick);
    public Joystick rightJoystick = new Joystick(RobotMap.rightJoystick);
    Joystick xBoxController = new Joystick(RobotMap.wristButtonPort);
    public Button[] leftJoystickButtons;
    Button[] xBoxControllerButtons;

    public OI() {
        xBoxControllerButtons = new Button[xBoxController.getButtonCount()];
        for(int i = 0; i < xBoxControllerButtons.length; i++)
            xBoxControllerButtons[i] = new JoystickButton(xBoxController, i + 1);
        xBoxControllerButtons[5].whileHeld(new SetElevator(0.5)); //elevator down
        xBoxControllerButtons[4].whileHeld(new SetElevator(-0.5)); //elevator up
        xBoxControllerButtons[2].whileHeld(new StartIntake(0.75)); //intake out
        xBoxControllerButtons[1].whileHeld(new StartIntake(-0.75)); //intake in
        xBoxControllerButtons[3].whileHeld(new WristMove(0.50)); //wrist in
        xBoxControllerButtons[0].whileHeld(new WristMove(-0.50)); //wrist out


        leftJoystickButtons = new JoystickButton[leftJoystick.getButtonCount()];
        for(int i=0; i<leftJoystickButtons.length;i++){
            leftJoystickButtons[i] = new JoystickButton(leftJoystick, i + 1);
//            leftJoystickButtons[2].whileHeld(new Robot.elevator.setElevatorOutput(0.25));
//            leftJoystickButtons[3].whileHeld(new setElevatorOutput(-0.25));
        }
    }

    public double getJoystickLeftY() {
        return leftJoystick.getY();
    }

    public double getJoystickRightY() {
        return rightJoystick.getY();
    }
}
