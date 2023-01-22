package frc.robot.subsystems;
/*
Author: Amal
Date: 1/25/2020
Purpose: Intake
*/
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;

public class IntakeOuttake extends Subsystem {
  // Motor instantiation
  WPI_VictorSPX motor = new WPI_VictorSPX(RobotMap.iInOut);

  // Creates the intake method (motor is on)
  public void motorIn() {
  
    motor.set(RobotMap.iIn);  
    
  }
  // Creates the stop method
  public void stop() {
		motor.set(RobotMap.uSTOP);
  }
  
  // creates the reverse/out method
  public void motorOut() {
    motor.set(RobotMap.iOut);
  }

  @Override
  protected void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new StopInOut());

  }
}
