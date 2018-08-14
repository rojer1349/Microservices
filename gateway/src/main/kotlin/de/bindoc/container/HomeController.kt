package de.bindoc.container

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class HomeController(
    private val statefulClient: StatefulClient,
    private val statelessClient: StatelessClient
) {

    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("calculation", statelessClient.getMessage())
        model.addAttribute("state", statefulClient.getState())
        return "home"
    }
}
