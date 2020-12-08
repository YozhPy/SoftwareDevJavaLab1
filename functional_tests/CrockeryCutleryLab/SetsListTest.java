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
    private TeaSet mockDining;
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
    public void findAllPlasticMoney_CheckValidnessWithMockito_Int() throws Exception {
        when(mockDining.getMaterial()).thenReturn(Material.Plastic);
        when(mockDining.find_cost()).thenReturn(15);
        assertEquals(150, setTest.findAllPlasticMoney());
    }

    @Test
    public void findMaxPrice_CheckValidnessWithMockito_Int() throws Exception {
        when(mockDining.find_cost()).thenReturn(150);
        assertEquals(150, setTest.findMaxPrice().get().find_cost());
    }

    @Test
    public void findAveragePrice_CheckValidnessWithMockito_Int() throws Exception {
        when(mockDining.find_cost()).thenReturn(150);
        assertEquals(150, setTest.findAveragePrice(),0);
    }

    @Test
    public void getPlasticOrder_CheckValidnessWithMockito_Int() throws Exception {
        when(mockDining.getMaterial()).thenReturn(Material.Plastic);
        when(mockDining.find_cost()).thenReturn(15);
        assertEquals(1, setTest.getPlasticOrders().size());
    }

    @Test
    public void getMostCommonMaterial_CheckValidnessWithMockito_Material() throws Exception {
        when(mockDining.getMaterial()).thenReturn(Material.Plastic);
        assertEquals(Material.Plastic, setTest.getTheMostCommonTeaSetMaterial());
    }



}