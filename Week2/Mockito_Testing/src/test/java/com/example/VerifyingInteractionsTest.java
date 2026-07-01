package com.example;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Exercise 2: Verifying Interactions
 *
 * Sometimes we don't just care about what a method returns —
 * we also want to make sure certain methods were actually called.
 *
 * For example, if our service is supposed to send data to an external API,
 * we want to verify that sendData() was really called (and with the right arguments).
 *
 * Mockito's verify() lets us check:
 *   - Was a method called at all?
 *   - Was it called with specific arguments?
 *   - How many times was it called?
 *   - Was it never called? (useful for error paths)
 */
public class VerifyingInteractionsTest {

    private ExternalApi mockApi;
    private MyService service;

    @Before
    public void setUp() {
        mockApi = Mockito.mock(ExternalApi.class);
        service = new MyService(mockApi);
    }

    @Test
    public void testVerifyGetDataIsCalled() {
        // Stub the method so it doesn't return null
        when(mockApi.getData()).thenReturn("Some Data");

        // Act — call the service method
        service.fetchData();

        // Verify that getData() was actually called on the mock
        // If our service forgot to call the API, this would fail
        verify(mockApi).getData();
        System.out.println("testVerifyGetDataIsCalled passed — getData() was invoked");
    }

    @Test
    public void testVerifyMethodCalledWithSpecificArguments() {
        // When processAndSendData is called, it should convert to uppercase
        // and then call sendData on the API with the uppercase string
        service.processAndSendData("hello world");

        // Verify that sendData was called with "HELLO WORLD" (uppercase)
        // This confirms our service is doing the transformation correctly
        verify(mockApi).sendData("HELLO WORLD");
        System.out.println("testVerifyMethodCalledWithSpecificArguments passed — sendData received uppercase text");
    }

    @Test
    public void testVerifyMethodCalledExactNumberOfTimes() {
        when(mockApi.getDataById(anyInt())).thenReturn("Item");

        // Call fetchDataById three times with different IDs
        service.fetchDataById(1);
        service.fetchDataById(2);
        service.fetchDataById(3);

        // Verify getDataById was called exactly 3 times total
        verify(mockApi, times(3)).getDataById(anyInt());

        // Verify each specific call happened once
        verify(mockApi, times(1)).getDataById(1);
        verify(mockApi, times(1)).getDataById(2);
        verify(mockApi, times(1)).getDataById(3);

        System.out.println("testVerifyMethodCalledExactNumberOfTimes passed — 3 calls verified");
    }

    @Test
    public void testVerifyMethodNeverCalled() {
        // fetchData only calls getData(), it should NOT call sendData()
        when(mockApi.getData()).thenReturn("Test");

        service.fetchData();

        // Confirm getData was called
        verify(mockApi).getData();

        // Confirm sendData was never called — important for making sure
        // our service isn't doing things it shouldn't
        verify(mockApi, never()).sendData(anyString());

        System.out.println("testVerifyMethodNeverCalled passed — sendData was correctly not invoked");
    }

    @Test
    public void testVerifyNoMoreInteractions() {
        when(mockApi.getData()).thenReturn("Data");

        service.fetchData();

        // First verify the expected call
        verify(mockApi).getData();

        // Then confirm nothing else was called on the mock
        // This is strict verification — catches any unexpected calls
        verifyNoMoreInteractions(mockApi);

        System.out.println("testVerifyNoMoreInteractions passed — no unexpected calls on the mock");
    }
}
