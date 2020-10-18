package CrockeryCutleryLab;
import java.time.LocalDate;
public abstract class DinnerSet {
    protected String title;
    protected LocalDate date;
    protected Customer customer;
    private SmallReview smallReview;


    public DinnerSet(String title, LocalDate date, Customer customer){
        this.title = title;
        this.date = date;
        this.customer = customer;
        this.smallReview = new SmallReview();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    abstract void print_set();



    @Override
    public String toString(){
        return smallReview.getReview();
    }

    private class SmallReview {
        private LocalDate lastDate;
        public SmallReview(){
            this.lastDate = DinnerSet.this.date.plusDays(7);
        }

        public LocalDate getLastDate() {
            return lastDate;
        }

        public void setLastDate(LocalDate lastDate) {
            this.lastDate = lastDate;
        }

        public String getReview(){
            return "This is order of: " + DinnerSet.this.customer + ". It must be finished till: " + this.lastDate;
        }


    }
}
