package com._1few.lab.Controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class HomeController {
    val chapters = arrayOf(
            chapter(chapterLink("/jquery-upload", "jQuery upload sample"),
                    chapterLink("https://1few.com/spring-boot-fileupload-with-jquery/", "使用Spring boot + jQuery上传文件"),
                    chapterLink("https://github.com/syler/heroku-lab/tree/jquery-upload", "源码"))
            , chapter(chapterLink("/users/", "use postgres db"),
            chapterLink("#", "待写"),
            chapterLink("https://github.com/syler/heroku-lab/tree/use-postgres", "源码"))
    )

    @RequestMapping("/")
    fun index(model: Model): String {
        model.addAttribute("domain", "1few.com")
        model.addAttribute("chapters", chapters)
        return "index"
    }
}

class chapterLink(val link: String = "#", val title: String = "")
class chapter(val demo: chapterLink, val article: chapterLink, val source: chapterLink)