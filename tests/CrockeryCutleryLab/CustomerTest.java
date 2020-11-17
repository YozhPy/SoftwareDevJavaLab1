package CrockeryCutleryLab;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private static Customer person1,person2,person3,person4;

    @BeforeClass
    public static void setUpClass() throws Exception{
        person1 = new Customer("First", "Test");
        person2 = new Customer("Second", "Test", true);
        person3 = new Customer("Third Test Constructor");
        person4 = new Customer("Last Test Of Constructors", true);
    }

    @Test
    public void checkCustomerConstructorNameSurname() throws Exception{
        assertEquals("First", person1.getName());
        assertEquals("Test", person1.getSurname());
    }

    @Test
    public void checkCustomerConstructorNameSurnameNew() throws Exception{
        assertEquals("Second", person2.getName());
        assertEquals("Test", person2.getSurname());
        assertTrue(person2.getNew());
    }

    @Test
    public void checkCustomerConstructorFull(){
        assertEquals("Third", person3.getName());
        assertEquals("Test Constructor", person3.getSurname());
    }

    @Test
    public void checkCustomerConstructorFullNew() throws Exception{
        assertEquals("Last", person4.getName());
        assertEquals("Test Of Constructors", person4.getSurname());
        assertTrue(person4.getNew());
    }

    @Test
    public void getFullNameAndToString() throws Exception{
        assertEquals("First Test ", person1.toString());
        assertEquals("Second Test ", person2.toString());
        assertEquals("Third Test Constructor ", person3.toString());
        assertEquals("Last Test Of Constructors ", person4.toString());
    }

    @Test
    public void testHashCode() {
        final int prime = 31;
        assertEquals(prime * ( prime +person1.getName().length()) + person1.getSurname().length(), person1.hashCode());
        assertEquals(prime * ( prime +person2.getName().length()) + person2.getSurname().length(), person2.hashCode());
        assertEquals(prime * ( prime +person3.getName().length()) + person3.getSurname().length(), person3.hashCode());
        assertEquals(prime * ( prime +person4.getName().length()) + person4.getSurname().length(), person4.hashCode());
    }
}