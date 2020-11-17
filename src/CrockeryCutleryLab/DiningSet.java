package CrockeryCutleryLab;
import java.time.LocalDate;
import java.util.LinkedHashMap;

public class DiningSet extends DinnerSet{
    LinkedHashMap<String, Integer> items_cost = new LinkedHashMap<String, Integer>();
    Material material;
    int plates_n, tureen_n, salad_n, sauce_n, jug_n;
    public DiningSet(String title, LocalDate date, int p_n, int t_n,
                      int s_n, int sauce_n, int jug_n, Material material, Customer customer) {
        super(title, date, customer);
        this.items_cost.put("Small plate", 30);
        this.items_cost.put("Tureen", 36);
        this.items_cost.put("Salad Bowl", 47);
        this.items_cost.put("Sauce Bowl", 14);
        this.items_cost.put("Jug", 44);
        this.plates_n = p_n;
        this.tureen_n = t_n;
        this.salad_n = s_n;
        this.sauce_n = sauce_n;
        this.jug_n = jug_n;
        this.material = material;
    }

    public DiningSet(String title, LocalDate date, int p_n, int t_n,
                     int s_n, int sauce_n, int jug_n, Material material) {
        super(title, date);
        this.items_cost.put("Small plate", 30);
        this.items_cost.put("Tureen", 36);
        this.items_cost.put("Salad Bowl", 47);
        this.items_cost.put("Sauce Bowl", 14);
        this.items_cost.put("Jug", 44);
        this.plates_n = p_n;
        this.tureen_n = t_n;
        this.salad_n = s_n;
        this.sauce_n = sauce_n;
        this.jug_n = jug_n;
        this.material = material;
    }

    public LinkedHashMap<String, Integer> getItems_cost() {
        return items_cost;
    }

    public void setItems_cost(LinkedHashMap<String, Integer> items_cost) {
        this.items_cost = items_cost;
    }

    public int getPlates_n() {
        return plates_n;
    }

    public void setPlates_n(int plates_n) {
        this.plates_n = plates_n;
    }

    public int getTureen_n() {
        return tureen_n;
    }

    public void setTureen_n(int tureen_n) {
        this.tureen_n = tureen_n;
    }

    public int getSalad_n() {
        return salad_n;
    }

    public void setSalad_n(int salad_n) {
        this.salad_n = salad_n;
    }

    public int getSauce_n() {
        return sauce_n;
    }

    public void setSauce_n(int sauce_n) {
        this.sauce_n = sauce_n;
    }

    public int getJug_n() {
        return jug_n;
    }

    public void setJug_n(int jug_n) {
        this.jug_n = jug_n;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int find_cost(){
        return this.plates_n * this.items_cost.get("Small plate") +
                this.tureen_n * this.items_cost.get("Tureen") +
                this.salad_n * this.items_cost.get("Salad Bowl") +
                this.sauce_n *  this.items_cost.get("Sauce Bowl") +
                this.jug_n * this.items_cost.get("Jug");

    }

    @Override
    public void print_set(){
        System.out.println("We are glad to repeat your new wonderful DiningSet made of " + this.material.toString());
        Integer[] quantity  = {this.plates_n, this.tureen_n, this.salad_n,this.sauce_n,this.jug_n};
        int i = 0;
        System.out.println();
        for (String key : items_cost.keySet()){
            System.out.println(key + ": " + quantity[i] + " units");
            i += 1;
        }
        System.out.println("It's full price is: " + find_cost());
        System.out.println("It must be finished on this: " + this.getDate().plusDays(7));
    }

}
