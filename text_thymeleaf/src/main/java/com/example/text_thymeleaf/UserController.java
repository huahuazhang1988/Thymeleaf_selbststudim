package com.example.text_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tpl")
public class UserController {
    @RequestMapping("/user")
    public String user(Model model){
        model.addAttribute("site","www.baidu.com");
        model.addAttribute("myuser" ,new User("lucy",1,12));
        return "exppression";
    }
    @RequestMapping("/user1")
    public String user1(Model model){
        model.addAttribute("site","www.baidu.com");
        model.addAttribute("myuser" ,new User("huahua",2,12));
        return "exppression1";
    }
    @RequestMapping("/user2")
    public String user2(Model model){
        model.addAttribute("site","www.baidu.com");
        model.addAttribute("myuser" ,new User("fabian",3,12));
        return "exppression2";
    }
    @GetMapping("/link")
    public String link(Model model){
        model.addAttribute("userId",1002);
        return "link";
    }
    @GetMapping("/queryAccount")
    @ResponseBody
    public String queryAccount(Integer id){
        return "queryAccount,id= "+id;

    }
    @GetMapping("/queryUser")
    @ResponseBody
    public String queryAccount(Integer age,String name){
        return "queryUser,age= "+age +"name "+ name;

    }
    @GetMapping("/property")

    public String useProperty(Model model){
        model.addAttribute("methodattr","post");
        model.addAttribute("id","1212");
        model.addAttribute("paramname","name");
        model.addAttribute("uservalue","lisi");
        return "property";
    }
    @RequestMapping("/eachList")
    public String  eachlist(Model model){
        List<User> list  = new ArrayList<>();
        list.add( new User("lisi",1,12));
        list.add( new User("zhangsan",2,22));
        list.add( new User("wangwu",3,32));
        list.add( new User("hua",4,42));
        list.add( new User("ting",5,52));
        list.add( new User("ting",6,62));
        model.addAttribute("myusers",list);
        return "eachList";
    }
    @RequestMapping("/eachArray")
    public String eachArray(Model model){
        User[] userarr= new User[3];
        userarr[0]=new User("lisi",1,12);
        userarr[1]=new User("zhangsan",2,22);
        userarr[2]=new User("wangwu",3,32);
        model.addAttribute("myusers",userarr);
        return "eachArray";

    }
    @RequestMapping("/eachMap")
    public String eachMap(Model model){
        Map<String,User> map= new HashMap<>();
        map.put("user1",new User("lisi",1,12));
        map.put("user2",new User("zhangsan",2,12));
        map.put("user3",new User("wangwu",3,12));
       model.addAttribute("myusers",map);
        return "eachMap";
    }
    @GetMapping("/ifunless")
    public String ifunless(Model model){
        model.addAttribute("sex","m");
        model.addAttribute("isLogin",true);
        model.addAttribute("age",20);
        model.addAttribute("name","");
        model.addAttribute("isOld",null);
        return "ifunless";
    }
    @RequestMapping("/switch")
    public String doswitch(Model model){
        model.addAttribute("sex","m");
        return "switch";


    }
    @RequestMapping("/inline")
    public String inline(Model model){
        model.addAttribute("sex","m");
        model.addAttribute("age",20);
        model.addAttribute("name","lucy");
        model.addAttribute("user",new User("lisi",1,12));
        return "inline";
    }
    @RequestMapping("/baseObject")
    public String baseObject(Model model, HttpServletRequest request, HttpSession session){
        model.addAttribute("myname","huahua");
        request.setAttribute("requestData","data from request");
        request.getSession().setAttribute("sessionDate","data from request session");
        session.setAttribute("loginname","zhangsan");

        return "baseObject";
    }
}
