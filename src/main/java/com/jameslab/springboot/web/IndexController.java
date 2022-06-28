package com.jameslab.springboot.web;

import com.jameslab.springboot.config.auth.LoginUser;
import com.jameslab.springboot.config.auth.dto.SessionUser;
import com.jameslab.springboot.service.posts.PostsService;
import com.jameslab.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model , @LoginUser SessionUser user)
    {
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null)
        {
            model.addAttribute("userName" , user.getName());
        }

        return "index";
    }
    /*
     * 게시글 추가
     */
    @GetMapping("/posts/save")
    public String postsSave(Model model , @LoginUser SessionUser user)

    {
        if(user != null)
        {
            model.addAttribute("userName" , user.getName());
        }

        return "posts-save";
    }

    /*
     * 게시글 수정
     */
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id , Model model)
    {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post" , dto);

        return "posts-update";
    }

}
