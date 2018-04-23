package cuc.waimai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(HttpSession session){
        session.setAttribute("flag","off");
        return "index";
    }
    @RequestMapping("/shopReg")
    public String shopReg(){
        return "shopReg";
    }
    @RequestMapping("/shopLogin")
    public String shopLogin(){
        return "shopLogin";
    }
    @RequestMapping("/session")
    public String session(HttpSession session){
        System.out.println(session.getAttribute("flag"));
        if(session.getAttribute("flag").equals("off")){
            return "index";
        }else {
            return "session";
        }
    }
   @RequestMapping("/main")
   public  String main(){
        return "main";
   }
    @RequestMapping("/order")
    public String order(){
        return "order";
    }
    @RequestMapping("/orderdetail")
    public String orderdetail(){
        return "orderdetail";
    }
    @RequestMapping("/workdesk")
    public String workdesk(){
        return "workdesk";
    }
    @RequestMapping("/shop")
    public String shop(){
        return "shop";
    }
}
