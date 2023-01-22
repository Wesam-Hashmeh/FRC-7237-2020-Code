package frc.robot;
import com.ctre.phoenix.motorcontrol.NeutralMode;

/*
Author: Software Team
Date: Everyday
Purpose: Main Class
*/
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import org.opencv.core.Mat;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSource.ConnectionStrategy;
import edu.wpi.first.cameraserver.CameraServer;

public class Robot extends TimedRobot {
  //Creates Objects so the Robot class can use the subsystems
  public static DriveBase drivebase;  
  public static IntakeOuttake intakeOut;
  public static ConveyorBelt conveyorBelt;
  public static Launcher launcher;
  public static Lift lift;
  public static Rise rise;  
  public static AnalogGyro m_gyro;
  public static AnalogInput ultrasonic;
  public static OI oi;   
  public Thread visionThread;
  public Robot(){ 
  }
  
   @Override
  public void robotInit() {
    //Creates Objects so the Robot class can use the subsystems
    drivebase = new DriveBase();
    intakeOut = new IntakeOuttake();
    conveyorBelt = new ConveyorBelt();
    launcher = new Launcher();
    lift = new Lift();
    rise = new Rise();
    ultrasonic = new AnalogInput(RobotMap.sULTRASONIC);
    m_gyro = new AnalogGyro(1);    
    oi = new OI();
    m_gyro.reset();
    m_gyro.calibrate();
    m_gyro.setSensitivity(0.128);
    DriveBase.left_back.setInverted(true);
    DriveBase.left_front.setInverted(true);
    DriveBase.right_back.setInverted(true);
    DriveBase.right_front.setInverted(true);
    DriveBase.left_back.setNeutralMode(NeutralMode.Brake);
    DriveBase.left_front.setNeutralMode(NeutralMode.Brake);
    DriveBase.right_back.setNeutralMode(NeutralMode.Brake);
    DriveBase.right_front.setNeutralMode(NeutralMode.Brake);
    SmartDashboard.putNumber("Left_Front Drive Encoder", Autonomous.encoder1.getQuadraturePosition());//OI must be the last object declared
    SmartDashboard.putNumber("Left_Rear Drive Encoder", Autonomous.encoder2.getQuadraturePosition());
    SmartDashboard.putNumber("Right_Front Drive Encoder", Autonomous.encoder3.getQuadraturePosition());
    SmartDashboard.putNumber("Right_Rear Drive Encoder", Autonomous.encoder4.getQuadraturePosition());
    new Thread(() -> {
        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setResolution(320,240);
        camera.setFPS(30);
        camera.setExposureManual(45);
        camera.setConnectionStrategy(ConnectionStrategy.kKeepOpen);
      }).start();
	
  }

  @Override
  public void robotPeriodic() {
  }
  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {   
  }
  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    Autonomous.runAutonoumous();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
  //if (m_autonomousCommand != null) {
    //  m_autonomousCommand.cancel();
    //}
}

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();  
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
