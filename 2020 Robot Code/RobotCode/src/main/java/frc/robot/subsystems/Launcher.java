package frc.robot.subsystems;
/*
Author: Wesam and Mohamad Amjad Alzein
Date: 1/27/2020
Purpose: Launcher Shooting subsystem
*/
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
import frc.robot.commands.*;

public class Launcher extends Subsystem  {
  /**
   * Creates a new Launcher.
   */


    final CANSparkMax LaunchMotor = new CANSparkMax(RobotMap.lLauncher, MotorType.kBrushless);

    public void Shoot(){
      LaunchMotor.set(RobotMap.lForward);
     
    }

    public void stop(){
      LaunchMotor.set(RobotMap.uSTOP);
      
    }        
     
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  protected void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new LauncherStop());
  }
}
