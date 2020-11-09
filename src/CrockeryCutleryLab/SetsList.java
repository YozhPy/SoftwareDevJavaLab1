package CrockeryCutleryLab;
import java.util.ArrayList;
import java.util.Iterator;
public class SetsList {
    private String title;
    private ArrayList<DinnerSet> orders;

    public SetsList(String title){
        this.title = title;
        this.orders = new ArrayList<DinnerSet>();
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<DinnerSet> getOrders() {
        return orders;
    }

    public void addOrder(DinnerSet set){
        orders.add(set);
    }

    public int getOrdersAmount(){
        return orders.size();
    }

    public boolean clientsNeedsRegistration(){
        Iterator iterator = orders.iterator();
        while(iterator.hasNext()){
            DinnerSet order = (DinnerSet)iterator.next();
            Customer customer = order.getCustomer();
            if(customer.getNew()) {
                return true;
            }
        }
        return false;

    }

}
