package frc.robot.commands;
/*
Author: Wesam
Date: 1/25/2020
Purpose: Intake command stop
*/
import frc.robot.*;
import edu.wpi.first.wpilibj.command.Command;

public class StopInOut extends Command {
  public StopInOut() {
    requires(Robot.intakeOut);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.intakeOut.stop();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void interrupted() {

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
