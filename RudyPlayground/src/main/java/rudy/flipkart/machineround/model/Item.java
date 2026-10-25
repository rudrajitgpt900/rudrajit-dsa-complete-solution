package rudy.flipkart.machineround.model;

import rudy.flipkart.machineround.constants.ItemType;

public class Item {
    private long itemId;
    private String itemName;
    private ItemType itemType;

    public Item(long itemId, String itemName, ItemType itemType) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemType = itemType;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemType=" + itemType +
                '}';
    }
}
