
package WaterTankGUI;

public class StartMain {
    public static void main(String[] args) {
        WaterLevelObservable waterLevelObservable = new WaterLevelObservable();
        waterLevelObservable.addWaterLevelObserver(new Alarm());
        waterLevelObservable.addWaterLevelObserver(new Sms());
        waterLevelObservable.addWaterLevelObserver(new Display());
        new WaterTank(waterLevelObservable).setLocationRelativeTo(null);
        new WaterTank(waterLevelObservable).setVisible(true);
    }
}
