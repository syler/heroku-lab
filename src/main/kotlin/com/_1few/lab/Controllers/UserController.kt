package com._1few.lab.Controllers

import com._1few.lab.EmployeeRepository
import com._1few.lab.Model.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/users")
class UserController {
    @Autowired
    lateinit var repo: EmployeeRepository

    @RequestMapping("")
    fun index(model: Model): String {
        val employees = repo.findAll().toMutableList()
        if (employees.count() == 0) {
            val zxc = Employee(id = 1, firstName = "zhou", lastName = "xing xing")
            repo.save(zxc)
            employees.add(zxc)
        }
        model.addAttribute("users", employees)
        return "users/index"
    }

    @GetMapping("get/{id}")
    fun getbyId(model: Model, @PathVariable("id") id: Long): String {
        val employee = repo.findOne(id)
        model.addAttribute("user", employee)
        return "users/detail"
    }
}