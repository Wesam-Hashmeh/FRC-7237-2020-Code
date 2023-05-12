package frc.robot.commands;
/*
Author: Wesam
Date: 1/27/2020
Purpose: Launcher Shoot Command
*/
import frc.robot.*;
import frc.robot.subsystems.Autonomous;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AdjustDistance extends Command {
  /**
   * Creates a new LauncherShoot.
   */
  public AdjustDistance() {
    requires(Robot.drivebase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {   
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){  
    Robot.drivebase.adjustDistance();
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
