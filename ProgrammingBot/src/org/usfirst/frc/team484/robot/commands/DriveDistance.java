package org.usfirst.frc.team484.robot.commands;

import org.usfirst.frc.team484.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveDistance extends Command {
	PIDController pid;
	double setpoint;
    public DriveDistance(double setpoint) {
    	this.setpoint = setpoint;
       requires(Robot.driveTrain);
       pid = new PIDController(0.27, 0.0, 0.75, new PIDSource() {
			
			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public double pidGet() {
				return Robot.driveEncoder.getDistance();
			}
			
			@Override
			public PIDSourceType getPIDSourceType() {
				// TODO Auto-generated method stub
				return PIDSourceType.kDisplacement;
			}
		}, new PIDOutput() {
			
			@Override
			public void pidWrite(double output) {
				Robot.aH.arcadeDrive(-output, 0);
				
			}
		});
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveEncoder.reset();
    	pid.reset();
    	pid.setSetpoint(setpoint);
    	pid.setOutputRange(-0.8, 0.8);
    	pid.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Error", pid.getError());
    	System.out.println(pid.getError());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	pid.disable();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
