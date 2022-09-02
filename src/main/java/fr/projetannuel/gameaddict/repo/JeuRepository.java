package fr.projetannuel.gameaddict.repo;

import fr.projetannuel.gameaddict.model.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JeuRepository extends JpaRepository<Jeu, Long> {

    @Query("SELECT j FROM Jeu j ORDER BY j.grade DESC")
    List<Jeu> getAllJeu();
}
