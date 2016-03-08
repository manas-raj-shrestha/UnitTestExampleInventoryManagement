package com.leapfrog.inventorymanagementsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Manas on 3/8/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTests {

    List mocks = mock(List.class);

    //Stubbing with callbacks
    @Test
    public void stubWithCallbacks() {
        when(mocks.get(anyInt())).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] object = invocation.getArguments();
                return "called with args :: " + object[0];
            }
        });

        System.out.print(mocks.get(23));
    }

    //Verification in order
    @Test
    public void verificationOrder() {
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //using mocks
        firstMock.add("was called first");
        secondMock.add("was called second");

        //create inOrder object passing any mocks that need to be verified in order
        //this is just inOrder object creation, its not representing the sequence of method calls
        InOrder inOrder = inOrder(secondMock, firstMock);

        //following will make sure that firstMock was called before secondMock
        inOrder.verify(firstMock).add("was called first");
        inOrder.verify(secondMock).add("was called second");
    }


    //Argument Matcher
    @Test
    public void argumentMatcher() {
        when(mocks.get(anyInt())).thenReturn("element");
        System.out.println(mocks.get(0));

        //arguments passed to verify must be a mock object
        verify(mocks).get(0);
        verify(mocks).get(anyInt());

        //i'm using assertEquals of junit framework.
        assertEquals(mocks.get(anyInt()), "element");
    }

    //Stubbing void methods with exceptions
    @Test
    public void verifyWithExceptions() {

        doThrow(ItemNotInStockException.class).when(mocks).clear();
    }

    @Test
    public void addToList() throws Exception {
        mocks.add("something");
        mocks.clear();

        /*Once created, mock will remember all interactions.
        Then you can selectively verify whatever interaction you are interested in.
        Here, the list has already been cleared but the transaction sequence is remembered */

        verify(mocks).add("something");
        verify(mocks).clear();
    }

    //consecutive calls
    @Test
    public void consecutiveCalls() {
        when(mocks.get(0))
//                .thenThrow(new ItemNotInStockException())
                .thenReturn("foo");

        //First call: throws runtime exception:
        mocks.get(0);

        //Second call: prints "foo"
        System.out.println(mocks.get(0));

        //Any consecutive call: prints "foo" as well (last stubbing wins).
        System.out.println(mocks.get(0));

        // Alternative, shorter version of consecutive stubbing:
        when(mocks.get(0))
                .thenReturn("one", "two", "three");
    }

    @Spy
    List list = new LinkedList();

    //Spying on real objects
    @Test
    public void spy() {


        //optionally, you can stub out some methods:
        when(list.size()).thenReturn(100);

        //using the spy calls real methods
        list.add("one");
        list.add("two");

        //prints "one" - the first element of a list
        System.out.println(list.get(0));

        //size() method was stubbed - 100 is printed
        System.out.println(list.size());

        //optionally, you can verify
        verify(list).add("one");
        verify(list).add("two");

        /*
        when(...) thenReturn(...) makes a real method call just before it is mocked.
        So if the called method throws an Exception you have to deal with it / mock it etc.
        Of course you still get your result (what you define in thenReturn(...) )

        doReturn(...) when(...) does not call the method at all.

        Its better to always use doReturn because most of the time the mocks real implementation is
        not required.
         */
    }
}
