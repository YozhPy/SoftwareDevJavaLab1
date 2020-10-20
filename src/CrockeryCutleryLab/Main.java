package CrockeryCutleryLab;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.Iterator;
public class Main {

    public static void main(String[] args){
        SetsList first = fillSetList();
        orderConfirmation(first);
    }



    public static SetsList fillSetList(){
        SetsList firstList = new SetsList("This is our first client! Yohouu");
        Customer customer = new Customer("Yegor", "Nikishenko");
        firstList.addOrder(new DiningSet("Medium DiningSet", LocalDate.now(), customer,
                            1, 2, 3, 4, 5, Material.Glass));
        firstList.addOrder(new DiningSet("Small DiningSet", LocalDate.now(), customer,
                0, 1, 2, 3, 4, Material.Glass));
        firstList.addOrder(new TeaSet("Small TeaSet", LocalDate.now(), customer,
               1, 6, 1, 3, 2, Material.Porcelain));
        return firstList;
    }

    public static void orderConfirmation(SetsList setslist){
        System.out.println(setslist.getOrders().get(0).customer.toString() + ", we are happy to make so wonderful Set, but let's confirm this order!");
        System.out.println("You have already ordered " + setslist.getOrdersAmount() + " crockery and cutlery sets");
        System.out.println("So, in your sets:");
        Iterator iterator = setslist.getOrders().iterator();
        while (iterator.hasNext()){
            System.out.println("*********************************");
            DinnerSet set = (DinnerSet) iterator.next();
            set.print_set();
            System.out.println("*********************************");

        }
    }
}
