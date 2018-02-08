package controllers;

import DB.POJO.BaseCases;
import DB.POJO.UserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.UserService;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class LoginController {
    private static UserService userService = new UserService();
    private static List client=new ArrayList();
    List<BaseCases> listdata1=new ArrayList<>();
    List<BaseCases> listdata2=new ArrayList<>();
    List<BaseCases> listdata3=new ArrayList<>();
    ModelAndView modelAndView=new ModelAndView();


    @ModelAttribute("currentUser")
    public UserLogin populateUser(){
        UserLogin userLogin = new UserLogin(3,2,"forma","avtorizatiom:");
        return userLogin;
    }
    @ModelAttribute("userList")
    public List<UserLogin> populateUserList(){
        List<UserLogin> list = new ArrayList<>();

        return list;
    }
    @RequestMapping(value = "/")
    public String index(){
      return "index";
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
    public String showUserPage(@ModelAttribute("currentUser") UserLogin userLogin,
                               Model model){
         model.addAttribute("use", userLogin);
        return "userLogin";
    }

    @RequestMapping(value ="/userLogin", method =RequestMethod.POST )
    public ModelAndView correctlogin( @RequestParam("nameInput") String name,
                                @RequestParam("ageInput") String password
            , Model model) throws SQLException {

        if (userService.checkAuth(name,password)>0) {

                client.add(userService.checkAuth(name, password));
            System.out.println(name + " " + password);
            System.out.println(client);

            try {
                listdata1=userService.readData((Integer) client.get(0));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            model.addAttribute("nameInput",name);
            model.addAttribute("client1",client);
            model.addAttribute("kkk",listdata1);

            modelAndView.addObject("massive",listdata1);
            modelAndView.setViewName("/mainForm");


            return modelAndView;
        }else {
            model.addAttribute("client","Error login & password");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/mainForm", method = RequestMethod.POST)
    public ModelAndView writingDateDatabase(
                                     @RequestParam("tasks") String name1,
                                      @RequestParam("birthday") String date1,
                                      Model model){

        System.out.println(date1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        long ddd = date.getTime();
        System.out.println(ddd);
        Date ggg = new Date(ddd);
        System.out.println(ggg);
        System.out.println(client.get(0));
          userService.writeData(name1,ddd, (Integer) client.get(0));

        try {
             listdata2=userService.readData((Integer) client.get(0));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        modelAndView.addObject("massive",listdata2);
        modelAndView.setViewName("/mainForm");
       System.out.println( modelAndView);
      //  modelAndView.setViewName("mainForm");
         model.addAttribute("tasks",name1);
          model.addAttribute("birthday",date1);
          model.addAttribute("client1",client);
        System.out.println("new");
        System.out.println( model.addAttribute("kkk",listdata2));

        return modelAndView;
    }

    @RequestMapping(value = "/mainForm", method = RequestMethod.GET)
    public ModelAndView writingDateDatabase2(Model model){

        try {
            listdata3=userService.readData((Integer) client.get(0));
        } catch (SQLException e) {
            e.printStackTrace();
        }
         modelAndView.addObject("massive",listdata3);
        modelAndView.setViewName("/mainForm");
        model.addAttribute("client1",client);
        return modelAndView;
    }
}
