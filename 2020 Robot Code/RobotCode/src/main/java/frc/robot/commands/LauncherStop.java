package frc.robot.commands;
/*
Author: Wesam
Date: 1/27/2020
Purpose: Launcher Stop Command
*/
import frc.robot.*;
import edu.wpi.first.wpilibj.command.Command;

public class LauncherStop extends Command {
  /**
   * Creates a new LauncherStop.
   */
  public LauncherStop() {
    requires(Robot.launcher);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.launcher.stop();
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
