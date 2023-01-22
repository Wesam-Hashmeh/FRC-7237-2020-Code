package frc.robot;
/*
Author: Software Team
Date: Everyday
Purpose: Main Class
*/
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRXPIDSetConfiguration;
import com.ctre.phoenix.motorcontrol.SensorCollection;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  //Creates Objects so the Robot class can use the subsystems
  public static DriveBase drivebase;  
  public static IntakeOuttake intakeOut;
  public static ConveyorBelt conveyorBelt;
  public static OI oi;
 // public static Climb climb;
  
  // Constants
  // public static final double kDistancePerRevolution = 18.84;  // guestimate from your code
  // public static final double  = 1024;     // for an AS5145B Magnetic Encoder
  // public static final double kDistancePerPulse = kDistancePerRevolution / kPulsesPerRevolution;

  // private Encoder leftEncoder = new Encoder(1, 2, false, EncodingType.k4X);
  // private Encoder rightEncoder = new Encoder(3, 4, true, EncodingType.k4X);    // Count direction reversed
  

  WPI_TalonSRX left_front = new WPI_TalonSRX(RobotMap.fLEFT);
  WPI_TalonSRX left_back = new WPI_TalonSRX(RobotMap.bLEFT);
  WPI_TalonSRX right_front = new WPI_TalonSRX(RobotMap.fRIGHT);
  WPI_TalonSRX right_back = new WPI_TalonSRX(RobotMap.bRIGHT);
  
  SensorCollection encoder1 = new SensorCollection (left_front);
  SensorCollection encoder2 = new SensorCollection (left_back);
  SensorCollection encoder3 = new SensorCollection (right_front);
  SensorCollection encoder4 = new SensorCollection (right_back);

  //Command m_autonomousCommand;
  //SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  

   
   public Robot(){
     

    /*mecDrive = new RobotDrive(kFrontLeftChannel, kRearLeftChannel, kFrontRightChannel, kRearRightChannel);
    mecDrive.setInvertedMotor(MotorType.kFrontLeft, true);
    mecDrive.setInvertedMotor(MotorType.kRearLeft, true);
    mecDrive.setExpiration(.1);*/
 
  }
  
   @Override
  public void robotInit() {
    //Creates Objects so the Robot class can use the subsystems
    drivebase = new DriveBase();
    intakeOut = new IntakeOuttake();
    conveyorBelt = new ConveyorBelt();
    oi = new OI();//OI must be the last object declared
  //  climb = new Climb();
    
    /*
    leftEncoder.setDistancePerPulse(kDistancePerPulse);
    rightEncoder.setDistancePerPulse(kDistancePerPulse);
*/
    //leftEncoder.start();
    //rightEncoder.start();

   // resetEncoders();

  }

 

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
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

    MecanumDrive mecDrive = new MecanumDrive(right_front, right_back,left_front, left_back);
    resetEncoders();

    switch(RobotMap.PATH)
    {
      case 0:
        do {
          mecDrive.driveCartesian(-1, 0, 0, 0);
        } 
        while (getAverageEncoderPosition() < 10.0); // Drives for 50
        
        resetEncoders();

    
        do {
          mecDrive.driveCartesian(0, 1, 0, 0);
        }
        while (getAverageEncoderPosition() < 10.0 - RobotMap.POSITION * 2.0);

        

      break;
      case 1:

        do {
          mecDrive.driveCartesian(0, .25, 0, 0);
        }
        while (getAverageEncoderPosition() < 50.0 - RobotMap.POSITION * 10.0);

        resetEncoders();

        do {
          mecDrive.driveCartesian(-.25, 0, 0, 0);
        } 
        while (getAverageEncoderPosition() < 50.0); // Drives for 50
        


      break;
    }

    //m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */
      
    
    // schedule the autonomous command (example)
   // if (m_autonomousCommand != null) 
    //  m_autonomousCommand.start();
   // }
   
      private double getAverageEncoderPosition() {
    return (encoder1.getQuadraturePosition() + encoder2.getQuadraturePosition() +
            encoder3.getQuadraturePosition() + encoder4.getQuadraturePosition()) / 4.0;
}

private void resetEncoders() {
    encoder1.setQuadraturePosition(0,0);
    encoder2.setQuadraturePosition(0,0);
    encoder3.setQuadraturePosition(0,0);
    encoder4.setQuadraturePosition(0,0);
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
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
   // if (m_autonomousCommand != null) {
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
