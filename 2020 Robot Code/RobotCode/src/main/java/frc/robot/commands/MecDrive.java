package frc.robot.commands;
/*
Author: Wesam
Date: 1/13/2020
Purpose: Drivebase motor commands
*/

import frc.robot.*;
import edu.wpi.first.wpilibj.command.Command;

public class MecDrive extends Command {
  public MecDrive() {
    //Robot.drivebase is the drivebase object declared in Robot
    requires(Robot.drivebase);
  }

  
  @Override
  protected void initialize() {
  }

 
  @Override
  protected void execute() {
    double x,y,z;
    //These if-elses create a deadzone so that the robot with only move if joystick is moved far enough(Prevents jerky, unintended movement)
		if (Math.abs(Robot.oi.stick.getX()) > RobotMap.uDEADZONE)
		  x = Math.pow((((Robot.oi.stick.getX()*RobotMap.xMULTI)-RobotMap.uDEADZONE)/(RobotMap.uONE-RobotMap.uDEADZONE_X)),RobotMap.xEXPOSENS);
    else
      x = RobotMap.uSTOP;
    if (Math.abs(Robot.oi.stick.getY()) > RobotMap.uDEADZONE)
      y = Math.pow((((Robot.oi.stick.getY()*RobotMap.xyzMULTI)-RobotMap.uDEADZONE)/(RobotMap.uONE-RobotMap.uDEADZONE)),RobotMap.xyzEXPOSENS);
    else
      y = RobotMap.uSTOP;
    if (Math.abs(Robot.oi.stick.getZ()) > RobotMap.uDEADZONE_Z)
      z = Robot.oi.stick.getZ()*RobotMap.zMULTI;
    else
      z = RobotMap.uSTOP;
    //Passes the joystick axis values into the drive method to move the robot
		Robot.drivebase.teleopDrive(x , y, z);
  }


  
  @Override
  protected boolean isFinished() {
    //Returns false becasuse we want the driving to remain on all match(We never want it to finish)
    return false;
  }

 
  @Override
  protected void end() {
    Robot.drivebase.teleopDrive(RobotMap.uSTOP, RobotMap.uSTOP,RobotMap.uSTOP);
  }

 
  @Override
  protected void interrupted() {
  }
}
