package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

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
        public void whenNotEnoughMoney_returnINSUFFICIENTFUNDS() {
            VendingMachine vendingMachine = new VendingMachine();
            Money money = new Money();

            BigDecimal actual = vendingMachine.getMoney().zeroBalance();

            Assert.assertEquals("Insufficient funds", vendingMachine.purchaseItem("C1").getPrice() , actual);
        }

        @Test
        public void whenNotWholeDollarAmount_returnNOTWHOLEDOLLAR() {

        }

}
