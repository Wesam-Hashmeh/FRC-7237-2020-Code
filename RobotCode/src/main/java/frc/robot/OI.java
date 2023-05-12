package frc.robot;

/*
Author: Software 
Date: N/A
Purpose: Input Controller
*/
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;
//import sun.launcher.resources.launcher; error????

public class OI { //Creates button Object
  public Joystick stick = new Joystick(RobotMap.jPORT);
  Button intakeButton = new JoystickButton(stick, RobotMap.jINTAKE),
    outtakeButton = new JoystickButton(stick, RobotMap.jOUTTAKE),
    conveyorButton = new JoystickButton(stick, RobotMap.jCONVEYOR),
    conveyorButton2 = new JoystickButton(stick, RobotMap.jLAUNCHER),  //Just an idea for when we we want to launch multiple balls, the conveyor and launcher are active simultaneously.
    launcherButton = new JoystickButton(stick, RobotMap.jLAUNCHER),
    riseButton = new JoystickButton(stick, RobotMap.jRISE),
    riserevButton = new JoystickButton(stick, RobotMap.jRISEREV),
    liftButton = new JoystickButton(stick, RobotMap.jLIFT),
    distanceButton = new JoystickButton(stick, RobotMap.jAdjust),
    RliftButton = new JoystickButton(stick, RobotMap.jRLIFT);
  public OI(){ //Action for button 
    intakeButton.whileActive(new Intake());
    outtakeButton.whileActive(new Outtake());
    outtakeButton.whileActive(new ConveyorReverse());
    conveyorButton.whileActive(new ConveyorForward());
    //conveyorButton2.whileActive(new ConveyorForward());
    distanceButton.whileActive(new AdjustDistance());
    launcherButton.whileActive(new LauncherShoot());
    riseButton.whileActive(new Rise());
    riserevButton.whileActive(new RiseReverse());
    liftButton.whileActive(new Lift());
    RliftButton.whileActive(new LiftR());
  }


}
