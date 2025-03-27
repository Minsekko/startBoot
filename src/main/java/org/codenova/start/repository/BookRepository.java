package org.codenova.start.repository;


import org.apache.ibatis.annotations.Mapper;
import org.codenova.start.entity.Book;

import java.util.List;

@Mapper
public interface BookRepository {
    public List<Book> findAll();
    public int create(Book book);
}
