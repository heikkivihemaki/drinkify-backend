package fi.academy.drinkifyrestapi;

import fi.academy.drinkifyrestapi.classes.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Rajapinta, jolla tehdään kyselyjä Item-rajapintaan
 */
public interface ItemRepository extends MongoRepository<Item, String> {
    /**
     *
     * @param name
     * @return
     */
    List<Item> findAllByName(String name);

    /**
     *
     * @return
     */
    List<Item> findAllByAvailableTrue();

    /**
     * Hakee Item-collectionista tavaran kategorian perusteella
     * @param category Saa parametrina Stringin, jonka perusteella etsitään
     * @return palauttaa listan Itemeitä
     */
    List<Item> findAllByCategory(String category);

    /**
     * Sama kuin edellä + filtteröidään ne, jotka eivät ole varattuja
     * @param category Sama kuin edellä
     * @return palauttaa listan tavaroita JSON-muodossa
     */
    List<Item> findAllByCategoryAndAvailableTrue(String category);
}
