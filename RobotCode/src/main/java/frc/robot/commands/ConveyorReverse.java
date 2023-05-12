package frc.robot.commands;

//Author: Amal and Wesam
//date: 1/26/2020
//purpose: conveyer belt thingy idk how to spell it

import frc.robot.*;
import edu.wpi.first.wpilibj.command.Command;

public class ConveyorReverse extends Command {
  /**
   * Creates a new ConveyorForward.
   */
  public ConveyorReverse() {
    requires(Robot.conveyorBelt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.conveyorBelt.reverse();
  }

  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
  @Override
      // Called once after isFinished returns true
      protected void end() {
      }
}
