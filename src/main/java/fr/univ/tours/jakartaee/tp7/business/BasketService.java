package fr.univ.tours.jakartaee.tp7.business;



import java.sql.SQLException;
import java.util.List;

import fr.univ.tours.jakartaee.tp7.business.pojo.DiskToSold;
import fr.univ.tours.jakartaee.tp7.business.pojo.User;
import fr.univ.tours.jakartaee.tp7.entities.DiskToSoldEntity;
import fr.univ.tours.jakartaee.tp7.entities.UserEntity;


public interface BasketService {

    List<DiskToSoldEntity> getBasketDetail();

    void addToBasket(String diskReference);

    void removeFromBasket(String diskReference);

    boolean makeOrder(UserEntity buyer);
}
