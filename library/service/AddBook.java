package org.example.library.service;

import org.example.library.dto.BookListData;
import org.example.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AddBook {
    @Autowired
    private BookListData bookListData;

    public boolean addBook(Book book) {
        if (book == null || !StringUtils.hasLength(book.getBookName()) || !StringUtils.hasLength(book.getAuthor()) ||
                book.getCount() == null || book.getPrice() == null || !StringUtils.hasLength(book.getPublish())
                || book.getStatus() == null) {
            return false;
            //信息为空返回false;
        }
        List<Book> books = bookListData.getList();
        book.setId(books.size() + 1);
        if (book.getStatus() == 1) {
            book.setStatusCN("可以借阅");
        } else {
            book.setStatusCN("不可借阅");
        }
        books.add(book);
        return true;
    }
}
