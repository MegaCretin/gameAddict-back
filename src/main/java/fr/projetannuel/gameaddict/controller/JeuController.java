package fr.projetannuel.gameaddict.controller;

import fr.projetannuel.gameaddict.dto.JeuDTO;
import fr.projetannuel.gameaddict.model.Jeu;
import fr.projetannuel.gameaddict.model.Tag;
import fr.projetannuel.gameaddict.repo.JeuRepository;
import fr.projetannuel.gameaddict.services.services.JeuService;
import fr.projetannuel.gameaddict.services.services.TagJeuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.metrics.StartupStep;
import org.springframework.web.bind.annotation.*;

import java.util.List;

interface jeuAdd {

}
@RestController
@RequestMapping("/api/v1/jeux")
public class JeuController {

    @Autowired
    private JeuService jeuService;

    @Autowired
    private TagJeuService tagJeuService;

    Logger logger = (Logger) LoggerFactory.getLogger(TagController.class);

    @PostMapping("/jeu")
    public Jeu addTag(@RequestBody JeuDTO jeuDTO){
        logger.debug("EndPoint: Ajout d'un jeu");
        return jeuService.addJeu(jeuDTO);
    }

    @GetMapping("/jeux")
    public List<Jeu> allJeux() {
        logger.debug("EndPoint: Récupération de la liste des jeux");
        return jeuService.getAllJeux();
    }

    @GetMapping("/jeu/{id}")
    public Jeu getOneJeu(@PathVariable Long id) {
        logger.debug("EndPoint: Récupération du jeu avec id = " + id);
        return jeuService.getOneJeu(id);
    }

    @PutMapping("/jeu/{id}")
    public Jeu updateTag(@RequestBody Jeu jeu, @PathVariable Long id){
        logger.debug("EndPoint: Update jeu avec id = " + id);
        return jeuService.updateJeu(jeu,id);
    }

    @DeleteMapping("/jeu/{id}")
    public void deleteJeu(@PathVariable Long id) {
        logger.debug("EndPoint: Delete Jeu avec id = " + id);
        jeuService.deleteJeu(id);
    }

    @GetMapping("/tags/{id}")
    public List<Tag> allTagJeu(@PathVariable Long id) {
        logger.debug("EndPoint: Récupération de la liste des tags du jeu");
        return tagJeuService.getAllTagsById(id);
    }
}
