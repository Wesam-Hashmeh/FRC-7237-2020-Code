package frc.robot;
/*
Author: Software Team
Date: N/A
Purpose: Constants
*/

public class RobotMap {
  // Drivebase 
		// Talon SRX Ids
		final public static int fLEFT = 1;
    final public static int fRIGHT = 2;
    final public static int bLEFT = 3;
    final public static int bRIGHT = 4;
    // Turning Multiplier
    final public static double tMULTI = .25;
    final public static double uDEADZONE = .15;
    final public static double uDEADZONE_Z = .3;   
    final public static double xyzMULTI = 1;
    final public static double uDEADZONE_X = .25; 
    final public static double xMULTI = 1;
    final public static double zMULTI = .35;
    final public static double xyzEXPOSENS = 3;
    final public static double xEXPOSENS = 3;
    
  // Intake/Outtake
    // VictorSRX Id
    final public static int iInOut = 5;
    // Intake/Outtake Speeds
    final public static double iIn = .5;
    final public static double iOut = -.5;
  
  // Conveyor Belt
    // Speed 
      final public static double cForward = .5;
      final public static double cReverse = -.5;
    //VictorSRX Id
      public static int cConveyorBelt = 6;

  //Launching
    //Speed
    final public static double lForward = 1;
    //VictorSRX Id
    public static int lLauncher = 6;
    //Speed   

  // Joystick	
		// FlightStick
    final public static int jPORT = 0;
		// Button Bindings
    final public static int jINTAKE = 2;
    final public static int jOUTTAKE = 3;
    final public static int jCONVEYOR = 2;
    final public static int jLAUNCHER = 1;
    final public static int jRISE = 6;
    final public static int jRISEREV = 4;
    final public static int jLIFT = 11;
    final public static int jRLIFT = 7;
    final public static int jAdjust = 5;
    
  // Autonomous Variables
    //Constants
    final public static int PATH = 0; // Path 0 passes the line first, Path 1 shoots first then crosses the line
    final public static int POSITION = 0; // Position 0 is the rightmost position with respect to the driver, position 1 is the middle, position 2 is the left
    final public static double rPERCEN_X = 86.11111111111111;
    final public static double rPERCEN_Y = 77.5;
    final public static double rPERCEN_Z = 80;
    final public static double ZFACTOR = 0.0191568458;
    final public static double delay = 0;

	// Universal (Several Subsystem)
		//Deadzone
    final public static double uSTOP = 0;   
    final public static double uONE = 1;

  //Lift
    //Speeds
    final public static double lLift = 1;
    final public static double RLift = -1;
    final public static double lRise = .6;
    final public static double lRiseReverse = -.4;
    //Ports
    final public static int lRisePort = 0;
    final public static int lLiftPort = 1;
  
  //Sensors
    //Ports
      final public static int sULTRASONIC = 0;
    //Values
      final public static double sMeters = .00125;
      final public static double sDistance = 1.4;//distance from robot to hoop
      final public static double sError = .07;
}
