package frc.robot.subsystems;
/*
	Author: Mohamad and Mohammad
	Date: 1/29/2020
	Subject: Autonomous Period
*/

import frc.robot.*;

import com.ctre.phoenix.motorcontrol.SensorCollection;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Timer;

public class Autonomous extends Subsystem{
	//Creating encoder objects
  public static SensorCollection encoder1 = new SensorCollection (DriveBase.left_front);
  public static SensorCollection encoder2 = new SensorCollection (DriveBase.left_back);
  public static SensorCollection encoder3 = new SensorCollection (DriveBase.right_front);
  public static SensorCollection encoder4 = new SensorCollection (DriveBase.right_back);

  

	public static void runAutonoumous(){

    Timer.delay(RobotMap.delay);
    adjustDistance();
    Timer.delay(.5);
    shoot();
  //  moveRobot(70, 0, 0, .5); 
  // moveRobot(0, 0, 180, .5); 
	}

	private static void moveRobot(double x, double y, double z, double speed){//Moves robot coordinates x,y,z over (3*time) seconds
    double x_speed, y_speed, z_speed;
		x_speed = (x >= 0)? speed: -speed; 
		y_speed = (y >= 0)? speed: -speed; 
		z_speed = (z >= 0)? speed: -speed;
    x*=RobotMap.rPERCEN_X; //Ratios from unit to cm
    y*=RobotMap.rPERCEN_Y; //        ''
    z*=RobotMap.rPERCEN_Z; //        '

    resetEncoders();
		while (avgEncoder() < Math.abs(x))
      Robot.drivebase.teleopDrive(x_speed, 0, 0); // Need to add a correction factor thing here
    stopRobot();
		resetEncoders();
		while (avgEncoder() < Math.abs(y))
      Robot.drivebase.teleopDrive(0, -y_speed,0);
    stopRobot();
		resetEncoders();
		while (avgEncoder() < Math.abs(z))
      Robot.drivebase.teleopDrive(0, 0,z_speed);
    stopRobot();
    resetEncoders();
  }


  public static double avgEncoder ()
  {
      return (Math.abs(encoder1.getQuadraturePosition()) + 
              Math.abs(encoder2.getQuadraturePosition()) +
              Math.abs(encoder3.getQuadraturePosition()) +
              Math.abs(encoder4.getQuadraturePosition())) / 4.0;
  }

  public static void stopRobot(){
    Robot.drivebase.teleopDrive(0, 0, 0);
    Timer.delay(.2);
  }

  public static void shoot(){
    Robot.conveyorBelt.forward();
    Robot.launcher.Shoot();
    Timer.delay(5);  
    Robot.conveyorBelt.stop();
    Robot.launcher.stop();
  }

	public void initDefaultCommand(){
  }

  public static void resetEncoders() {
    encoder1.setQuadraturePosition(0,0);
    encoder2.setQuadraturePosition(0,0);
    encoder3.setQuadraturePosition(0,0);
    encoder4.setQuadraturePosition(0,0);
  }
  public static void adjustDistance(){
    boolean check = true;
  for (int count = 0; count<3; count++){
    check = true;
    while(check){
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
      else{
        Robot.drivebase.teleopDrive(0,0,0);
        check = false;
      }      
      Timer.delay(.01);
  }
  }
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
