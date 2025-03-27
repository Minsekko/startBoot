package org.codenova.start.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.codenova.start.entity.Book;
import org.codenova.start.entity.Movie;
import org.codenova.start.repository.BookRepository;
import org.codenova.start.repository.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mybatis")
//@Builder
//@NoArgsConstructor
@AllArgsConstructor
public class MybatisController {
    private MovieRepository movieRepository;
    private BookRepository bookRepository;

    @GetMapping("/movie")
    public String movieHandle(Model model) {
        //List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movie",movieRepository.findAll());

        return "/mybatis/movie";
    }

    @GetMapping("/book")
    public String bookHandle(Model model) {
        model.addAttribute("books",bookRepository.findAll());

        return "mybatis/book";
    }

    @GetMapping("/mybatis/book-create")
    public String bookCreateHandel(@ModelAttribute Book book) {
        bookRepository.create(book);
        return "redirect:/mybatis/book";
    }

}
