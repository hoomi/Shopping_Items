package com.hoomi.lib.shoppingitem.domain.model;

/**
 * Created by hoomanostovari on 01/05/2016.
 */
public class ProductImp implements Product {

    private final String title;
    private final String imageRef;
    private final String unitPrice;

    public ProductImp(String title, String imageRef, String unitPrice) {
        this.title = title;
        this.imageRef = imageRef;
        this.unitPrice = unitPrice;
    }

    @Override
    public String getImageRef() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getUnitPrice() {
        return null;
    }
}
