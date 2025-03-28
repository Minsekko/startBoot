package org.codenova.start.model.travel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Body {
    private String dataType;
    private Items items;
    private String numOfRows;
    private String pageNo;
    private String totalCount;
}
