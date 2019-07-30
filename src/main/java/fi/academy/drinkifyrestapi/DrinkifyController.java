package fi.academy.drinkifyrestapi;

import fi.academy.drinkifyrestapi.classes.Alcohol;
import fi.academy.drinkifyrestapi.classes.Drink;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/virgins")
    public List<Drink> getVirgins() {
        return drinkrepo.findAllByVirginTrue();
    }

    @GetMapping("/byName")
    public List<Drink> getByName() {
        return drinkrepo.findAllByName("GT");
    }

    @PostMapping("")
    public Drink addDrink(@RequestBody Drink newDrink) {
        Drink drink = new Drink(newDrink.getName(), newDrink.getRecipe(), newDrink.getBooze(), newDrink.isVirgin());
        drinkrepo.save(drink);
        return drink;
    }




}


