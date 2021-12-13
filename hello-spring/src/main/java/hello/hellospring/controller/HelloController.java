package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping(value = "/hello")
    public void hello(Model model) {
        model.addAttribute("data", "Hello");
    }

    @GetMapping(value = "/hello-mvc")
    public String helloMvc(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "/hello-template";
    }

    @GetMapping(value = "/hello-string")
    @ResponseBody
    public String helloString(@RequestParam String name) {
        return "hello " + name;
    }

    @GetMapping(value = "/hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
