package fr.projetannuel.gameaddict.services.imp;

import fr.projetannuel.gameaddict.dto.JeuDTO;
import fr.projetannuel.gameaddict.model.Jeu;
import fr.projetannuel.gameaddict.repo.JeuRepository;
import fr.projetannuel.gameaddict.services.services.JeuService;
import fr.projetannuel.gameaddict.services.services.TagJeuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JeuServiceImp implements JeuService {

    private final JeuRepository jeuRepository;
    private final TagJeuService tagJeuService;

    public JeuServiceImp(JeuRepository jeuRepository, TagJeuService tagJeuService) {
        this.jeuRepository = jeuRepository;
        this.tagJeuService = tagJeuService;
    }

    @Override
    public Jeu addJeu(JeuDTO jeuDTO) {
        Jeu jeu = new Jeu(jeuDTO.getId(), jeuDTO.getName(), jeuDTO.getDescription(), jeuDTO.getDate(), jeuDTO.getPlayer() ,jeuDTO.getGrade());
        Jeu jeuWithNote = addNote(jeu);

        tagJeuService.addTagJeu(jeuDTO.getListTags(), jeu.getId());
        return jeuRepository.save(jeuWithNote);
    }

    @Override
    public Jeu getOneJeu(Long id) {
        return jeuRepository.findById(id).get();
    }

    @Override
    public List<Jeu> getAllJeux() {
        return jeuRepository.getAllJeu();
    }

    @Override
    public Jeu updateJeu(Jeu jeu, Long id) {
        return jeuRepository.save(jeu);
    }

    @Override
    public void deleteJeu(Long id) {
        jeuRepository.deleteById(id);
    }

    private Jeu addNote(Jeu jeu) {
        int note = 0;
        switch (tagJeuService.getAllTagsById(jeu.getId()).size()){
            case 1,2,3:
                note += 1;
                break;
            case 4,5,6:
                note += 2;
                break;
            case 7,8,9:
                note += 3;
                break;
            case 10,11:
                note += 4;
                break;
            case 12,13:
                note += 5;
                break;
        }

        if (jeu.getPlayer() >= 10 && jeu.getPlayer() < 30){
            note += 1;
        } else if (jeu.getPlayer() < 100){
            note += 2;
        } else if (jeu.getPlayer() < 500){
            note += 3;
        } else if (jeu.getPlayer() < 1000){
            note += 4;
        } else {
            note += 5;
        }

        if (jeu.getDescription().length() >= 10 && jeu.getDescription().length() < 30){
            note += 1;
        } else if (jeu.getDescription().length() < 100){
            note += 2;
        } else if (jeu.getDescription().length() < 500){
            note += 3;
        } else if (jeu.getDescription().length() < 1000){
            note += 4;
        } else {
            note += 5;
        }

        int annee = 2022 - Integer.parseInt(jeu.getDate().split("/")[0]);

        if (annee > 20){
            note += 1;
        } else if (annee > 15){
            note += 2;
        } else if (annee > 10){
            note += 3;
        } else if (annee > 5){
            note += 4;
        } else {
            note += 5;
        }

        jeu.setGrade(note);

        return jeu;
    }
}
