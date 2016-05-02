package shoppingitems.hoomi.com.shoppingitems.mvp;

import com.hoomi.lib.shoppingitem.CallbackReceiver;
import com.hoomi.lib.shoppingitem.ShoppingItemService;
import com.hoomi.lib.shoppingitem.domain.model.Product;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.inOrder;

/**
 * Created by hoomanostovari on 02/05/2016.
 */
public class ShoppingItemsPresenterTest {

    @Mock
    private ShoppingItemService mockedShoppingItemService;
    @Mock
    private MView mockedView;
    private List<Product> testProducts = new ArrayList<>(4);

    private ShoppingItemsPresenter shoppingItemsPresenter;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        shoppingItemsPresenter = new ShoppingItemsPresenter(mockedShoppingItemService, mockedView);
    }

    @Test
    public void test_get_data() throws Exception {
        ArgumentCaptor<CallbackReceiver> argumentCaptor = ArgumentCaptor.forClass(CallbackReceiver.class);

        shoppingItemsPresenter.getData();

        InOrder inOrder = inOrder(mockedView, mockedShoppingItemService);
        inOrder.verify(mockedView).showProgress();
        inOrder.verify(mockedShoppingItemService).getItems(argumentCaptor.capture());

        argumentCaptor.getValue().onSuccess(testProducts);

        inOrder.verify(mockedView).hideProgress();
        inOrder.verify(mockedView).showResults(testProducts);

    }

    @Test
    public void test_get_data_error() throws Exception {
        ArgumentCaptor<CallbackReceiver> argumentCaptor = ArgumentCaptor.forClass(CallbackReceiver.class);

        shoppingItemsPresenter.getData();

        InOrder inOrder = inOrder(mockedView, mockedShoppingItemService);
        inOrder.verify(mockedView).showProgress();
        inOrder.verify(mockedShoppingItemService).getItems(argumentCaptor.capture());

        argumentCaptor.getValue().onError();

        inOrder.verify(mockedView).hideProgress();
        inOrder.verify(mockedView).showError();

    }
}