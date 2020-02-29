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
import frc.robot.commands.SetTankDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private TalonSRX lf = new TalonSRX(RobotMap.leftFrontDriveMotor);
  private TalonSRX lr = new TalonSRX(RobotMap.leftRearDriveMotor);
  private TalonSRX rf = new TalonSRX(RobotMap.rightFrontDriveMotor);
  private TalonSRX rr = new TalonSRX(RobotMap.rightRearDriveMotor);


  public DriveTrain (){
    rr.set(ControlMode.Follower, rf.getDeviceID());
    lr.set(ControlMode.Follower, lf.getDeviceID());

    lf.setInverted(false);
    lr.setInverted(false);
    rr.setInverted(true);
    rf.setInverted(true);
  }

  public void setDriveOutput(double leftoutput, double rightoutput){
    rf.set(ControlMode.PercentOutput, rightoutput);
    lf.set(ControlMode.PercentOutput, leftoutput);
  }
  public int getLeftEncoderCount(){
    return lf.getSelectedSensorPosition();
  }
  public int getRightEncoderCount(){
    return rf.getSelectedSensorPosition();
  }
  public double getLeftRPM(){
    return lf.getSelectedSensorVelocity();
  }
  public double getRightRPM(){
    return rf.getSelectedSensorVelocity();
  }
  public void updateSmartDashboard(){
    SmartDashboard.putNumber("leftEncoderCount", getLeftEncoderCount());
    SmartDashboard.putNumber("rightEncoderCount", getRightEncoderCount());
    SmartDashboard.putNumber("leftRPM", getLeftRPM());
    SmartDashboard.putNumber("rightRPM", getRightRPM());
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new SetTankDrive());
  }
}