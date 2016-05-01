package com.hoomi.lib.shoppingitem;

import com.hoomi.lib.shoppingitem.domain.model.Product;

import java.util.ArrayList;
import java.util.List;

public final class ShoppingItemService {

    private static ShoppingItemService instance;

    private ShoppingItemService() {
    }

    public static ShoppingItemService getInstance() throws InterruptedException {
        if (instance == null) {
            synchronized (ShoppingItemService.class) {
                if (instance == null) {
                    instance = new ShoppingItemService();
                }
            }
        }
        return instance;
    }


    public List<Product> getItems(CallbackReceiver callbackReceiver) {
        return new ArrayList<>();
    }
}
