package xyz.sadiulhakim.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public String applicationError(ApplicationException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "error";
    }
}
