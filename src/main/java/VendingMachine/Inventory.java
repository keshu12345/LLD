package VendingMachine;

public class Inventory {
    ItemShelf []itemShelves=null;
    Inventory(int itemCount){
        itemShelves=new ItemShelf[itemCount];
        initialEmptyInventory();
    }

    public ItemShelf[]getItemShelves(){
        return itemShelves;
    }
    public void setItemShelves(ItemShelf[]itemShelves){
        this.itemShelves=itemShelves;
    }

    public void initialEmptyInventory() {
        int startCode=101;
        for(int i=0;i<itemShelves.length;i++){
            ItemShelf itemShelf=new ItemShelf();
            itemShelf.setCode(startCode);
            itemShelf.setSoldOut(true);
            itemShelves[i]=itemShelf;
            startCode++;
        }
    }

    public void addItem(Item item,int codeNumber) throws Exception {

        for(ItemShelf itemShelf:itemShelves){
            if(itemShelf.code==codeNumber){
                if(itemShelf.getSoldOut()){
                    itemShelf.item=item;
                    itemShelf.setSoldOut(false);
                }else{
                    throw new Exception("already item is present ,you can add item here");
                }

            }
        }
    }

    public Item getItem(int codeNumber)throws Exception{

        for(ItemShelf itemShelf:itemShelves){
            if(itemShelf.code==codeNumber){
                if(itemShelf.getSoldOut()){
                    throw new Exception("Item already sold out");
                }else{
                    return itemShelf.item;
                }
            }
        }
        throw new Exception("invalid codeNumber");
    }
    public void updateSoldOutItem(int codeNumber){
        for (ItemShelf itemShelf : itemShelves) {
            if (itemShelf.code == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }


}
