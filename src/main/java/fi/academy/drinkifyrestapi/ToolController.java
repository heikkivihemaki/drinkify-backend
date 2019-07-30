package fi.academy.drinkifyrestapi;

import fi.academy.drinkifyrestapi.classes.Item;
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

    @GetMapping("")
    public List<Item> getItems(){
        return itemrepo.findAll();
    }

    @GetMapping("/available")
    public List<Item> getAvailable() {
        return itemrepo.findAllByAvailableTrue();
    }

    @GetMapping("/byName")
    public List<Item> getByName() {
        return itemrepo.findAllByName("GT");
    }

    @PostMapping("")
    public Item addDrink(@RequestBody Item newItem) {
        Item item = new Item(newItem.getName().trim(), newItem.getDescription(), newItem.getCategory(),newItem.isAvailable());
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


