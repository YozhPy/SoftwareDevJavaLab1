package CrockeryCutleryLab;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class SetsListTest {

    private SetsList setTest;
    private DinnerSet[] arrTest;

    @Before
    public void setUp() throws Exception{
        setTest = new SetsList("Test Set");
        arrTest = new DinnerSet[]{
                new DiningSet("TestElement1", LocalDate.of(2000,1,1),
                        1, 2, 3, 4, 5, Material.Glass, new Customer("Ivan Tester", true)),
                new DiningSet("TestElement2", LocalDate.of(2010,1,1),
                        1, 2, 3, 4, 5, Material.Glass, new Customer("Ivan Tester")),
                new TeaSet("TestElement3", LocalDate.of(2020,1,1),
                        -3, 6, 1, 3, 2, Material.Porcelain,
                                                                            new Customer("Frost Tester"))
        };

        for (DinnerSet element: arrTest){
            setTest.addOrder(element);
        }

    }

    @Test
    public void checkGetOrdersAmount() throws Exception {
        assertEquals(arrTest.length, setTest.getOrdersAmount());
    }

    @Test
    public void CheckClientsNeedsRegistration() throws Exception{
        assertTrue(setTest.clientsNeedsRegistration());
    }

    @Test
    public void CheckAddOrderMethod() throws Exception{
        assertArrayEquals(arrTest,setTest.getOrders().toArray());
    }
}
