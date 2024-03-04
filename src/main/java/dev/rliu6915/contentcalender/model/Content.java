package dev.rliu6915.contentcalender.model;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        String title,
        String description,
        Status status,
        Type contentType,
        LocalDateTime created,
        LocalDateTime updated,
        String url
) {

}
