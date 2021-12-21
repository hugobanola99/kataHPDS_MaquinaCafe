package es.ulpgc.dis.CoffeeMachine;

public class Tank {

    private final String name;
    private int numberUnitsBaseProduct;
    private Sensor sensorLevelProduct;

    public Tank(String name, int numberUnitsBaseProduct) {
        this.name = name;
        this.numberUnitsBaseProduct = numberUnitsBaseProduct;
    }

    public void removeBaseProduct(int numberUnits){

        this.numberUnitsBaseProduct -= numberUnits;
    }

    public void addBaseProduct(int numberUnits){

        this.numberUnitsBaseProduct += numberUnits;
    }

    //Stub del Sensor del Tank
    public int getLevelTankStub(){
        return this.numberUnitsBaseProduct;
    }

    //Mock del Sensor del Tank
    public int getLevelTankMock(){return sensorLevelProduct.getValue();}
}
