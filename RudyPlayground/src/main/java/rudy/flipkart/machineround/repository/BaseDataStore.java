package rudy.flipkart.machineround.repository;

import rudy.flipkart.machineround.constants.ItemType;
import rudy.flipkart.machineround.model.Item;
import rudy.flipkart.machineround.model.Order;

import java.util.*;

public class BaseDataStore {

    public static Set<ItemType> allowedItem = new HashSet<>(Arrays.asList(ItemType.FOOD,ItemType.CLOTHES,ItemType.MEDICINES));
    public static final ArrayDeque<Order> pendingOrder = new ArrayDeque<>();


    public static boolean validate(Item item){
        if(Objects.isNull(item)) return false;
        return allowedItem.contains(item.getItemType());
    }




}
