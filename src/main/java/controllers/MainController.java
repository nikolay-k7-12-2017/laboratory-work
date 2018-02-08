package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import services.UserService;

import java.util.Date;
import java.util.Map;


@Controller
public class MainController {
    private static UserService userService = new UserService();

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public ModelAndView showMessage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("message");
        modelAndView.addObject("message", "Hi from MVC!!!");

        return modelAndView;
    }
}
