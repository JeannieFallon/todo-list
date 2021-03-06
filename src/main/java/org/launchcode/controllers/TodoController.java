package org.launchcode.controllers;

import org.launchcode.models.Task;
import org.launchcode.models.data.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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


    @RequestMapping(value = "", method = RequestMethod.POST, params={"taskIds", "constant"})
    public String index(@RequestParam int[] taskIds, @RequestParam String constant, Model model) {
        for (int taskId : taskIds) {
            taskDao.delete(taskId);
        }
        model.addAttribute("title","Current Tasks");
        model.addAttribute("tasks",taskDao.findAll());
        return "todo/index";
    }

    //Overload index POST method to rerender template with error if no task selected
    @RequestMapping(value = "", method = RequestMethod.POST, params={"constant"})
    public String index(@RequestParam String constant, Model model) {
        model.addAttribute("title","Current Tasks");
        model.addAttribute("tasks",taskDao.findAll());
        model.addAttribute("error", "You must select a task to remove.");
        return "todo/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Task");
        model.addAttribute("task", new Task());
        return "todo/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid Task task, Errors errors, Model model) {

        if(errors.hasErrors()) {
            model.addAttribute("title","Add Task");
            return "todo/add";
        }

        taskDao.save(task);

        return "redirect:";
    }


    @RequestMapping(value = "about")
    public String about(Model model) {
        model.addAttribute("title", "About");
        return "todo/about";
    }

}
