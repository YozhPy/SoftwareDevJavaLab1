package CrockeryCutleryLab;

public class Customer {
    private String name;
    private String surname;

    public Customer(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCustomerName(){
        return this.name + ' ' + this.surname + ' ';
    }

    @Override
    public String toString() {
        return getCustomerName();
    }
}
