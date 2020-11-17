package CrockeryCutleryLab;
import java.time.LocalDate;

import java.util.LinkedHashMap;


public class TeaSet extends DinnerSet{
    LinkedHashMap<String, Integer> tea_cost = new LinkedHashMap<String, Integer>();
    Material material;
    int kettles_n, cup_n, butter_dish_n, candyBowl_n, creamer_n, i;
    public TeaSet(String title, LocalDate date,   int kettles_n, int cup_n,
                    int butter_dish_n, int candyBowl_n, int creamer_n, Material material, Customer customer) {
        super(title, date, customer);
        this.tea_cost.put("Kettle", 70);
        this.tea_cost.put("Cup", 20);
        this.tea_cost.put("Candy Bowl", 47);
        this.tea_cost.put("Butter Dish", 14);
        this.tea_cost.put("Creamer", 44);
        try{
            this.setkettles_n(kettles_n);
        }
        catch(AmountItemsException exc){
            System.out.println(exc.getMessage());
            this.kettles_n = kettles_n*(-1);
        }
        try{
            this.setcup_n(cup_n);
        }
        catch(AmountItemsException exc){
            System.out.println(exc.getMessage());
            this.cup_n = cup_n*(-1);
        }
        try{
            this.setbutter_dish_n(butter_dish_n);
        }
        catch(AmountItemsException exc){
            System.out.println(exc.getMessage());
            this.butter_dish_n = butter_dish_n*(-1);
        }
        try{
            this.setcandyBowl_n(candyBowl_n);
        }
        catch(AmountItemsException exc){
            System.out.println(exc.getMessage());
            this.candyBowl_n = candyBowl_n*(-1);
        }
        try{
            this.setcreamer_n(creamer_n);
        }
        catch(AmountItemsException exc){
            System.out.println(exc.getMessage());
            this.creamer_n = creamer_n*(-1);
        }
        this.material = material;
    }

    public TeaSet(String title, LocalDate date,   int kettles_n, int cup_n,
                  int butter_dish_n, int candyBowl_n, int creamer_n, Material material){
        super(title, date, new Customer("Anonim", "Anonim", true));
        this.tea_cost.put("Kettle", 70);
        this.tea_cost.put("Cup", 20);
        this.tea_cost.put("Candy Bowl", 47);
        this.tea_cost.put("Butter Dish", 14);
        this.tea_cost.put("Creamer", 44);
        this.kettles_n = kettles_n;
        this.cup_n = cup_n;
        this.butter_dish_n = butter_dish_n;
        this.candyBowl_n = candyBowl_n;
        this.creamer_n = creamer_n;
        this.material = material;
    }

    public LinkedHashMap<String, Integer> getItems_cost() {
        return tea_cost;
    }

    public void setItems_cost(LinkedHashMap<String, Integer> tea_cost) {
        this.tea_cost = tea_cost;
    }

    public int getkettles_n() {
        return kettles_n;
    }

    public void setkettles_n(int kettles_n) throws AmountItemsException {
        if(kettles_n >= 0) {
            this.kettles_n = kettles_n;
            return;
        }
        throw new AmountItemsException("Numbers of kettles can't be negative. It will be replaced by opposite: " +
                kettles_n*(-1));
    }

    public int getcup_n() {
        return cup_n;
    }


    public void setcup_n(int cup_n) throws AmountItemsException {
        if(cup_n >= 0) {
            this.cup_n = cup_n;
            return;
        }
        throw new AmountItemsException("Numbers of cups can't be negative. It will be replaced by opposite: " +
                cup_n*(-1));
    }

    public int getbutter_dish_n() {
        return butter_dish_n;
    }


    public void setbutter_dish_n(int butter_dish_n) throws AmountItemsException {
        if(butter_dish_n >= 0) {
            this.butter_dish_n = butter_dish_n;
            return;
        }
        throw new AmountItemsException("Numbers of butter dishes can't be negative. It will be replaced by opposite: " +
                butter_dish_n*(-1));
    }
    public int getcandyBowl_n() {
        return candyBowl_n;
    }


    public void setcandyBowl_n(int candyBowl_n) throws AmountItemsException {
        if(candyBowl_n >= 0) {
            this.candyBowl_n = candyBowl_n;
            return;
        }
        throw new AmountItemsException("Numbers of candy bowls can't be negative. It will be replaced by opposite: " +
                candyBowl_n*(-1));
    }

    public int getcreamer_n() {
        return creamer_n;
    }

    public void setcreamer_n(int creamer_n) throws AmountItemsException {
        if(creamer_n >= 0) {
            this.creamer_n = creamer_n;
            return;
        }
        throw new AmountItemsException("Numbers of creamers can't be negative. It will be replaced by opposite: " +
                creamer_n*(-1));
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int find_cost(){
        return this.kettles_n * this.tea_cost.get("Kettle") +
                this.cup_n * this.tea_cost.get("Cup") +
                this.butter_dish_n * this.tea_cost.get("Butter Dish") +
                this.candyBowl_n *  this.tea_cost.get("Candy Bowl") +
                this.creamer_n * this.tea_cost.get("Creamer");
    }


    @Override
    public void print_set(){
        int i = 0;
        System.out.println("We are glad to repeat your new wonderful TeaSet made of " + this.material.toString());
        Integer[] quantity  = {this.kettles_n, this.cup_n, this.butter_dish_n,this.candyBowl_n,this.creamer_n};
        for(String key : tea_cost.keySet()){
            System.out.println(key + ": " + quantity[i] + " units");
            i++;
        }
        System.out.println("It's full price is: " + find_cost());
        System.out.println("It must be finished on this: " + this.getDate().plusDays(7));
    }

}
