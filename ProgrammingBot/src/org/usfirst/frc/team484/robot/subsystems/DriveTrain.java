package org.usfirst.frc.team484.robot.subsystems;

import org.usfirst.frc.team484.robot.Robot;
import org.usfirst.frc.team484.robot.RobotMap;
import org.usfirst.frc.team484.robot.commands.DrivingAndWhatHaveYou;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DrivingAndWhatHaveYou());
    }
    
    public static void driveWithStick(){
    	Robot.aH.arcadeDrive(Robot.joy);
    	if(Robot.shlurmp.getAverageVoltage() >= 0.6){
    		Robot.aH.arcadeDrive(0.4, 0);
    	}
    }
    
    public static void driveForward(){
    	Robot.aH.arcadeDrive(RobotMap.driveSpeed, 0.0);
    }
    
    public static void donutz(){
    	Robot.aH.arcadeDrive(Robot.joy);
    	if(Robot.shlurmp.getAverageVoltage() >= 0.6){
    		Robot.aH.arcadeDrive(0.4, 0);
    	}
    }
    
}

