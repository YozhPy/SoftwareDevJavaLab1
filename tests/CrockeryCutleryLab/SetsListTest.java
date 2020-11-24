package CrockeryCutleryLab;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.time.LocalDate;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import static org.mockito.Mockito.when;

public class SetsListTest {

    private SetsList setTest;
    @Mock
    private ArrayList<DinnerSet> mockDinner;
    @Mock
    private DiningSet mockDining;
    @Mock
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(customer.getNew()).thenReturn(true);
        setTest = new SetsList("Mockito Set");
        for (int i = 0; i < 10; i++) {
            setTest.addOrder(mockDining);
        }
    }


    @Test
    public void GetOrdersAmount_CheckValidnessWithMockito_Int() throws Exception {
        when(mockDinner.size()).thenReturn(10);
        assertEquals(mockDinner.size(), setTest.getOrdersAmount());
    }

    @Test
    public void ClientsNeedsRegistration_CheckValidnessWithMockito_True() throws Exception {
        when(mockDining.getCustomer()).thenReturn(customer);
        assertTrue(setTest.clientsNeedsRegistration());
    }

}