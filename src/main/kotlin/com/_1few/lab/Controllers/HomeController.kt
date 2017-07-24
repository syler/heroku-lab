package com._1few.lab.Controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class HomeController {

    @RequestMapping("/")
    fun index(model: Model): String {
        model.addAttribute("domain", "1few.com")
        return "index"
    }
}