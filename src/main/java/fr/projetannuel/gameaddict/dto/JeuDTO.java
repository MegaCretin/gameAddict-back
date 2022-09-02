package fr.projetannuel.gameaddict.dto;

import fr.projetannuel.gameaddict.model.Jeu;
import fr.projetannuel.gameaddict.model.Tag;

import java.util.ArrayList;
import java.util.List;

public class JeuDTO extends Jeu {
    private List<Tag> listTags = new ArrayList<>();

    public JeuDTO(Long id, String name, String description, String date, Integer player, Integer grade, List<Tag> listTags) {
        super(id, name, description, date, player, grade);
        this.listTags = listTags;
    }

    public List<Tag> getListTags() {
        return listTags;
    }

    public void setListTags(List<Tag> listTags) {
        this.listTags = listTags;
    }
}
