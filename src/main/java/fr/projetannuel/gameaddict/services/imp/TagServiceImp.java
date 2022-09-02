package fr.projetannuel.gameaddict.services.imp;

import fr.projetannuel.gameaddict.model.Tag;
import fr.projetannuel.gameaddict.repo.TagRepository;
import fr.projetannuel.gameaddict.services.services.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImp implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImp(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag addTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag getOneTag(Long id) {
        return tagRepository.findById(id).get();
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag updateTag(Tag tag, Long id) {
        Tag tagUpdate = tagRepository.findById(id).get();
        tagUpdate.setName(tag.getName());
        return tagRepository.save(tagUpdate);
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
