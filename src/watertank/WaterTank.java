
package watertank;

import java.util.Random;

class WaterLevelObserver{
    public void update(int waterLevel){
        //
    }
}
class Alarm extends WaterLevelObserver{
    @Override
    public void update(int waterLevel){
        if (waterLevel>=50) {
            System.out.println("Alram On");
        }else  {
            System.out.println("Alarm Of");
        }
    }
}
class Diplay extends WaterLevelObserver{
     @Override
     public void update(int waterLevel){
         System.out.println("Water Level is -"+waterLevel);
    }
}
class SMSSender extends  WaterLevelObserver{
     @Override
     public void update(int waterLevel){
         System.out.println("Water Level sending -"+waterLevel);
    }
}
class ControllRoom{
    int nextIndex;
   private int waterLevel;
    WaterLevelObserver[] waterLevelObserversArray = new WaterLevelObserver[100];
    
    ControllRoom(){
        nextIndex = 0;
    }
    public void addWaterLevel(WaterLevelObserver levelObserver){
        waterLevelObserversArray[nextIndex++]=levelObserver;
        
    }
    public void setWaterLevel(int waterLevel ){
        if (this.waterLevel!= waterLevel) {
            this.waterLevel = waterLevel;
            notifyObserve();
        }
    }
    public void notifyObserve(){
        for (int i = 0; i < nextIndex; i++) {
            WaterLevelObserver ob = waterLevelObserversArray[i];
            ob.update(waterLevel);
        }
    }
}
public class WaterTank {
    public static void main(String[] args) {
       ControllRoom controllRoom = new ControllRoom();
       controllRoom.addWaterLevel(new Alarm());
       controllRoom.addWaterLevel(new SMSSender());
       controllRoom.addWaterLevel(new Diplay());
  
       
        Random r  = new Random();
        int count = 0;
        while(count<=50){
            int WaterLevel = r.nextInt(100);
            controllRoom.setWaterLevel(WaterLevel);
            count++;
        }
    }

   
    
}
