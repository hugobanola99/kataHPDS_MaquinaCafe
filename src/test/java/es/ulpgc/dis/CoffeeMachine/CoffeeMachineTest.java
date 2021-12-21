package es.ulpgc.dis.CoffeeMachine;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CoffeeMachineTest {
    CoffeeMachine coffeeMachine;

    @Before
    public void init(){
        coffeeMachine = new CoffeeMachine();
    }

    @Test
    public void testPrepareProductCoffeeExpressStub(){

        int levelWaterBefore = coffeeMachine.getTank1().getLevelTankStub();
        int levelCoffeeBefore = coffeeMachine.getTank2().getLevelTankStub();
        int levelSugarBefore = coffeeMachine.getTank3().getLevelTankStub();
        int levelSugarSelected = coffeeMachine.getSugarSelector().getLevelSugarSelected();

        //
        coffeeMachine.prepareProduct(Product.COFFEE_EXPRESS);

        //

        int levelWaterAfter = coffeeMachine.getTank1().getLevelTankStub();
        int levelCoffeeAfter = coffeeMachine.getTank2().getLevelTankStub();
        int levelSugarAfter = coffeeMachine.getTank3().getLevelTankStub();

        assert(levelWaterBefore-levelWaterAfter == 1);
        assert(levelCoffeeBefore-levelCoffeeAfter == 1);
        assert(levelSugarBefore - levelSugarAfter == levelSugarSelected);
    }

    @Test
    public void testPrepareProductCoffeeExpressMock(){

        Sensor sensorLevelWaterMock = mock(SensorLevelTank.class);
        //doReturn(100).when(sensorLevelWaterMock).getValue();
        when(sensorLevelWaterMock.getValue()).thenReturn(100);
        Sensor sensorLevelCoffeeMock = mock(SensorLevelTank.class);
        //doReturn(100).when(sensorLevelCoffeeMock).getValue();
        when(sensorLevelCoffeeMock.getValue()).thenReturn(100);
        Sensor sensorLevelSugarMock = mock(SensorLevelTank.class);
        //doReturn(100).when(sensorLevelSugarMock).getValue();
        when(sensorLevelSugarMock.getValue()).thenReturn(100);



        int levelWaterBefore = sensorLevelWaterMock.getValue();
        int levelCoffeeBefore = sensorLevelCoffeeMock.getValue();
        int levelSugarBefore = sensorLevelSugarMock.getValue();


        int levelSugarSelected = coffeeMachine.getSugarSelector().getLevelSugarSelected();

        //
        coffeeMachine.prepareProduct(Product.COFFEE_EXPRESS);
        //

       // doReturn(99).when(sensorLevelWaterMock.getValue());
        when(sensorLevelWaterMock.getValue()).thenReturn(99);
        //doReturn(99).when(sensorLevelCoffeeMock.getValue());
        when(sensorLevelCoffeeMock.getValue()).thenReturn(99);
        //doReturn(99).when(sensorLevelSugarMock.getValue());
        when(sensorLevelSugarMock.getValue()).thenReturn(99);



        int levelWaterAfter = sensorLevelWaterMock.getValue();
        int levelCoffeeAfter = sensorLevelCoffeeMock.getValue();
        int levelSugarAfter = sensorLevelSugarMock.getValue();

        assert(levelWaterBefore-levelWaterAfter == 1);
        assert(levelCoffeeBefore-levelCoffeeAfter == 1);
        //assert(levelSugarBefore - levelSugarAfter == levelSugarSelected);

        verify(sensorLevelWaterMock, times(2)).getValue();
        verify(sensorLevelCoffeeMock, times(2)).getValue();
        verify(sensorLevelSugarMock, times(2)).getValue();


    }
}
