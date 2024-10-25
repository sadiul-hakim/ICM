package xyz.sadiulhakim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.sadiulhakim.data.DataRepository;
import xyz.sadiulhakim.data.Transaction;
import xyz.sadiulhakim.data.TransactionType;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
public class PageController {
    private final DataRepository dataRepository;

    public PageController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("data", dataRepository.getData());

        return "index";
    }

    @PostMapping("/add")
    public String save(
            @RequestParam String type,
            @RequestParam double amount,
            @RequestParam String description,
            Model model) {

        dataRepository.add(new Transaction(UUID.randomUUID().toString(), TransactionType.valueOf(type), amount, description.trim(), LocalDateTime.now()));
        model.addAttribute("data", dataRepository.getData());

        return "redirect:/";
    }

    @PostMapping("/change-password")
    public String changePassword(
            @RequestParam String currentPassword,
            @RequestParam String newPassword,
            Model model) {

        dataRepository.changePassword(currentPassword.trim(), newPassword.trim());
        model.addAttribute("data", dataRepository.getData());

        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clear(Model model) {
        dataRepository.clear();
        model.addAttribute("data", dataRepository.getData());

        return "redirect:/";
    }
}
