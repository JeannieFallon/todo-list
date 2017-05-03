package org.launchcode.controllers;

import org.launchcode.models.Task;
import org.launchcode.models.data.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jeannie on 5/2/17.
 */
@Controller
@RequestMapping(value = "todo")
public class TodoController {


    @Autowired
    private TaskDao taskDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        // object manually created to test database
        Task task = new Task("Algorithm practice",
                "complete 3 HackerRank problems");
        taskDao.save(task);

        model.addAttribute("title","Current Tasks");
        model.addAttribute("tasks", taskDao.findAll());
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
