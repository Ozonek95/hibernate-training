package smallpracticeexamples;

import javax.persistence.*;

@Entity
public class ProductOne {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private ProductPrice productPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ProductPrice getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(ProductPrice productPrice) {
        this.productPrice = productPrice;
    }
}
