package fi.academy.drinkifyrestapi.classes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "alcohol")
public class Alcohol {

    @Id
    private String alcoholId;
    private String name;

    public Alcohol(){}
    public Alcohol(String name) { this.name = name; }

    public String getAlcoholId() { return alcoholId; }
    public void setAlcoholId(String alcoholId) { this.alcoholId = alcoholId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Alcohol{" +
                "alcoholId='" + alcoholId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
