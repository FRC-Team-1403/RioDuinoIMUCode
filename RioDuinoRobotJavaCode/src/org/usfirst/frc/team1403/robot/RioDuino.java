package org.usfirst.frc.team1403.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.SerialPort;

public class RioDuino{
	
	I2C i2c;
	byte[] toSend = new byte[1];
	int gx;
	int gy,gz,ax,ay,az;
	byte[] toGet = new byte[1];
	public RioDuino(){
		//DigitalModule module = DigitalModule.getInstance(2);
		i2c =new I2C(Port.kMXP, 0xA0);
		toGet[0]= 11;
	}
	
	
	
	public int getGyroXRAW(){
		int gx1,gx2,gx3,gx4;
		boolean isNegative=false;
	
		toSend[0] = 1;
		toGet[0] = 111;
		System.out.println("Before: "+toGet[0]);
		//SerialPort.write(toSend, );
		//i2c.write(0x00, ttoSend[0]);
		i2c.transaction(toSend, 1, toGet,1);
		gx1 = toGet[0];
		toSend[0] = 2;
		i2c.transaction(toSend, 1, toGet,1);
		gx2 = toGet[0];
		toSend[0] = 3;
		i2c.transaction(toSend, 1, toGet,1);
		gx3 = toGet[0];
		toSend[0] = 4;
		i2c.transaction(toSend, 1, toGet,1);
		gx4 = toGet[0];
		if(Math.signum(gx1)==-1||Math.signum(gx2)==-1||Math.signum(gx2)==-1){
			gx1*=-1;
			gx2*=-1;
			gx3*=-1;gx4*=-1;
			isNegative=true;
		}
		String gxstring = ""+gx1+gx2+gx3+gx4;
		System.out.println(gxstring);
		gx =Integer.parseInt(gxstring);
		if(isNegative){
			gx*=-1;
		}
		System.out.println("After"+toGet[0]);
		return gx;
		
	}
	public double getGyroYRAW(){
		int gy1,gy2,gy3,gy4;
		boolean isNegative=false;
	
		toSend[0] = 9;
		toGet[0] = 111;
		//System.out.println("Before: "+toGet[0]);
		//SerialPort.write(toSend, );
		
		i2c.transaction(toSend, 1, toGet,1);
		gy1 = toGet[0];
		toSend[0] = 10;
		i2c.transaction(toSend, 1, toGet,1);
		gy2 = toGet[0];
		toSend[0] = 11;
		i2c.transaction(toSend, 1, toGet,1);
		gy3 = toGet[0];
		toSend[0] = 12;
		i2c.transaction(toSend, 1, toGet,1);
		gy4 = toGet[0];
		if(Math.signum(gy1)==-1||Math.signum(gy2)==-1||Math.signum(gy3)==-1||Math.signum(gy4)==-1){
			gy1*=-1;
			gy2*=-1;
			gy3*=-1;
			gy4*=-1;
			isNegative=true;
		}
		String gystring = ""+gy1+gy2+gy3+gy4;
		//System.out.println(gystring);
		gy =Integer.parseInt(gystring);
		if(isNegative){
			gy*=-1;
		}
		//System.out.println("After"+toGet[0]);
		return gy;
		
	
		//lol if this actually works lol lol lol 
		
		//return gy;
		
	}
	public double getGyroZRAW(){
		int gz1,gz2,gz3,gz4;
		boolean isNegative=false;
	
		toSend[0] = 9;
		toGet[0] = 111;
		//System.out.println("Before: "+toGet[0]);
		//SerialPort.write(toSend, );
		
		i2c.transaction(toSend, 1, toGet,1);
		gz1 = toGet[0];
		toSend[0] = 10;
		i2c.transaction(toSend, 1, toGet,1);
		gz2 = toGet[0];
		toSend[0] = 11;
		i2c.transaction(toSend, 1, toGet,1);
		gz3 = toGet[0];
		toSend[0] = 12;
		i2c.transaction(toSend, 1, toGet,1);
		gz4 = toGet[0];
		if(Math.signum(gz1)==-1||Math.signum(gz2)==-1||Math.signum(gz3)==-1||Math.signum(gz4)==-1){
			gz1*=-1;
			gz2*=-1;
			gz3*=-1;
			gz4*=-1;
			isNegative=true;
		}
		String gzstring = ""+gz1+gz2+gz3+gz4;
		//System.out.println(gzstring);
		gz =Integer.parseInt(gzstring);
		if(isNegative){
			gz*=-1;
		}
		//System.out.println("After"+toGet[0]);
		
	
		
		return gz;
		
	}
	public double getAccelXRAW(){

		int ax1,ax2,ax3,ax4;
		boolean isNegative=false;
	
		toSend[0] = 9;
		toGet[0] = 111;
		//System.out.println("Before: "+toGet[0]);
		//SerialPort.write(toSend, );
		
		i2c.transaction(toSend, 1, toGet,1);
		ax1 = toGet[0];
		toSend[0] = 10;
		i2c.transaction(toSend, 1, toGet,1);
		ax2 = toGet[0];
		toSend[0] = 11;
		i2c.transaction(toSend, 1, toGet,1);
		ax3 = toGet[0];
		toSend[0] = 12;
		i2c.transaction(toSend, 1, toGet,1);
		ax4 = toGet[0];
		if(Math.signum(ax1)==-1||Math.signum(ax2)==-1||Math.signum(ax3)==-1||Math.signum(ax4)==-1){
			ax1*=-1;
			ax2*=-1;
			ax3*=-1;
			ax4*=-1;
			isNegative=true;
		}
		String axstring = ""+ax1+ax2+ax3+ax4;
		//System.out.println(axstring);
		ax =Integer.parseInt(axstring);
		if(isNegative){
			ax*=-1;
		}
		//System.out.println("After"+toGet[0]);
		return ax;
		
	}
	public double getAccelYRAW(){
		
		int ay1,ay2,ay3,ay4;
		boolean isNegative=false;
	
		toSend[0] = 9;
		toGet[0] = 111;
		//System.out.println("Before: "+toGet[0]);
		//SerialPort.write(toSend, );
		
		i2c.transaction(toSend, 1, toGet,1);
		ay1 = toGet[0];
		toSend[0] = 10;
		i2c.transaction(toSend, 1, toGet,1);
		ay2 = toGet[0];
		toSend[0] = 11;
		i2c.transaction(toSend, 1, toGet,1);
		ay3 = toGet[0];
		toSend[0] = 12;
		i2c.transaction(toSend, 1, toGet,1);
		ay4 = toGet[0];
		if(Math.signum(ay1)==-1||Math.signum(ay2)==-1||Math.signum(ay3)==-1||Math.signum(ay4)==-1){
			ay1*=-1;
			ay2*=-1;
			ay3*=-1;
			ay4*=-1;
			isNegative=true;
		}
		String aystring = ""+ay1+ay2+ay3+ay4;
		//System.out.println(aystring);
		ay =Integer.parseInt(aystring);
		if(isNegative){
			ay*=-1;
		}
		//System.out.println("After"+toGet[0]);
		return ay;
		
	}
	public double getAccelZRAW(){
		int az1,az2,az3,az4;
		boolean isNegative=false;
	
		toSend[0] = 9;
		toGet[0] = 111;
		//System.out.println("Before: "+toGet[0]);
		//SerialPort.write(toSend, );
		
		i2c.transaction(toSend, 1, toGet,1);
		az1 = toGet[0];
		toSend[0] = 10;
		i2c.transaction(toSend, 1, toGet,1);
		az2 = toGet[0];
		toSend[0] = 11;
		i2c.transaction(toSend, 1, toGet,1);
		az3 = toGet[0];
		toSend[0] = 12;
		i2c.transaction(toSend, 1, toGet,1);
		az4 = toGet[0];
		if(Math.signum(az1)==-1||Math.signum(az2)==-1||Math.signum(az3)==-1||Math.signum(az4)==-1){
			az1*=-1;
			az2*=-1;
			az3*=-1;
			az4*=-1;
			isNegative=true;
		}
		String azstring = ""+az1+az2+az3+az4;
		//System.out.println(azstring);
		az =Integer.parseInt(azstring);
		if(isNegative){
			az*=-1;
		}
		//System.out.println("After"+toGet[0]);
		return az;
		
		//return az;
		
	}
	
	public double getGyroX(){
		return getGyroXRAW()*(4.375/1000);//gyro conversion factor

		
	}
	
public double getGyroY(){
	return getGyroYRAW()*(4.375/1000);
		
	}
public double getGyroZ(){
	return getGyroZRAW()*(4.375/1000);
	
}
public double getAccelX(){
	return getAccelXRAW()*(0.061/1000); //accel conversion factor
	
}
public double getAccelY(){
	return getAccelYRAW()*(0.061/1000);
	
}
public double getAccelZ(){
	
	return getAccelZRAW()*(0.061/1000);
}

	
	
	
	

}
