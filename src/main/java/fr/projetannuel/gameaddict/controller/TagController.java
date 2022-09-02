package fr.projetannuel.gameaddict.controller;

import fr.projetannuel.gameaddict.model.Tag;
import fr.projetannuel.gameaddict.repo.TagRepository;
import fr.projetannuel.gameaddict.services.services.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")
public class TagController {
    @Autowired
    private TagService tagService;
    Logger logger = (Logger) LoggerFactory.getLogger(TagController.class);

    @PostMapping("/tag")
    public Tag addTag( @RequestBody Tag tag){
        logger.debug("EndPoint: Ajout d'un tag");
        return tagService.addTag(tag);
    }

    @GetMapping("/tags")
    public List<Tag> allTags() {
        logger.debug("EndPoint: Récupération de la liste de tags");
        return tagService.getAllTags();
    }

    @GetMapping("/tag/{id}")
    public Tag getOneTag(@PathVariable Long id) {
        logger.debug("EndPoint: Récupération du tag avec id = " + id);
        return tagService.getOneTag(id);
    }

    @PutMapping("/tag/{id}")
    public Tag updateTag(@RequestBody Tag tag, @PathVariable Long id){
        logger.debug("EndPoint: Update tag avec id = " + id);
        return tagService.updateTag(tag, id);
    }

    @DeleteMapping("/tag/{id}")
    public void deleteTag(@PathVariable Long id) {
        logger.debug("EndPoint: Delete tag avec id = " + id);
        tagService.deleteTag(id);
    }
}
