package CrockeryCutleryLab;
import java.util.*;
import java.util.stream.Collectors;

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

    /*
        Functions for Functional Lab
     */


    public int findAllPlasticMoney(){
        return orders.stream()
                .filter(order -> order.getMaterial().equals(Material.Plastic))
                .mapToInt(DinnerSet::find_cost).sum();
    }

    public Optional<DinnerSet> findMaxPrice(){
        return orders.stream().max(Comparator.comparingInt(DinnerSet::find_cost));
    }

    public double findAveragePrice(){
        return orders.stream().mapToInt(DinnerSet::find_cost).average().orElse(0);
    }

    public Map<String, List<DinnerSet>> getPlasticOrders(){
        return orders.stream().collect(Collectors.groupingBy(order -> order.getMaterial() == Material.Plastic ?
                "Orders with Plastic Material" : "Orders with non-plastic material"));
    }

    public Material getTheMostCommonTeaSetMaterial(){
        List<Material> teaMaterials =  orders.stream()
                .filter(order->order instanceof TeaSet)
                .map(tea -> ((TeaSet) tea).getMaterial())
                .collect(Collectors.toList());
        return teaMaterials.stream()
                .distinct()
                .max(Comparator.comparing(e -> Collections.frequency(teaMaterials, e)))
                .get();
    }
}
