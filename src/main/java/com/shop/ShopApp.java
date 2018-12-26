package com.shop;

import com.shop.controller.ControllerGuitar;
import com.shop.controller.ControllerProduct;
import com.shop.controller.ControllerWarehouse;
import com.shop.domain.dto.WarehouseDTO;
import com.shop.repository.mysql.MySqlRepositoryGuitar;
import com.shop.domain.*;
import com.shop.hibernate.HibernateSessionRegistery;
import com.shop.repository.mysql.MySqlRepositoryProduct;
import com.shop.repository.mysql.MySqlRepositoryWarehouse;
import org.hibernate.Session;

import java.util.List;

public class ShopApp {
    public static void main(String[] args) {
        Session session = HibernateSessionRegistery.getSessionFactory().openSession();

//        MySqlRepositoryWarehouse mySqlRepositoryWarehouse = new MySqlRepositoryWarehouse(session);
//        ControllerWarehouse controllerWarehouse = new ControllerWarehouse(mySqlRepositoryWarehouse, session);
//        MySqlRepositoryProduct mySqlRepositoryProduct = new MySqlRepositoryProduct(session);
//        ControllerProduct controllerProduct = new ControllerProduct(session, mySqlRepositoryProduct);
//        WarehouseDTO warehouseDTO = new WarehouseDTO("Kmie", "Ulica", "Miasto", "Kod", "Budynek", "kraj", "imie", "male");
//        controllerWarehouse.create(warehouseDTO);
//
//        controllerWarehouse.create(warehouseDTO);
//        controllerProduct.create("Kacpi", "Supi");
//        List<Warehouse> warehouses = controllerWarehouse.findAll();
//        warehouses.forEach(System.out::println);

        MySqlRepositoryGuitar mySqlRepositoryGuitar = new MySqlRepositoryGuitar(session);
        ControllerGuitar controllerGuitar = new ControllerGuitar(session, mySqlRepositoryGuitar);
        Guitar guitar = new Guitar();
        Price price = new Price(500.0f, "Dolar");
        GuitarManufacturer guitarManufacturerFender = new GuitarManufacturer("Fender");
        GuitarManufacturer guitarManufacturerGibson = new GuitarManufacturer("Gibson");
        guitar.setGuitarManufacturer(guitarManufacturerGibson);
        guitar.setHanded(Handed.RIGHT);
        guitar.setName("Les Paul");
        guitar.setPrice(price);

        controllerGuitar.createGuitar(guitar);

        controllerGuitar.updateManufacturer(guitarManufacturerFender,1);

        controllerGuitar.updatePrice(new Price(2000.0f,"Pesos"),1);

        controllerGuitar.deleteGuitar(1);



        session.close();
        HibernateSessionRegistery.shutdown();
    }
}
