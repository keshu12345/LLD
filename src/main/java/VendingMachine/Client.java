package VendingMachine;

import VendingMachine.VendingStates.State;

public class Client {

    public static void main(String []args) {
        VendingMachine vendingMachine = new VendingMachine();
        try {
            System.out.println("|");
            System.out.println("filling up inventory");
            System.out.println("|");
            fillingUpInventory(vendingMachine);
            displayInventory(vendingMachine);
            System.out.println("|");
            System.out.println("clicking on InsertCoinButton");
            System.out.println("|");
            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);
            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);
            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");
            vendingState.clickOnStartProductSelectionButton(vendingMachine);
            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 102);
            displayInventory(vendingMachine);
        }catch (Exception e){
            displayInventory(vendingMachine);
        }

    }

    private static void displayInventory(VendingMachine vendingMachine) {
        ItemShelf []itemShelfs=vendingMachine.getInventory().getItemShelves();
        for (ItemShelf itemShelf : itemShelfs) {
            System.out.println("CodeNumber: " + itemShelf.getCode() +
                    " Item: " + itemShelf.getItem().getType().name() +
                    " Price: " + itemShelf.getItem().getPrice() +
                    " isAvailable: " + !itemShelf.getSoldOut());
        }

    }

    private static void fillingUpInventory(VendingMachine vendingMachine) {
        ItemShelf[] itemShelves=vendingMachine.getInventory().getItemShelves();
        for(int i=0;i<itemShelves.length;i++){
            Item item=new Item();
            if(i>=0&&i<3){
                item.setType(ItemType.COKE);
                item.setPrice(12);
            }else if(i>=3&&i<5){
                item.setType(ItemType.PEPSI);
                item.setPrice(9);
            }else if(i>=5&&i<7){
                item.setType(ItemType.JUICE);
                item.setPrice(9);
            }else if(i>=7&&i<10){
                item.setType(ItemType.SODA);
                item.setPrice(7);
            }
            itemShelves[i].setItem(item);
            itemShelves[i].setSoldOut(false);
        }
    }
}
