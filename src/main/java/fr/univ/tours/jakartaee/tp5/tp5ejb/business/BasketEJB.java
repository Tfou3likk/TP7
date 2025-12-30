package fr.univ.tours.jakartaee.tp5.tp5ejb.business;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.DiskToSold;
import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.User;
import jakarta.ejb.Local;

import java.sql.SQLException;
import java.util.List;

@Local
public interface BasketEJB {

    List<DiskToSold> getBasketDetail() throws SQLException;

    void addToBasket(String diskReference);

    void removeFromBasket(String diskReference);

    boolean makeOrder(User buyer) throws SQLException;
}
