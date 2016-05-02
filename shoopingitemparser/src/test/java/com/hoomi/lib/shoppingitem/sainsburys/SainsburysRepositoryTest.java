package com.hoomi.lib.shoppingitem.sainsburys;

import com.hoomi.lib.shoppingitem.CallbackReceiver;
import com.hoomi.lib.shoppingitem.network.NetworkService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by hoomanostovari on 02/05/2016.
 */
public class SainsburysRepositoryTest {

    @Mock
    private CallbackReceiver mockedCallbackReceiver;
    @Mock
    private NetworkService mockedNetworkService;

    private SainsburysRepository sainsburysRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        sainsburysRepository = new SainsburysRepository(mockedNetworkService);

    }

    @Test
    public void test_get_shopping_items() throws Exception {


        sainsburysRepository.getShoppingItems(mockedCallbackReceiver);

        verify(mockedNetworkService).getProducts(mockedCallbackReceiver);


    }
}