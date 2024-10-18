package org.example.library.service;

import org.example.library.dto.BookListData;
import org.example.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBookList {
    @Autowired
    private BookListData bookListData;

    public List<Book> getList() {
        List<Book> books = bookListData.getList();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getStatus() == 1) {
                books.get(i).setStatusCN("允许借阅");
            } else {
                books.get(i).setStatusCN("不允许借阅");
            }
        }
        return books;
    }
}
