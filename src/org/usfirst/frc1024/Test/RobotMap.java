// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1024.Test;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Servo;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.interfaces.Gyro;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Talon drivetrainright;
    public static Talon drivetrainleft;
    public static Encoder gyrospeed;
    //public static AHRS navx;
    //public static Servo climberFlinger;
    public static Encoder leftEncoder;
    public static Encoder rightEncoder;
    //public static Encoder testEncoder;
    public static AnalogGyro gyro;
    public static DigitalOutput ping;
    public static DigitalInput echo;
    public static AnalogInput Ultrasonic;
    public static Ultrasonic Ultra;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrainright = new Talon(0);
        LiveWindow.addActuator("drivetrain", "right", drivetrainright);
        
        drivetrainleft = new Talon(1);
        LiveWindow.addActuator("drivetrain", "left", drivetrainleft);
        
        //navx = new AHRS(SerialPort.Port.kMXP);
        //LiveWindow.addActuator("drivetrain", "navx", navx);
        
        //climberFlinger = new Servo(8);
        //LiveWindow.addActuator("drivetrain", "Servo", climberFlinger);
        
        leftEncoder = new Encoder(0,1);
        LiveWindow.addActuator("drivetrain", "Encoder", leftEncoder);

        rightEncoder = new Encoder(2,3);
        LiveWindow.addActuator("drivetrain", "Encoder", rightEncoder);
        
        //testEncoder = new Encoder(4,5);
        
        gyro = new AnalogGyro(1);
        LiveWindow.addActuator("drivetrain", "Gyro", gyro);
        
        //gyrospeed = new Encoder(1, 0);
        
        
        ping = new DigitalOutput(5);
        echo = new DigitalInput(4);
        
        Ultrasonic = new AnalogInput(3);
        Ultra = new Ultrasonic(ping, echo);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
