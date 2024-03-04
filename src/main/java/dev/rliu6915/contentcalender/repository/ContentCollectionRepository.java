package dev.rliu6915.contentcalender.repository;

import dev.rliu6915.contentcalender.model.Content;
import dev.rliu6915.contentcalender.model.Status;
import dev.rliu6915.contentcalender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    public void  init() {
        Content content = new Content(
                1,
                "This is a title",
                "This is a description",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "http://www.google.com"
        );
        contentList.add(content);
    }

    public void save(Content content) {
//        this.contentList.add(content);
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public boolean notExistsById(Integer id) {
        return contentList.stream().noneMatch(c -> c.id().equals(id));
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
