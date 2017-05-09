package org.launchcode.controllers;

import org.launchcode.models.Task;
import org.launchcode.models.data.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jeannie on 5/2/17.
 */
@Controller
@RequestMapping(value = "todo")
public class TodoController {


    @Autowired
    private TaskDao taskDao;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title","Current Tasks");
        model.addAttribute("tasks", taskDao.findAll());
        return "todo/index";
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String index(@RequestParam int[] taskIds, Model model) {
        for (int taskId : taskIds) {
            taskDao.delete(taskId);
        }

        model.addAttribute("title","Current Tasks");
        model.addAttribute("tasks",taskDao.findAll());
        return "todo/index";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Task");
        model.addAttribute("task", new Task());
        return "todo/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute Task task, Model model) {
        taskDao.save(task);
        return "redirect:";
    }


    @RequestMapping(value = "about")
    public String about(Model model) {
        model.addAttribute("title", "About");
        return "todo/about";
    }

}
