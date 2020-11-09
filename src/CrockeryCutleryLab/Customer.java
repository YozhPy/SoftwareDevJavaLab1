package CrockeryCutleryLab;

public class Customer implements Person{
    private String name;
    private String surname;
    private String fullname;
    private Boolean isNew;
    public Customer(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.isNew = false;
    }

    public Customer(String name, String surname, Boolean isNew){
        this.name = name;
        this.surname = surname;
        this.isNew = isNew;
    }

    public Customer(String fullname){
        String[] words = fullname.split(" ", 2);
        this.name = words[0];
        this.fullname = words[1];
        this.isNew = false;
    }

    public Customer(String fullname, Boolean isNew){
        String[] words = fullname.split(" ", 2);
        this.name = words[0];
        this.surname = words[1];
        this.isNew = isNew;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
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

    public String getFullName(){
        return this.name + ' ' + this.surname + ' ';
    }

    @Override
    public String toString() {
        return getFullName();
    }


    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + this.name.length();
        result = prime * result + this.surname.length();
        return result;
    }

}
