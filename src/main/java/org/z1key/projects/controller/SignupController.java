package org.z1key.projects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.z1key.projects.entity.Reader;
import org.z1key.projects.entity.User;
import org.z1key.projects.repository.UserRepository;
import org.z1key.projects.service.person.ReaderService;
import org.z1key.projects.service.person.UserService;
import org.z1key.projects.util.AjaxUtils;
import org.z1key.projects.util.MessageHelper;
import org.z1key.projects.validate.SignupForm;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 07.04.2017.
 */
@Controller
public class SignupController {

    private static final String SIGNUP_VIEW_NAME = "signup";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "signup")
    public String signup(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {
        model.addAttribute(new SignupForm());
        if (AjaxUtils.isAjaxRequest(requestedWith)) {
            return SIGNUP_VIEW_NAME.concat(" :: signupForm");
        }
        return SIGNUP_VIEW_NAME;
    }

    @ModelAttribute("page")
    public String module() {
        return "signup";
    }


    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
        if (errors.hasErrors()) {
            return SIGNUP_VIEW_NAME;
        }
        User user = userRepository.save(signupForm.createAccount());
        userService.signin(user);

        MessageHelper.addSuccessAttribute(ra, "signup.success");
        return "redirect:/";
    }
}
