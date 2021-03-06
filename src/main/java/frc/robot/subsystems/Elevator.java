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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.SetElevator;
import frc.robot.commands.SetTankDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private TalonSRX le = new TalonSRX(RobotMap.leftElevatorMotor);
  private TalonSRX re = new TalonSRX(RobotMap.rightElevatorMotor);


  public Elevator(){
    re.set(ControlMode.Follower, le.getDeviceID());

    re.setInverted(false);
    le.setInverted(false);

  }

  public void setElevatorOutput(double elevatorOutput){
    le.set(ControlMode.PercentOutput, elevatorOutput);

  }
  public int getLeftEncoderCount(){
    return le.getSelectedSensorPosition();
  }
  public int getRightEncoderCount(){
    return re.getSelectedSensorPosition();
  }
  public double getLeftRPM(){
    return le.getSelectedSensorVelocity();
  }
  public double getRightRPM(){
    return re.getSelectedSensorVelocity();
  }
  public void updateSmartDashboard() {
    SmartDashboard.putNumber("leftEncoderCount", getLeftEncoderCount());
    SmartDashboard.putNumber("rightEncoderCount", getRightEncoderCount());
    SmartDashboard.putNumber("leftRPM", getLeftRPM());
    SmartDashboard.putNumber("rightRPM", getRightRPM());
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.

  }
}
