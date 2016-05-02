package com.hoomi.lib.shoppingitem.domain;

import com.hoomi.lib.shoppingitem.CallbackReceiver;
import com.hoomi.lib.shoppingitem.domain.model.Product;
import com.hoomi.lib.shoppingitem.network.NetworkService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.*;

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
        sainsburysRepository = new SainsburysRepository();

    }

    @Test
    public void test_get_shopping_items() throws Exception {


        sainsburysRepository.getShoppingItems(mockedCallbackReceiver);


    }
}