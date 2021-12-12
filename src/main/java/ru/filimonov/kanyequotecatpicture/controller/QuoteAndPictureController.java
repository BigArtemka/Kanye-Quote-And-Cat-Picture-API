package ru.filimonov.kanyequotecatpicture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import ru.filimonov.kanyequotecatpicture.service.QuoteAndPictureService;

@Validated
@Controller
@RequiredArgsConstructor
public class QuoteAndPictureController {
    final QuoteAndPictureService service;

    @GetMapping("/*")
    public String getQuoteAndPicture(Model model) {
        model.addAttribute("quoteandpicture", service.getQuoteAndPicture());
        return "quote-and-picture";
    }

}
