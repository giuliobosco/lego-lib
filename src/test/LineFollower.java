import lejos.nxt.*;
import java.lang.Thread;
import javax.microedition.lcdui.Graphics;


public class LineFollower
{
	public LightSensor light;
	
	public char motorLeft = 'A';
	
	public char motorRight = 'B';
	
	public LineFollower(int sensor, char left, char right){
		if(sensor == 1){			
			LightSensor light = new LightSensor(SensorPort.S1);
		}else if(sensor == 2){
			LightSensor light = new LightSensor(SensorPort.S2);
		}else if(sensor == 3){
			LightSensor light = new LightSensor(SensorPort.S3);
		}else if(sensor == 4){
			LightSensor light = new LightSensor(SensorPort.S4);
		}
		motorLeft = left;
		motorRight = right;
	}
	
	public void main(String[] args)
	{
		LineFollower ln = new LineFollower(1,'A','B');
		ln.lineFollower(true, 100, 360);
		Motor.A.forward();
		Motor.B.forward();
	}
	
	public void setMotorSpeed(char name, int speed){
		if(name == 'A'){
			Motor.A.setSpeed(speed);
		}else if(name == 'B'){
			Motor.B.setSpeed(speed);
		}else if(name == 'C'){
			Motor.C.setSpeed(speed);
		}
	}
	
	public void lineFollower(boolean flag, int minSpeed, int maxSpeed){
		while(flag){
			if(light.getLightValue()>45){
				setMotorSpeed(motorLeft, maxSpeed);
				setMotorSpeed(motorRight, minSpeed);
			}else{
				setMotorSpeed(motorRight, maxSpeed);
				setMotorSpeed(motorLeft, minSpeed);
			}
		}
	}
}