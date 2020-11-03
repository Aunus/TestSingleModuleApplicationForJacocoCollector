package com.wzl.jacoco.controller;

import com.wzl.jacoco.storage.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "rent")
@Slf4j
public class RentController {

    @PostMapping("borrow")
    public String borrowBook(@RequestParam String bookName, @RequestParam String borrower, @RequestParam Integer amount) {
        log.info("borrow~test");
        BookRepository.borrowBook(bookName, borrower, amount);
        return String.format("you borrow book <<{}>> successfully at"
                , bookName, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

}
