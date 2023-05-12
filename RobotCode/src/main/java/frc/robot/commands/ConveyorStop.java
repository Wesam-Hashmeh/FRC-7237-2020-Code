package frc.robot.commands;

//Author: Amal and Wesam
//date: 1/26/2020
//purpose: conveyor belt stop command

import frc.robot.*;
import edu.wpi.first.wpilibj.command.Command;

public class ConveyorStop extends Command {
 
  public ConveyorStop() {
    requires(Robot.conveyorBelt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.conveyorBelt.stop();
  }

  // Called once the command ends or is interrupted.
  

  // Returns true when the command sho  uld end.
  @Override
  public boolean isFinished() {
    return true;
  }
  @Override
  // Called once after isFinished returns true
  protected void end() {
  }
}
