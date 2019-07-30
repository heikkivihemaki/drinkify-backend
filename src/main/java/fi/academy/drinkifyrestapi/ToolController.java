package fi.academy.drinkifyrestapi;

import fi.academy.drinkifyrestapi.classes.Item;
import fi.academy.drinkifyrestapi.classes.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/toolshed")
public class ToolController {

    @Autowired ItemRepository itemrepo;

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
    public Item addItem(@RequestBody Item newItem) {
        User u = new User ("Erkki Esimerkki", "erkki@esimerkki.fi");
        u.setId(String.valueOf(ObjectId.get()));
        Item item = new Item(newItem.getName().trim(), newItem.getDescription(),newItem.getCategory(), newItem.isAvailable());
        item.setOwner(u);
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


