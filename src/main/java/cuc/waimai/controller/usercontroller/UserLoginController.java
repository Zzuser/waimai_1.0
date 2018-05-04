package cuc.waimai.controller.usercontroller;

import cuc.waimai.Dao.User;
import cuc.waimai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserLoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/userLogin.do")
    @ResponseBody
    public User userLogin(@RequestParam("userId") String userId,
                         @RequestParam("userPsw")String psw,HttpSession session){
        User user=userService.selectByPrimaryKey(Integer.parseInt(userId));
        System.out.println("ID:"+userId+"PSW:"+psw);
        System.out.println(user.toString());
        System.out.println("pd:"+user.getUserPsd().equals(psw));
        if(user!=null){
            if(user.getUserPsd().equals(psw)){
                session.setAttribute("user",user);
               return user;

            }
            else {
                return null;
            } }
        else {
            return null;
            }
        }
        @RequestMapping("/userLogout.do")
    @ResponseBody
    public void userLogOut(){
    }
}
