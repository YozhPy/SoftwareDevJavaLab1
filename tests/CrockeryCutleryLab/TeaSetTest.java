package CrockeryCutleryLab;

import org.junit.Test;
import org.junit.BeforeClass;
import java.time.LocalDate;

import static org.junit.Assert.*;



public class TeaSetTest {

    private static TeaSet set1, setErrors;

    @BeforeClass
    public static void setUpClass() throws Exception{
        setErrors = new TeaSet("Error Test", LocalDate.of(2020, 9, 12),
                1, 2, 3, 4, 5, Material.Porcelain,
                new Customer("Somebody Strange"));
        set1 = new TeaSet("Set1 Test", LocalDate.of(2000, 12, 26),
                0,0,0,0,0, Material.Glass);
    }

    @Test
    public void checkAbstractConstructorWithCustomer(){
        assertEquals(LocalDate.of(2020,9,12), setErrors.getDate());
        assertEquals("Somebody Strange ", setErrors.getCustomer().toString());
        assertEquals(Material.Porcelain, setErrors.getMaterial());
        assertFalse(setErrors.getMaterial().isFragile);
    }

    @Test
    public void checkAbstractConstructorWithoutCustomer(){
        assertEquals(LocalDate.of(2000,12,26), set1.getDate());
        assertEquals("Anonim Anonim ", set1.getCustomer().toString());
        assertEquals(Material.Glass, set1.getMaterial());
        assertTrue(set1.getMaterial().isFragile);
    }

    @Test(expected = AmountItemsException.class)
    public void setkettles_n() throws AmountItemsException {
        setErrors.setkettles_n(-5);
    }

    @Test(expected = AmountItemsException.class)
    public void setcup_n() throws AmountItemsException{
        setErrors.setcup_n(-2);
    }

    @Test(expected = AmountItemsException.class)
    public void setbutter_dish_n() throws AmountItemsException {
        setErrors.setbutter_dish_n(-6);
    }

    @Test(expected = AmountItemsException.class)
    public void setcandyBowl_n() throws AmountItemsException {
        setErrors.setcandyBowl_n(-18);
    }

    @Test(expected = AmountItemsException.class)
    public void setcreamer_n() throws AmountItemsException {
        setErrors.setcreamer_n(-111);
    }

    @Test
    public void find_cost() throws Exception{
        final int cost = setErrors.getkettles_n() * 70 +
                         setErrors.getcup_n() * 20 +
                         setErrors.getbutter_dish_n() * 14 +
                         setErrors.getcandyBowl_n() * 47 +
                         setErrors.getcreamer_n() * 44;
        assertEquals(cost, setErrors.find_cost());
        assertEquals(0, set1.find_cost());
    }

    @Test
    public void checkNativeAbstractClass() throws Exception{
        assertEquals("This is order of: "+setErrors.getCustomer().toString()+
                        ". It must be finished till: "+setErrors.getDate().plusDays(7),
                        setErrors.toString());
    }

}