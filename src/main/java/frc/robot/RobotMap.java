/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static int leftFrontDriveMotor = 20;
    public static int rightFrontDriveMotor = 22;
    public static int leftRearDriveMotor = 21;
    public static int rightRearDriveMotor = 23;

    public static int leftJoystick = 0;
    public static int rightJoystick = 1;
    public static int xBoxController = 2;
}
