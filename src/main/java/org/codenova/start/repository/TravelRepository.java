package org.codenova.start.repository;

import org.apache.ibatis.annotations.Mapper;
import org.codenova.start.entity.TravelComment;
import org.codenova.start.query.TravelCount;

import java.util.List;

@Mapper
public interface TravelRepository {
    public List<TravelComment> findByIsoCode(String isoCode);
    public int create(TravelComment travelComment);
    public TravelCount findCountByIsoCode(String isoCode);
}
