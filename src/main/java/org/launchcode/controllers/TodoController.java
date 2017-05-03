package org.launchcode.controllers;

import org.launchcode.models.Task;
import org.launchcode.models.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeannie on 5/2/17.
 */
@Controller
@RequestMapping(value = "todo")
public class TodoController {

    @RequestMapping(value = "")
    public String index(Model model) {
        Task task = new Task("Algorithm practice",
                "complete 3 HackerRank problems", 0);

        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        model.addAttribute("title","To-do List");
        model.addAttribute("tasks", tasks);
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
