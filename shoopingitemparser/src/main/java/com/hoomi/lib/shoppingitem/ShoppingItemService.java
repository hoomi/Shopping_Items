package com.hoomi.lib.shoppingitem;


import com.hoomi.lib.shoppingitem.domain.ProductRepository;
import com.hoomi.lib.shoppingitem.sainsburys.SainsburysRepository;

public class ShoppingItemService {

    private static ShoppingItemService instance;

    //The repository should be injected as so we can use this module for other websites as well
    private ProductRepository productRepository;


    private ShoppingItemService() {
        this(new SainsburysRepository());
    }

    ShoppingItemService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * In order to get the instance of the api
     * @return
     */
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


    /**
     * Call this method if you need to get the list of items
     * @param callbackReceiver It is the callback that notifies the caller of success or error
     */
    public void getItems(CallbackReceiver callbackReceiver) {
        productRepository.getShoppingItems(callbackReceiver);
    }
}
