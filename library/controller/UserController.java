package org.example.library.controller;

import org.example.library.model.Book;
import org.example.library.service.AddBook;
import org.example.library.service.GetBookList;
import org.example.library.service.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/login")
@Controller
@CrossOrigin
public class UserController {

    @Autowired
    private Login loginService;

    @Autowired
    private GetBookList getBookListService;
    @Autowired
    private AddBook addBookService;

    @RequestMapping("")
    public String login() {
        return "/login.html";
    }

    @RequestMapping("/check")
    @ResponseBody
    public String check(String userName, String password) {
        return loginService.check(userName, password);
    }

    @RequestMapping("/getList")
    @ResponseBody
    public List<Book> getList() {
        return getBookListService.getList();
    }

    @RequestMapping("/addBook")
    @ResponseBody
    public boolean addBook(@RequestBody Book book) {
        return addBookService.addBook(book);
    }
}

