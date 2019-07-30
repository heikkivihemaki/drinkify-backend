package fi.academy.drinkifyrestapi.classes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "drink")
public class Drink {
    @Id
    private String id;
    private String name;
    private String recipe;
    private String booze;
    private boolean virgin;

    public Drink (){}

    public Drink(String name, String recipe, String booze, boolean virgin) {
        this.name = name;
        this.recipe = recipe;
        this.booze = booze;
        this.virgin = virgin;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getRecipe() { return recipe; }

    public void setRecipe(String recipe) { this.recipe = recipe; }

    public String getBooze() { return booze; }

    public void setBooze(String booze) { this.booze = booze; }

    public boolean isVirgin() { return virgin; }

    public void setVirgin(boolean virgin) { this.virgin = virgin; }

    @Override
    public String toString() {
        return "Drink{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", recipe='" + recipe + '\'' +
                ", booze=" + booze +
                ", virgin=" + virgin +
                '}';
    }
}
