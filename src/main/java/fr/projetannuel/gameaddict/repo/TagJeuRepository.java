package fr.projetannuel.gameaddict.repo;

import fr.projetannuel.gameaddict.model.TagJeu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagJeuRepository extends JpaRepository<TagJeu, Long> {

    @Query("SELECT t FROM TagJeu t WHERE t.idJeu = ?1")
    List<TagJeu> findAllByIdJeu(Long idJeu);
}
