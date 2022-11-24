package prohvataeva.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import prohvataeva.springsecurity.service.MyService;

@RestController
public class MyController {

    final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Привет всем-всем просто кто зашел на нашу страницу";
    }

    @GetMapping("/employees")
    public String showEmployees() {
        return "Привет всем сотрудникам";
    }
    @GetMapping("/employees/economist")
    public String showEmployeesHR() {
        return "Привет исключительно сотрудникам отдела экономики. Посторонним вход запрещён";
    }
    @GetMapping("/employees/sales")
    public String showEmployeesSales() {
        return "Привет исключительно сотрудникам отдела продаж. Посторонним вход запрещён";
    }




}
