package fr.projetannuel.gameaddict.repo;

import fr.projetannuel.gameaddict.model.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeuRepository extends JpaRepository<Jeu, Long> {
}
