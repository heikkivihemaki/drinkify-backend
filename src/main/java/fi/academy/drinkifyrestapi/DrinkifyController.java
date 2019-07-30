package fi.academy.drinkifyrestapi;

import fi.academy.drinkifyrestapi.classes.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/drinkify")
public class DrinkifyController {

    @Autowired DrinkRepository drinkrepo;
    @Autowired AlcoholRepository alcorepo;

    @GetMapping("/healthcheck")
    public String healthcheck(){
        return "Hello world!";
    }

    @GetMapping("")
    public List<Drink> getDrinks(){
        return drinkrepo.findAll();
    }

    @PostMapping("")
    public Drink addDrink(@RequestBody Drink newDrink) {
        Drink drink = new Drink(newDrink.getName().trim(), newDrink.getRecipe(), newDrink.isVirgin());
        drinkrepo.save(drink);
        return drink;
    }

    @DeleteMapping("/{id}")
    public String deleteDrink(@PathVariable String id) {
        boolean result = drinkrepo.existsById(id);
        return"( \"deleted\" : "+ (result? "true": "false") + " }";
    }





}
