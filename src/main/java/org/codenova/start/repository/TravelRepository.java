package org.codenova.start.repository;

import org.apache.ibatis.annotations.Mapper;
import org.codenova.start.entity.TravelComment;

import java.util.List;

@Mapper
public interface TravelRepository {
    public List<TravelComment> findAll();
    public int create(TravelComment travelComment);
}
