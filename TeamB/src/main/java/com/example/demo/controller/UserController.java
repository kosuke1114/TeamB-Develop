package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.BookRequest;
import com.example.demo.dto.UserRequest;
import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.service.BookService;
//import com.example.demo.service.BookService;
import com.example.demo.service.UserService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {

    /**
     * ユーザー情報 Service
     */
    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    /**
     * ユーザー情報一覧画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String displayList(Model model) {
        List<User> userlist = userService.searchAll();
        model.addAttribute("userlist", userlist);
        return "user/list";
    }

    /**
     * ユーザー新規登録画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String displayAdd(Model model) {
        model.addAttribute("userRequest", new UserRequest());
        return "user/add";
    }

    /**
     * ユーザー新規登録
     * @param userRequest リクエストデータ
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String create(@ModelAttribute UserRequest userRequest, Model model) {
        // ユーザー情報の登録
        userService.create(userRequest);
        return "redirect:/user/list";
    }


    /**
     * ユーザー情報削除
     * @param id 表示するユーザーID
     * @param model Model
     * @return ユーザー情報詳細画面
     */
    @GetMapping("/user/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
      // ユーザー情報の削除
      userService.delete(id);
      return "redirect:/user/list";
    }


    /**
     * ユーザー情報詳細画面を表示
     * @param id 表示するユーザーID
     * @param model Model
     * @return ユーザー情報詳細画面
     */
    @GetMapping("/user/{id}")
    public String displayView(@PathVariable Long id, Model model) {
      User user = userService.findById(id);
      model.addAttribute("userData", user);
      return "user/view";
    }



//
//    ここから本の情報

    /**
     * ユーザー情報一覧画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @RequestMapping(value = "/book/list", method = RequestMethod.GET)
    public String displayBookList(Model model) {
        List<Book> booklist = bookService.searchAll();
        model.addAttribute("booklist", booklist);
        return "user/booklist";
    }


    /**
     * ユーザー新規登録画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @RequestMapping(value = "/book/add", method = RequestMethod.GET)
    public String displayBookAdd(Model model) {
       model.addAttribute("bookRequest", new BookRequest());
        return "user/bookadd";
    }


    /**
     * ユーザー新規登録
     * @param userRequest リクエストデータ
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @RequestMapping(value = "/book/create", method = RequestMethod.POST)
    public String createBook(@ModelAttribute BookRequest bookRequest, Model model) {
        // ユーザー情報の登録
        bookService.createBook(bookRequest);
        return "redirect:/book/list";
    }



}