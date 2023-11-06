package VendingMachine;

import VendingMachine.VendingStates.State;
import VendingMachine.VendingStates.impl.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private State vendingMachineState;
    private List<Coin>coinList;
    private Inventory inventory;

    public VendingMachine(){
        vendingMachineState=new IdleState();
        inventory=new Inventory(10);
        coinList=new ArrayList<>();
    }

    public State getVendingMachineState(){
        return vendingMachineState;
    }
    public void setVendingMachineState(State vendingMachineState){
        this.vendingMachineState=vendingMachineState;
    }
    public List<Coin>getCoinList(){
        return coinList;
    }
    public void setCoinList(List<Coin>coinList){
        this.coinList=coinList;
    }
    public Inventory getInventory(){
        return inventory;
    }
    public void setInventory(Inventory inventory){
        this.inventory=inventory;
    }

}
