package com.leapfrog.inventorymanagementsystem;

import com.leapfrog.inventorymanagementsystem.presenters.ItemDetailPresenter;
import com.leapfrog.inventorymanagementsystem.contracts.ItemDetailContract;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Manas on 3/8/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {




    @Mock
    ItemDetailContract itemDetailContract;

    ItemDetailPresenter itemDetailPresenter;

    @Before
    public void setMainActivityView() {
        mainActivityPresenter = new ItemDetailPresenter(mainActivityView);
    }

    @Test
    public void testPurchaseSuccess() throws Exception {
        when(mainActivityView.getItemCode()).thenReturn("MB13");
        when(mainActivityView.getQuantity()).thenReturn(50);

        mainActivityPresenter.buyItems();

        verify(mainActivityView, times(1)).purchaseSuccessful();
    }

    @Test
    public void testPurchaseFailure() throws Exception {
        when(mainActivityView.getItemCode()).thenReturn("MB13");
        when(mainActivityView.getQuantity()).thenReturn(300);

        mainActivityPresenter.buyItems();

        verify(mainActivityView, times(1)).purchaseFailure();
    }


}
