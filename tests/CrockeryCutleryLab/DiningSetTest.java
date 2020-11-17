package CrockeryCutleryLab;

import org.junit.BeforeClass;
import org.junit.Test;
import java.util.LinkedHashMap;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class DiningSetTest {

    private static DiningSet set1, set2;

    @BeforeClass
    public static void setUpClass() throws Exception{
        set1 = new DiningSet("FirstSet", LocalDate.of(2020,1,1),
                            0,0,0,0,0,Material.Metal,
                            new Customer("Dining Customer"));
        set2 = new DiningSet("SecondSet",LocalDate.of(2020,2,4),
                            2,2,2,2,2,Material.Plastic);
    }

    @Test
    public void checkAbstractConstructorWithCustomer() throws Exception{
        assertEquals(LocalDate.of(2020,1,1), set1.getDate());
        assertEquals("Dining Customer ", set1.getCustomer().toString());
        assertEquals(Material.Metal, set1.getMaterial());
        assertFalse(set1.getMaterial().isFragile);
    }

    @Test
    public void checkAbstractConstructorWithoutCustomer() throws Exception{
        assertEquals(LocalDate.of(2020,2,4), set2.getDate());
        assertEquals("Anonim Anonim ", set2.getCustomer().toString());
        assertEquals(Material.Plastic, set2.getMaterial());
        assertFalse(set2.getMaterial().isFragile);
    }
    @Test
    public void find_cost() throws Exception{
        final int cost = (30+36+47+14+44)*2;
        assertEquals(cost, set2.find_cost());
        assertEquals(0, set1.find_cost());
    }

}