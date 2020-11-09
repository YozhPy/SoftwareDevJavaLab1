package CrockeryCutleryLab;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.Iterator;
public class Main {

    public static void main(String[] args){
        SetsList first = fillSetList();
        orderConfirmation(first);
        SetsList second = fillSetList();

       // SetsList second = fillSetListSecond();
        //orderConfirmation(second);
       // smallReviewsOfAllOrders(second);
    }



    public static SetsList fillSetList(){
        SetsList firstList = new SetsList("This is favourite client! Yohouu");
        Customer bestCustomer = new Customer("Yegor", "Nikishenko", true);
        Customer customer = new Customer("Yegor", "Nikishenko", true);
        if(bestCustomer.equals(customer)){
            System.out.println("Equals is working");
        }
        if(customer.hashCode() == bestCustomer.hashCode()){
            System.out.println("Hello, you are our BEST CUSTOMER! WE LOVE YOU");
        }
        firstList.addOrder(new DiningSet("Medium DiningSet", LocalDate.now(),
                            1, 2, 3, 4, 5, Material.Glass, customer));
        firstList.addOrder(new DiningSet("Small DiningSet", LocalDate.now(),
                0, 1, 2, 3, 4, Material.Glass, customer));
        firstList.addOrder(new TeaSet("Small TeaSet", LocalDate.now(),
               -3, 6, 1, 3, 2, Material.Porcelain, customer));
        return firstList;
    }

    public static SetsList fillSetListSecond(){
        SetsList firstList = new SetsList("This is favourite client! Yohouu");
        firstList.addOrder(new DiningSet("Medium DiningSet", LocalDate.now(),
                1, 2, 3, 4, 5, Material.Glass));
        firstList.addOrder(new DiningSet("Small DiningSet", LocalDate.now(),
                0, 1, 2, 3, 4, Material.Glass));
        firstList.addOrder(new TeaSet("Small TeaSet", LocalDate.now(),
                1, 6, 1, 3, 2, Material.Porcelain));
        Boolean needsRegistration = firstList.clientsNeedsRegistration();
        if (needsRegistration){
            System.out.println("ATTENTION! YOU ARE NOT REGISTERED. CALL OUR MANAGER PLEASE");
        }
        return firstList;
    }

    public static void orderConfirmation(SetsList setslist) {
        System.out.println(setslist.getOrders().get(0).customer.toString() + ", we are happy to make so wonderful Set, but let's confirm this order!");
        System.out.println("You have already ordered " + setslist.getOrdersAmount() + " crockery and cutlery sets");
        System.out.println("So, in your sets:");
        Iterator iterator = setslist.getOrders().iterator();
        while (iterator.hasNext()) {
            System.out.println("*********************************");
            DinnerSet set = (DinnerSet) iterator.next();
            set.print_set();
            System.out.println("*********************************");

        }
    }

        public static void smallReviewsOfAllOrders(SetsList setslist){
            System.out.println("This is small review of all orders:");
            Iterator iterator2 = setslist.getOrders().iterator();
            int number = 1;
            while (iterator2.hasNext()){
                System.out.println("Order #"+number);
                DinnerSet set = (DinnerSet) iterator2.next();
                System.out.println(set.toString());
                System.out.println("*********************************");
                number++;
            }
    }
}
