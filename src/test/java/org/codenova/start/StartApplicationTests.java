package org.codenova.start;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codenova.start.entity.Book;
import org.codenova.start.model.Pokemon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StartApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() throws JsonProcessingException {
        Book one = Book.builder().title("혼자 공부하는 SQL").author("우재님").publisher("한빛미디어").build();

        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(one);
        System.out.println(str);

        Pokemon recover = objectMapper.readValue(str, Pokemon.class);
        System.out.println(recover.getName());
    }

}
