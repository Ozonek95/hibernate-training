package com.shop;

import com.shop.controller.ControllerGuitar;
import com.shop.controller.ControllerProduct;
import com.shop.repository.mysql.MySqlRepositoryGuitar;
import com.shop.domain.*;
import com.shop.hibernate.HibernateSessionRegistery;
import com.shop.repository.mysql.MySqlRepositoryProduct;
import org.hibernate.Session;

public class ShopApp {
    public static void main(String[] args) {
        Session session =
                HibernateSessionRegistery
                        .getSessionFactory()
                        .openSession();

//        MySqlRepositoryWarehouse mySqlRepositoryWarehouse = new MySqlRepositoryWarehouse(session);
//        ControllerWarehouse controllerWarehouse = new ControllerWarehouse(mySqlRepositoryWarehouse,session);
        MySqlRepositoryProduct mySqlRepositoryProduct = new MySqlRepositoryProduct(session);
        ControllerProduct controllerProduct = new ControllerProduct(session, mySqlRepositoryProduct);
        //  WarehouseDTO warehouseDTO = new WarehouseDTO("Kmie","Ulica","Miasto","Kod","Budynek","kraj","imie","male");
        // Owner owner = new Owner("Marcin", Sex.MALE);
//        controllerWarehouse.create(warehouseDTO);
//
//        controllerWarehouse.create(warehouseDTO);
       controllerProduct.create("Kacpi", "Supi");
//        List<Warehouse> warehouses = controllerWarehouse.findAll();
        //    warehouses.forEach(System.out::println);

        MySqlRepositoryGuitar mySqlRepositoryGuitar = new MySqlRepositoryGuitar(session);
        ControllerGuitar controllerGuitar = new ControllerGuitar(session, mySqlRepositoryGuitar);
        Guitar guitar = new Guitar();
        Price price = new Price(500.0f, "Dolar");
        GuitarManufacturer guitarManufacturer = new GuitarManufacturer("Gibson");
        guitar.setGuitarManufacturer(guitarManufacturer);
        guitar.setHanded(Handed.RIGHT);
        guitar.setName("Les Paul");
        // controllerGuitar.saveGuitar(guitar);

        controllerGuitar.createGuitar(guitar);


        Guitar guitar2 = session.get(Guitar.class,1);



        session.close();
        HibernateSessionRegistery.shutdown();
    }
}
