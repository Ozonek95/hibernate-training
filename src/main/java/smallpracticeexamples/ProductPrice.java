package smallpracticeexamples;

import javax.persistence.Embeddable;


@Embeddable
public class ProductPrice {


    private double price;
    private String currency;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
