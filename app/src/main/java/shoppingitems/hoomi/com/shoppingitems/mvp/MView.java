package shoppingitems.hoomi.com.shoppingitems.mvp;

import com.hoomi.lib.shoppingitem.domain.model.Product;

import java.util.List;

/**
 * Created by hoomanostovari on 02/05/2016.
 */
public interface MView<T> {
    void showProgress();

    void hideProgress();

    void showResults(T products);

    void showError();
}
