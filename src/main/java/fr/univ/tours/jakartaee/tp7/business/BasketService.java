package fr.univ.tours.jakartaee.tp7.business;



import java.sql.SQLException;
import java.util.List;

import fr.univ.tours.jakartaee.tp7.business.pojo.DiskToSold;
import fr.univ.tours.jakartaee.tp7.business.pojo.User;


public interface BasketService {

    List<DiskToSold> getBasketDetail();

    void addToBasket(String diskReference);

    void removeFromBasket(String diskReference);

    boolean makeOrder(User buyer);
}
