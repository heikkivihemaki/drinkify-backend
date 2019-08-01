package fi.academy.drinkifyrestapi;

import fi.academy.drinkifyrestapi.classes.Item;
import fi.academy.drinkifyrestapi.classes.Photo;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api/photos")
public class PhotoController {

    @Autowired
    private PhotoRepository photoRepo;

    public String addPhoto( MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setImage(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        photo = photoRepo.insert(photo); return photo.getId();
    }

    public Photo getPhoto(String id) {
        return photoRepo.findById(id).get();
    }

    @PostMapping("/photos/add")
    public String addPhoto(@RequestParam("title") String title,
                           @RequestParam("image") MultipartFile image, Model model)
            throws IOException {
        String id = addPhoto(image);
        return "redirect:/photos/" + id;
    }

    @GetMapping("/photos/") public List<Photo> getPhotos(){ return photoRepo.findAll(); }

    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable String id, Model model) {
        Photo photo = getPhoto(id);
        model.addAttribute("image",
                Base64.getEncoder().encodeToString(photo.getImage().getData()));
        return photo;
    }
}
