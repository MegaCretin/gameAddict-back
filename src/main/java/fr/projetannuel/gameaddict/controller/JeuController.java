package fr.projetannuel.gameaddict.controller;

import fr.projetannuel.gameaddict.model.Jeu;
import fr.projetannuel.gameaddict.model.Tag;
import fr.projetannuel.gameaddict.repo.JeuRepository;
import fr.projetannuel.gameaddict.services.services.JeuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jeux")
public class JeuController {

    @Autowired
    private JeuService jeuService;

    Logger logger = (Logger) LoggerFactory.getLogger(TagController.class);

    @PostMapping("/jeu")
    public Jeu addTag(@RequestBody Jeu tag, List<Long> tags){
        logger.debug("EndPoint: Ajout d'un jeu");
        return jeuService.addJeu(tag, tags);
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
}
