package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jeannie on 5/2/17.
 */
@Controller
@RequestMapping(value = "todo")
public class TodoController {

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title","To-do List");
        return "todo/index";
    }

    @RequestMapping(value = "about")
    public String about(Model model) {
        model.addAttribute("title", "About");
        return "todo/about";
    }

    @RequestMapping(value = "add")
    public String add(Model model) {
        model.addAttribute("title", "Add Task");
        return "todo/add";
    }
}
