package frc.robot.subsystems;

//Author: Amal and Wesam
//Date: 1/26/2020
//Purpose: Conveyor belt

import edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.*;

public class Lift extends Subsystem {
 
  final Spark lift = new Spark(RobotMap.lLiftPort);

    public void lift(){
      lift.set(RobotMap.lLift);
    }

    public void ReverseLift(){
      lift.set(RobotMap.RLift);
    }

    public void liftStop(){
      lift.set(RobotMap.uSTOP);
    }
    
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  protected void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new LiftStop());
  }
}
