package CrockeryCutleryLab;

import org.junit.Test;
import org.junit.Before;
import java.time.LocalDate;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;



public class TeaSetTest {

    private static TeaSet setErrors;

    @Mock
    private Customer customer;

    @Before
    public void set() throws Exception{
        MockitoAnnotations.initMocks(this);
        when(customer.toString()).thenReturn("Mockito Customer");
        setErrors = new TeaSet("Error Test", LocalDate.of(2020, 9, 12),
                1, 2, 3, 4, 5, Material.Porcelain,
                customer);

    }

    @Test
    public void constructorWithCustomer_CheckAbstractConstructorValidnessWithMockito(){
        assertEquals(LocalDate.of(2020,9,12), setErrors.getDate());
        assertEquals("Mockito Customer", setErrors.getCustomer().toString());
        assertEquals(Material.Porcelain, setErrors.getMaterial());
        assertFalse(setErrors.getMaterial().isFragile);
    }

    @Test(expected = AmountItemsException.class)
    public void When_KettlesNumberLessThanZero_Expect_AmountItemsExceptions() throws AmountItemsException {
        setErrors.setkettles_n(-5);
    }

    @Test(expected = AmountItemsException.class)
    public void When_CupsNumberLessThanZero_Expect_AmountItemsExceptions() throws AmountItemsException{
        setErrors.setcup_n(-2);
    }

    @Test(expected = AmountItemsException.class)
    public void When_ButterDishesNumberLessThanZero_Expect_AmountItemsExceptions() throws AmountItemsException {
        setErrors.setbutter_dish_n(-6);
    }

    @Test(expected = AmountItemsException.class)
    public void When_CandyBowlsNumberLessThanZero_Expect_AmountItemsExceptions() throws AmountItemsException {
        setErrors.setcandyBowl_n(-18);
    }

    @Test(expected = AmountItemsException.class)
    public void When_CreamersNumberLessThanZero_Expect_AmountItemsExceptions() throws AmountItemsException {
        setErrors.setcreamer_n(-111);
    }

    @Test
    public void FindCost_CheckValidness_Int() throws Exception{
        final int cost = setErrors.getkettles_n() * 70 +
                         setErrors.getcup_n() * 20 +
                         setErrors.getbutter_dish_n() * 14 +
                         setErrors.getcandyBowl_n() * 47 +
                         setErrors.getcreamer_n() * 44;
        assertEquals(cost, setErrors.find_cost());
    }

    @Test
    public void ToString_checkNativeClassValidness_String() throws Exception{
        assertEquals("This is order of: Mockito Customer"+
                        ". It must be finished till: "+setErrors.getDate().plusDays(7),
                        setErrors.toString());
    }

}