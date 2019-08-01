package fi.academy.drinkifyrestapi.classes;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *Tällä luotaisiin uusi valokuva, joka laitettaisiin MongoDB:hen.
 * Viittaus id:hen (tai kuva upoetettuna) Item -luokassa
 */
@Document(collection = "photos")
public class    Photo {
    @Id
    private String id;
//    private String title;
    private Binary image;

    public Photo() {
    }

//    public Photo(String title) {
//        this.title = title;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }
}