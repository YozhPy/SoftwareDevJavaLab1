package CrockeryCutleryLab;
import java.util.ArrayList;
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

}
