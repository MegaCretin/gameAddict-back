package fr.projetannuel.gameaddict.services.services;

import fr.projetannuel.gameaddict.dto.JeuDTO;
import fr.projetannuel.gameaddict.model.Jeu;

import java.util.List;

public interface JeuService {

    public Jeu addJeu(JeuDTO jeuDTO);
    public Jeu getOneJeu(Long id);
    public List<Jeu> getAllJeux();
    public Jeu updateJeu(Jeu jeu, Long id);
    public void deleteJeu(Long id);

}
