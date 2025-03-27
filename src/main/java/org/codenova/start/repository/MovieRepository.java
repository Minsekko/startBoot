package org.codenova.start.repository;

import lombok.AllArgsConstructor;
import org.codenova.start.entity.Movie;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MovieRepository {
    private SqlSessionTemplate sqlSession;

    public List<Movie> findAll() {
        return sqlSession.selectList("movie.findAll");
    }
}
