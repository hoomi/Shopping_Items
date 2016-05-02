package shoppingitems.hoomi.com.shoppingitems.mvp;

import com.hoomi.lib.shoppingitem.CallbackReceiver;
import com.hoomi.lib.shoppingitem.ShoppingItemService;
import com.hoomi.lib.shoppingitem.domain.model.Product;

import java.util.List;

/**
 * Created by hoomanostovari on 02/05/2016.
 */
public class ShoppingItemsPresenter implements MPresenter, CallbackReceiver {


    private final ShoppingItemService shoppingItemService;
    private final MView mvpView;

    public ShoppingItemsPresenter(ShoppingItemService shoppingItemService, MView mockedView) {

        this.shoppingItemService = shoppingItemService;
        this.mvpView = mockedView;
    }

    @Override
    public void getData() {
        mvpView.showProgress();
        shoppingItemService.getItems(this);
    }

    @Override
    public void onSuccess(List<Product> productList) {
        mvpView.hideProgress();
        mvpView.showResults(productList);
    }

    @Override
    public void onError() {
        mvpView.hideProgress();
        mvpView.showError();
    }
}
