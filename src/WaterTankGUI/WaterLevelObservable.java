
package WaterTankGUI;

import java.util.ArrayList;

public class WaterLevelObservable { //Controlling Room
    private ArrayList<WaterLevelObservel>observableList = new ArrayList<>();
    private int waterLevel;
    public void addWaterLevelObserver(WaterLevelObservel waterLevelObservel){
        observableList.add(waterLevelObservel);
    }
    public void removeWaterLevelObserver(WaterLevelObservel waterLevelObservel){
        observableList.remove(waterLevelObservel);
    }
    public void notifiWaterlevel(){
        for (WaterLevelObservel waterLevelObservel : observableList) {
            waterLevelObservel.update(waterLevel);
        }
    }
    public void setWaterLevel(int waterLevel){
        if (this.waterLevel != waterLevel) {
            this.waterLevel = waterLevel;
            notifiWaterlevel(); 
        }
    }
}
