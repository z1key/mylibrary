package org.z1key.projects.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String index() {
        return "home";
    }

    @ModelAttribute("page")
    public String module() {
        return index();
    }
//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String logout() {
//        return "home";
//    }

}
