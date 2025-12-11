package org.example.thijavawebservice.Controller;


import org.example.thijavawebservice.Entity.Employee;
import org.example.thijavawebservice.Service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("employees", service.getAll());
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Employee employee) {
        service.add(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("employee", service.findById(id));
        model.addAttribute("employees", service.getAll());
        return "index";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Employee employee) {
        service.update(employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
