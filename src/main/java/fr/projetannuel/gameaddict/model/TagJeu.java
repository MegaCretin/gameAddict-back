package fr.projetannuel.gameaddict.model;

import javax.persistence.*;

@Entity
@Table(name = "tag_jeu")
public class TagJeu {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @Column(name = "idJeu", nullable = false)
    private Long idJeu;

    @Column(name = "idTag", nullable = false)
    private Long idTag;

    public TagJeu() {
    }

    public TagJeu(Long idJeu, Long idTag) {
        this.idJeu = idJeu;
        this.idTag = idTag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdJeu() {
        return idJeu;
    }

    public void setIdJeu(Long idJeu) {
        this.idJeu = idJeu;
    }

    public Long getIdTag() {
        return idTag;
    }

    public void setIdTag(Long idTag) {
        this.idTag = idTag;
    }


}