
#include <Wire.h>
#include <LSM6.h>
 int gyrox1,gyrox2,gyrox3,gyrox4,gyroy1,gyroy2,gyroy3,gyroy4,gyroz1,gyroz2,gyroz3,gyroz4,accelx1,accelx2,accelx3,accelx4,accely1,accely2,accely3,accely4,accelz1,accelz2,accelz3,accelz4;
LSM6 imu;
 //int gxstable;
int value=0;
char report[80];
int lengthfunction(int number)
{    
      int counter=0;
      while(number)
     {        
            number=number/10;
            counter++;
      }
      return (counter);
}
void setup()
{
  
  Serial.begin(9600);
  Serial.println("Setup");
  Wire.begin(0xA0);
Wire.onReceive(receiveEvent);
Wire.onRequest(pushEvent);
  if (!imu.init())
  {
    Serial.println("Failed to detect and initialize IMU!");
    while (1);
  }
  imu.enableDefault();
}
void receiveEvent(int howMany){
  // imu.read();
 while(Wire.available()){
 value = Wire.read();
//  Serial.println(x);
 // Serial.println("RECEIVED");
// Serial.println(x);
// Wire.write(x);
 }
}
int16_t gx,gy,gz,ax,ay,az;
bool gyro3;

 void pushEvent(int howMany){
  
 // first the code takes the gyro value and splits it into 4 digits and then on command, it will send the three digits over one by one via I2C
gx = imu.g.x;
 gy = imu.g.y;
 gz = imu.g.z;
 ax = imu.a.x;
 ay = imu.a.y;
 az = imu.a.z;
 
   int gxstable = imu.g.x;
    if(lengthfunction(gxstable)==4){
    gyrox1 =(gxstable/1000);
    gyrox2=(gxstable/100)%10;
    gyrox3=(gxstable/10)%10;
    gyrox4 =(((gxstable%1000)%100)%10);
   }
   if(lengthfunction(gxstable)==3){
    gyrox1=0;
    gyrox2=(gxstable/10)/10;
    gyrox3=(gxstable/10)%10;
    gyrox4 =(gxstable%10);
   }
   if(lengthfunction(gxstable)==2){
   // Serial.println(2);
    gyrox1=0;gyrox2=0;
    gyrox3=(gxstable/10)%10;
    gyrox4 =(gxstable%10);
   }
   if(lengthfunction(gxstable)==1){
  //  Serial.println(1);
     gyrox1=0;gyrox2=0;gyrox3=0;
     gyrox4=gxstable;
   }
   int gystable = imu.g.y;
    if(lengthfunction(gystable)==4){
    gyroy1 =(gystable/1000);
    gyroy2=(gystable/100)%10;
    gyroy3=(gystable/10)%10;
    gyroy4 =(((gystable%1000)%100)%10);
   }
   if(lengthfunction(gystable)==3){
    gyroy1=0;
    gyroy2=(gystable/10)/10;
    gyroy3=(gystable/10)%10;
    gyroy4 =(gystable%10);
   }
   if(lengthfunction(gystable)==2){
   // Serial.println(2);
    gyroy1=0;gyroy2=0;
    gyroy3=(gystable/10)%10;
    gyroy4 =(gystable%10);
   }
   if(lengthfunction(gystable)==1){
   // Serial.println(1);
     gyroy1=0;gyroy2=0;gyroy3=0;
     gyroy3=gystable;
   }
    int gzstable = imu.g.z;
    if(lengthfunction(gzstable)==4){
    gyroz1 =(gzstable/1000);
    gyroz2=(gzstable/100)%10;
    gyroz3=(gzstable/10)%10;
    gyroz4 =(((gzstable%1000)%100)%10);
   }
   if(lengthfunction(gzstable)==3){
    gyroz1=0;
    gyroz2=(gzstable/10)/10;
    gyroz3=(gzstable/10)%10;
    gyroz4 =(gzstable%10);
   }
   if(lengthfunction(gzstable)==2){
  //  Serial.println(2);
    gyroz1=0;gyroz2=0;
    gyroz3=(gzstable/10)%10;
    gyroz4 =(gzstable%10);
   }
   if(lengthfunction(gzstable)==1){
   // Serial.println(1);
     gyroz1=0;gyroz2=0;gyroz3=0;
     gyroz4=gzstable;
   }
   
    int axstable = imu.a.x;
    if(lengthfunction(axstable)==4){
    accelx1 =(axstable/1000);
    accelx2=(axstable/100)%10;
    accelx3=(axstable/10)%10;
    accelx4 =(((axstable%1000)%100)%10);
   }
   if(lengthfunction(axstable)==3){
    accelx1=0;
    accelx2=(axstable/10)/10;
    accelx3=(axstable/10)%10;
    accelx4 =(axstable%10);
   }
   if(lengthfunction(axstable)==2){
    //Serial.println(2);
    accelx1=0;accelx2=0;
    accelx3=(axstable/10)%10;
    accelx4 =(axstable%10);
   }
   if(lengthfunction(axstable)==1){
   // Serial.println(1);
     accelx1=0;accelx2=0;accelx3=0;
     accelx4=axstable;
   }
    int aystable = imu.a.y;
    if(lengthfunction(aystable)==4){
    accely1 =(aystable/1000);
    accely2=(aystable/100)%10;
    accely3=(aystable/10)%10;
    accely4 =(((aystable%1000)%100)%10);
   }
   if(lengthfunction(aystable)==3){
    accely1=0;
    accely2=(aystable/10)/10;
    accely3=(aystable/10)%10;
    accely4 =(aystable%10);
   }
   if(lengthfunction(aystable)==2){
    //Serial.println(2);
    accely1=0;accely2=0;
    accely3=(aystable/10)%10;
    accely4 =(aystable%10);
   }
   if(lengthfunction(aystable)==1){
   // Serial.println(1);
     accely1=0;accely2=0;
     accely3=aystable;
   }
    int azstable = imu.a.z;
    if(lengthfunction(azstable)==4){
    accelz1 =(azstable/1000);
    accelz2=(azstable/100)%10;
    accelz3=(azstable/10)%10;
    accelz4 =(((azstable%1000)%100)%10);
   }
   if(lengthfunction(azstable)==3){
    accelz1=0;
    accelz2=(azstable/10)/10;
    accelz3=(azstable/10)%10;
    accelz4 =(azstable%10);
   }
   if(lengthfunction(azstable)==2){
    //Serial.println(2);
    accelz1=0;accelz2=0;
    accelz3=(azstable/10)%10;
    accelz4 =(azstable%10);
   }
   if(lengthfunction(azstable)==1){
   // Serial.println(1);
     accelz1=0;accelz2=0;accelz3=0;
     accelz4=azstable;
   }


   
   
if(value==1){
 
  Wire.write(gyrox1);
}
if(value==2){
  Wire.write(gyrox2);
}
if(value==3){
  Wire.write(gyrox3);
}
if(value==4){
  Wire.write(gyrox4);
}
if(value==5){
 
  Wire.write(gyroy1);
}
if(value==6){
  Wire.write(gyroy2);
}
if(value==7){
  Wire.write(gyroy3);
}
if(value==8){
  Wire.write(gyroy4);
}
if(value==9){
 
  Wire.write(gyroz1);
}
if(value==10){
  Wire.write(gyroz2);
}
if(value==11){
  Wire.write(gyroz3);
}
if(value==12){
  Wire.write(gyroz4);
}
if(value==13){
  Wire.write(accelx1);
}
if(value==14){
 
  Wire.write(accelx2);
}
if(value==15){
  Wire.write(accelx3);
}
if(value==16){
  Wire.write(accelx4);
}
if(value==17){
  Wire.write(accely1);
}
if(value==18){
 
  Wire.write(accely2);
}
if(value==19){
  Wire.write(accely3);
}
if(value==20){
  Wire.write(accely4);
}
if(value==21){
  Wire.write(accelz1);
}
if(value==22){
 
  Wire.write(accelz2);
}
if(value==23){
  Wire.write(accelz3);
}
if(value==24){
  Wire.write(accelz4);
}


 
 
  
}
void loop()
{//Serial.println("testing");
 
  
  
  imu.read();

snprintf(report, sizeof(report), "A: %6d %6d %6d    G: %6d %6d %6d",
   imu.a.x, imu.a.y, imu.a.z,
  imu.g.x, imu.g.y, imu.g.z);
  
Serial.println(report);

  delay(100);
  
}
