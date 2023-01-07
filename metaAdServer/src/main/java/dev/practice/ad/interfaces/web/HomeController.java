package dev.practice.ad.interfaces.web;

import dev.practice.ad.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    private final HttpSession httpSession;

    @GetMapping
    public String viewHome(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) model.addAttribute("userName", user.getName());
        return "home";
    }


    @RequestMapping("/error-page/404")
    public String errorPage404(Model model) {
        return "user/404";
    }
    @RequestMapping("/error-page/500")
    public String errorPage500(Model model) {
        return "user/500";
    }
}
