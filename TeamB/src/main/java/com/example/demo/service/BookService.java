package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.BookRequest;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class BookService {

	@Autowired
    BookRepository bookRepository;

    /**
     * ユーザー情報 全検索
     * @return 検索結果
     */
    public List<Book> searchAll() {
        return bookRepository.findAll();
    }

    /**
     * ユーザー情報新規登録
     * @param user ユーザー情報
     */
    public void createBook(BookRequest bookRequest) {
        bookRepository.save(CreateBook(bookRequest));
    }

    /**
     * ユーザーTBLエンティティの生成
     * @param userRequest ユーザー情報リクエストデータ
     * @return ユーザーTBLエンティティ
     */
    private Book CreateBook(BookRequest bookRequest) {

        Book book = new Book();
        book.setBookID(bookRequest.getBookID());
        book.setBookName(bookRequest.getBookName());



//
//        user.setName(userRequest.getName());
//        user.setAddress(userRequest.getAddress());
//        user.setPhone(userRequest.getPhone());
//        user.setCreateDate(now);
//        user.setUpdateDate(now);

        return book;

}
}
