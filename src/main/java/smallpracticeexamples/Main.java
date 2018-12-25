package smallpracticeexamples;

import com.shop.hibernate.HibernateSessionRegistery;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session  = HibernateSessionRegistery.getSessionFactory().openSession();

        ProductPrice productPrice = new ProductPrice();
        productPrice.setCurrency("PLNS");
        productPrice.setPrice(20.0);

        ProductOne productOne = new ProductOne();
        productOne.setName("Produkt 1");
        productOne.setProductPrice(productPrice);

        session.save(productOne);

        session.close();
        HibernateSessionRegistery.shutdown();
    }
}
