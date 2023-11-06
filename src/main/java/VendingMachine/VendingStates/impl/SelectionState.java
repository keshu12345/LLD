package VendingMachine.VendingStates.impl;

import VendingMachine.VendingMachine;
import VendingMachine.VendingStates.State;
import VendingMachine.Coin;
import VendingMachine.Item;

import java.util.List;

public class SelectionState implements State {
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("you can not click on insert coin button in Selection state");

    }

    public int getChange(int returnExtraMoney) throws Exception {
        //actual logic should be to return COINs in the dispense tray, but for simplicity i am just returning the amount to be refunded
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnExtraMoney);
        return returnExtraMoney;
    }

    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory can not be updated in Selection state");
    }

    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getCoinList();

    }

    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("product can not be dispensed Selection state");
    }

    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        Item item=vendingMachine.getInventory().getItem(codeNumber);
        int paidByUser = 0;
        for(Coin coin:vendingMachine.getCoinList()){
            paidByUser+=coin.value;
        }
        if(paidByUser<item.getPrice()){
            System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + paidByUser);
            refundFullMoney(vendingMachine);
            throw new Exception("insufficient amount");
        }else if(paidByUser>=item.getPrice()){
            if(paidByUser>item.getPrice()){
                getChange(paidByUser-item.getPrice());
            }
            vendingMachine.setVendingMachineState(new DispenseState(vendingMachine,codeNumber));
        }

    }

    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("you can not insert Coin in selection state");

    }

    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        return;
    }
}
