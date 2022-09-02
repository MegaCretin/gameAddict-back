package fr.projetannuel.gameaddict.services.services;

import fr.projetannuel.gameaddict.model.Tag;

import java.util.List;

public interface TagJeuService {
    public List<Tag> getAllTagsById(Long id);
    public void addTagJeu(List<Long> tags, Long id);
}
