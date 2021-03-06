package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Formatter;

public class VendingMachineTests {

    @Test
    public void whenWrongSlotLocationSelected_returnIVALIDINPUT() {
        //arrange
        VendingMachine vendingMachine = new VendingMachine();

        //act
        Item actual = vendingMachine.purchaseItem("D5");

        //assert
        Assert.assertEquals("Invalid input", vendingMachine.purchaseItem("D3"), actual);

    }

    @Test
    public void returnsRightSlotLocationSelected_returnVALIDINPUT() {
        //arrange
        VendingMachine vendingMachine = new VendingMachine();

        //act
        Item actual = vendingMachine.purchaseItem("A1");

        //
        Assert.assertEquals(vendingMachine.purchaseItem("A1"), actual);
    }

    @Test

    public void whenNotWholeDollarAmount_returnNOTWHOLEDOLLAR() {
        //arrange

        //act

        //assert

    }
}

