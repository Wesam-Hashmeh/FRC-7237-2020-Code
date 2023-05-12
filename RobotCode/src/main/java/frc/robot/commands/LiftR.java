package frc.robot.commands;
/*
Author: Amal
Date: 1/25/2020
Purpose: Intake motor command
*/
import frc.robot.*;
import edu.wpi.first.wpilibj.command.Command;

public class LiftR extends Command {
  public LiftR() {
    requires(Robot.lift);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.lift.ReverseLift();
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
