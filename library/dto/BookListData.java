package org.example.library.dto;

import org.example.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class BookListData {

    private List<Book> books = new ArrayList<>();


    public List<Book> initList() {

        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setId(i + 1);
            book.setBookName("大秦帝国" + (i + 1) + "册");
            book.setAuthor("作者" + (i + 1));
            book.setCount(i + 1);
            book.setPrice(BigDecimal.valueOf(new Random().nextDouble(10, 100)));
            book.setPublish("出版社" + (i + 1));
            book.setStatus(i % 2);
            books.add(book);
        }
        return books;
    }

    public List<Book> getList() {
        if (books.isEmpty()) {
            initList();
        }
        return books;
    }
}
