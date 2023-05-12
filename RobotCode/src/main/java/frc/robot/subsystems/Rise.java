package frc.robot.subsystems;

//Author: Amal and Wesam
//Date: 1/26/2020
//Purpose: Conveyor belt

import edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.*;

public class Rise extends Subsystem {
 
  final Spark rise = new Spark(RobotMap.lRisePort);

    public void rise(){
      rise.set(RobotMap.lRise);
    }

    public void riseStop(){
      rise.set(RobotMap.uSTOP);
    }

    public void riseReverse(){
      rise.set(RobotMap.lRiseReverse);
    }
    
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  protected void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new RiseStop());
  }
}
