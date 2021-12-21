package es.ulpgc.dis.CoffeeMachine;

public class CoffeeMachine {

    private Tank tank1 = new Tank("waterTank",200);
    private Tank tank2 = new Tank("coffeeTank",200);
    private Tank tank3 = new Tank("sugarTank",500);
    private Tank tank4 = new Tank("milkTank",10);

    private Coil coil = new Coil();

    private MixingTank mixingTank1 = new MixingTank("coolTank",0);
    private MixingTank mixingTank2 = new MixingTank("heatTank",0);

    private ArrayValve arrayValve = new ArrayValve();

    private SugarSelector sugarSelector = new SugarSelector();

    public Tank getTank1(){
        return tank1;
    }
    public Tank getTank2(){
        return tank2;
    }
    public Tank getTank3(){
        return tank3;
    }
    public Tank getTank4(){
        return tank4;
    }

    public SugarSelector getSugarSelector(){
        return sugarSelector;
    }

    public void prepareProduct(Product product){
        if(product == Product.COFFEE_EXPRESS){
            prepareProductCoffeeExpress();
        }
    }

    private void prepareProductCoffeeExpress(){
        int levelWaterTank = tank1.getLevelTankStub() ;
        int levelCoffeeTank = tank2.getLevelTankStub() ;
        int levelSugarTank = tank3.getLevelTankStub();

        int levelSugarSelected = sugarSelector.getLevelSugarSelected();

        if(levelWaterTank >= 1 && levelCoffeeTank >= 1 && levelSugarTank >= levelSugarSelected){

        }

        mixingTank2.ejectContent();


    }
}
