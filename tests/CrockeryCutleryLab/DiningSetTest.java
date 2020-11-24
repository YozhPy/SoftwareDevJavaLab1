package CrockeryCutleryLab;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedHashMap;
import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
public class DiningSetTest {

    private static DiningSet set1, set2;

    @Mock
    private Customer customer;

    @Before
    public void set() throws Exception{
        MockitoAnnotations.initMocks(this);
        when(customer.toString()).thenReturn("Mockito Customer");
        set1 = new DiningSet("FirstSet", LocalDate.of(2020,1,1),
                            0,0,0,0,0,Material.Metal,
                            customer);
        set2 = new DiningSet("SecondSet",LocalDate.of(2020,2,4),
                            2,2,2,2,2,Material.Plastic);
    }

    @Test
    public void constructorWithCustomer_CheckAbstractConstructorValidnessWithMockito() throws Exception{
        assertEquals(LocalDate.of(2020,1,1), set1.getDate());
        assertEquals("Mockito Customer", set1.getCustomer().toString());
        assertEquals(Material.Metal, set1.getMaterial());
        assertFalse(set1.getMaterial().isFragile);
    }

    @Test
    public void constructorWithoutCustomer_CheckAbstractConstructorValidness() throws Exception{
        assertEquals(LocalDate.of(2020,2,4), set2.getDate());
        assertEquals("Anonim Anonim ", set2.getCustomer().toString());
        assertEquals(Material.Plastic, set2.getMaterial());
        assertFalse(set2.getMaterial().isFragile);
    }

    @Test
    public void findCost_CheckValidness_Int() throws Exception{
        assertEquals(342, set2.find_cost());
        assertEquals(0, set1.find_cost());
    }

}