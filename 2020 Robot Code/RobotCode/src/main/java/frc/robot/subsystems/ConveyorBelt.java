package frc.robot.subsystems;

//Author: Amal and Wesam
//Date: 1/26/2020
//Purpose: Conveyor belt

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.*;

public class ConveyorBelt extends Subsystem {
 
    final WPI_VictorSPX conveyorMotor1 = new WPI_VictorSPX(RobotMap.cConveyorBelt);
    final WPI_VictorSPX conveyorMotor2 = new WPI_VictorSPX(RobotMap.cConveyorBelt);

    public void forward(){
      conveyorMotor1.set(RobotMap.cForward);
      conveyorMotor2.set(RobotMap.cForward);
    }

    public void stop(){
      conveyorMotor1.set(RobotMap.uSTOP);
      conveyorMotor2.set(RobotMap.uSTOP);
    }

    public void reverse(){
      conveyorMotor1.set(RobotMap.cReverse);
      conveyorMotor2.set(RobotMap.cReverse);
    }
    
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  protected void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ConveyorStop());
  }
}
