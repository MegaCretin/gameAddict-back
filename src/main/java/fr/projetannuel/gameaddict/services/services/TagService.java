package fr.projetannuel.gameaddict.services.services;

import fr.projetannuel.gameaddict.model.Tag;

import java.util.List;

public interface TagService {

    public Tag addTag(Tag tag);
    public Tag getOneTag(Long id);
    public List<Tag> getAllTags();
    public Tag updateTag(Tag tag, Long id);
    public void deleteTag(Long id);
}
