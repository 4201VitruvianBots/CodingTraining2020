/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Intake extends Subsystem {
  private TalonSRX cargoIntakeMotor = new TalonSRX(RobotMap.cargoIntakeMotor);
  private TalonSRX hatchIntakeMotor = new TalonSRX(RobotMap.hatchIntakeMotor);
  public Intake() {

  }
  public void moveCargoMotor(double speed){
    cargoIntakeMotor.set (ControlMode.PercentOutput, speed);
  }
  public void moveHatchMotor(double speed){
    hatchIntakeMotor.set (ControlMode.PercentOutput, speed);
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
