package org.codenova.start.model.animal;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Body {
    private Items items;
    private int numOfRows;
    private int pageNo;
    private int totalCount;
}
