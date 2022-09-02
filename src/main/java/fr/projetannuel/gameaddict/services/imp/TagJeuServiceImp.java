package fr.projetannuel.gameaddict.services.imp;

import fr.projetannuel.gameaddict.model.Tag;
import fr.projetannuel.gameaddict.model.TagJeu;
import fr.projetannuel.gameaddict.repo.TagJeuRepository;
import fr.projetannuel.gameaddict.services.services.TagJeuService;
import fr.projetannuel.gameaddict.services.services.TagService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagJeuServiceImp implements TagJeuService {

    private final TagJeuRepository tagJeuRepository;
    private final TagService tagService;

    public TagJeuServiceImp(TagJeuRepository tagJeuRepository, TagService tagService) {
        this.tagJeuRepository = tagJeuRepository;
        this.tagService = tagService;
    }

    @Override
    public List<Tag> getAllTagsById(Long id) {
        List<Tag> result = new ArrayList<>();
        tagJeuRepository.findAllByIdJeu(id).forEach(tagJeu -> {
            result.add(tagService.getOneTag(tagJeu.getIdTag()));
        });
        return result;
    }

    @Override
    public void addTagJeu(List<Long> tags, Long id) {
        tags.forEach(tag -> {
            TagJeu tagJeu = new TagJeu(id, tag);
            tagJeuRepository.save(tagJeu);
        });
    }
}
