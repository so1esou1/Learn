package com.csu.controller;
/*
restful风格
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestfulController {
    //原来的 : http://localhost:8080/add?a=1&b=2
    //restful风格 : http://localhost:8080/add/a/b

    /*@RequestMapping("/add")
    public String test1(int a, int b, Model model){
        int res = a + b;
        model.addAttribute("msg","结果为" + res);

        return "test";
    }*/

    /*@RequestMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a,@PathVariable int b, Model model){     //@PathVariable注解可以让方法参数的值直接绑定到一个URL模板变量上
        int res = a + b;
        model.addAttribute("msg","结果为" + res);

        return "test";
    }
    //地址栏输入http://localhost:8080/springMVC_05_controller_war_exploded/add/1/2
    //页面会得出3的值
     */

    //@RequestMapping(value="/add/{a}/{b}",method= RequestMethod.DELETE )
    //@RequestMapping(value="/add/{a}/{b}",method= RequestMethod.GET ) 或精简成:
    @GetMapping("/add/{a}/{b}")
    @DeleteMapping("/add/{a}/{b}")
    @PostMapping("/add/{a}/{b}")
    @PutMapping("")
    public String test1(@PathVariable int a,@PathVariable int b, Model model){     //@PathVariable注解可以让方法参数的值直接绑定到一个URL模板变量上
        int res = a + b;
        model.addAttribute("msg","结果为" + res);

        return "test";
    }
}
