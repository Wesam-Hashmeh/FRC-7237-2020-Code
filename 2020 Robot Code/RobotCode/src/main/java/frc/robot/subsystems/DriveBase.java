package frc.robot.subsystems;
/*
Author: Wesam
Date: 1/13/2020
Purpose: Intake
*/
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.commands.MecDrive;
import frc.robot.*;
import edu.wpi.first.wpilibj.Timer;

public class DriveBase extends Subsystem {
//Declares the Motor Controllers using their CAN Id as parameters
  public static WPI_TalonSRX left_front = new WPI_TalonSRX(RobotMap.fLEFT);
  public static WPI_TalonSRX left_back = new WPI_TalonSRX(RobotMap.bLEFT);
  public static WPI_TalonSRX right_front = new WPI_TalonSRX(RobotMap.fRIGHT);
  public static WPI_TalonSRX right_back = new WPI_TalonSRX(RobotMap.bRIGHT);
  
//Creates MecanumDrive object that simplifies the complex algorithm into a method
  MecanumDrive mecDrive = new MecanumDrive(right_front, right_back,left_front, left_back);

  //Method that takes the x,y, and z axis and makes it drive (this method will be referenced in the command)
  public void teleopDrive(double x, double y, double z){
    // if (y == 0 && z == 0)
    // {
      

    // }
    // else
    mecDrive.driveCartesian(x, y, z);
    SmartDashboard.putNumber("Left_Front Drive Encoder", -Autonomous.encoder1.getQuadraturePosition());//OI must be the last object declared
    SmartDashboard.putNumber("Left_Rear Drive Encoder", Autonomous.encoder2.getQuadraturePosition());
    SmartDashboard.putNumber("Right_Front Drive Encoder", -Autonomous.encoder3.getQuadraturePosition());
    SmartDashboard.putNumber("Right_Rear Drive Encoder", Autonomous.encoder4.getQuadraturePosition());
    SmartDashboard.putNumber("Ultrasonic Distance",Robot.ultrasonic.getValue()*RobotMap.sMeters);
  }

  public void adjustDistance(){
    
      if (Math.abs(((Robot.ultrasonic.getValue())*RobotMap.sMeters))>(RobotMap.sError+RobotMap.sDistance))
        if (((((Robot.ultrasonic.getValue())*RobotMap.sMeters))-RobotMap.sDistance)>.3)
          Robot.drivebase.teleopDrive(0,-.2,0);
        else 
        Robot.drivebase.teleopDrive(0,-.125,0);
      else if (Math.abs(((Robot.ultrasonic.getValue())*RobotMap.sMeters))<(RobotMap.sDistance-RobotMap.sError))
        if (((((Robot.ultrasonic.getValue())*RobotMap.sMeters))-RobotMap.sDistance)<-.3)
          Robot.drivebase.teleopDrive(0,.2,0);
        else 
          Robot.drivebase.teleopDrive(0,.125,0);
      else
        Robot.drivebase.teleopDrive(0,0,0);
      
      Timer.delay(.01);
  }
  @Override
  public void initDefaultCommand() {
    //Setting default command
    setDefaultCommand(new MecDrive());
  }
}
