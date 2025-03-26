package org.codenova.start.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Pokemon {
    private int id;
    private String name;
    private String type;
    private String imageUrl;
    private boolean unique;
}
