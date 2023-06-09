package com.bookstore.web.ui.controller.user;

import com.bookstore.model.dto.Book;
import com.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
class CategoryController {

    private static final int PAGE_SIZE = 5;

    private final BookService bookService;

    @GetMapping("/category")
    public String get(@RequestParam Long id, @RequestParam Integer page, Model model) {
        List<Book> books = bookService.findAllByCategoryId(id, PageRequest.of(page - 1, PAGE_SIZE));

        long booksTotalNumber = bookService.countByCategoryId(id);
        long pagesNumber = (int) Math.ceil(booksTotalNumber * 1.0 / PAGE_SIZE);

        model.addAttribute("categoryId", id);
        model.addAttribute("books", books);
        model.addAttribute("currentPage", page);
        model.addAttribute("pagesNumber", pagesNumber);

        return "user/category";
    }

}
