package com.hoomi.lib.shoppingitem;

import com.hoomi.lib.shoppingitem.domain.ProductRepository;
import com.hoomi.lib.shoppingitem.domain.SainsburysRepository;
import com.hoomi.lib.shoppingitem.domain.model.Product;

import java.util.List;

public class ShoppingItemService {

    private static ShoppingItemService instance;
    private ProductRepository productRepository;

    private ShoppingItemService() {
        this(new SainsburysRepository());
    }

    ShoppingItemService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static ShoppingItemService getInstance() {
        if (instance == null) {
            synchronized (ShoppingItemService.class) {
                if (instance == null) {
                    instance = new ShoppingItemService();
                }
            }
        }
        return instance;
    }


    public void getItems(CallbackReceiver callbackReceiver) {
        productRepository.getShoppingItems(callbackReceiver);
    }
}
