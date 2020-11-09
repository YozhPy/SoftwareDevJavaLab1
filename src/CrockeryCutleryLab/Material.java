package CrockeryCutleryLab;

public enum Material {
    Porcelain(),
    Faience(true),
    Ceramics(true),
    Glass(true),
    Metal(),
    Plastic();
    Boolean isFragile;

    Material(){
        this.isFragile = false;
    }
    Material(boolean isFragile){
        this.isFragile = isFragile;
    }

    public Boolean getFragile() {
        return isFragile;
    }

    public void setFragile(Boolean fragile) {
        isFragile = fragile;
    }

    @Override
    public String toString(){
       if(this.isFragile){
           return this.name() + " ATTENTION!!! VERY FRAGILE MATERIAL!!! BE CAREFUL";
       }
       else{
           return this.name();
       }
    }
}
