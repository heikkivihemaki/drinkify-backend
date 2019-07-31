package fi.academy.drinkifyrestapi;

import fi.academy.drinkifyrestapi.classes.Item;
import fi.academy.drinkifyrestapi.classes.Photo;
import fi.academy.drinkifyrestapi.classes.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/toolshed")
public class ToolController {

    @Autowired ItemRepository itemrepo;
    @Autowired UserRepository userrepo;
    @Autowired PhotoRepository photorepo;

    @GetMapping("/healthcheck")
    public String healthcheck(){
        return "Hello world!";
    }

    @GetMapping("") public List<Item> getItems(){ return itemrepo.findAll(); }

    @GetMapping("/available") public List<Item> getAvailable() { return itemrepo.findAllByAvailableTrue(); }

    @GetMapping("/byCategory") public List<Item> getByCategory(@RequestParam String haku) { return itemrepo.findAllByCategory(haku); }

    @GetMapping("/byName") public List<Item> getByName() { return itemrepo.findAllByName("GT"); }

    @GetMapping("/availablecategory") public List<Item> getAvailableAndByCategory(@RequestParam String category) { return itemrepo.findAllByCategoryAndAvailableTrue(category);}

    @PostMapping("")
    public Item addTestItem(@RequestBody Item newItem) {
        Optional<User> u = userrepo.findById("5d416b6a11674638dc27dd34"); // Tässä vaiheessa tähän pitää copypasteta userin id!
        User user = u.get();
        Optional<Photo> optPhoto = photorepo.findById("valokuvanid");
        Photo photo = optPhoto.get();
        Item item = new Item(newItem.getName(), newItem.getDescription(), newItem.getCategory(), newItem.isAvailable());
        item.setOwner(user);
        item.setPhoto(photo);
        itemrepo.save(item);
        return item;
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable String id) {
        boolean result = itemrepo.existsById(id);
        itemrepo.deleteById(id);
        return"( \"deleted\" : "+ (result? "true": "false") + " }";
    }


}


