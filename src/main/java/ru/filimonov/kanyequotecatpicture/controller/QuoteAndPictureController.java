package ru.filimonov.kanyequotecatpicture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.filimonov.kanyequotecatpicture.model.QuoteAndPicture;
import ru.filimonov.kanyequotecatpicture.service.QuoteAndPictureService;

@Validated
@RestController
@RequiredArgsConstructor
public class QuoteAndPictureController {
    final QuoteAndPictureService service;

    @GetMapping("/*")
    public ResponseEntity<QuoteAndPicture> getQuoteAndPicture() {
        return ResponseEntity.ok(service.getQuoteAndPicture());
    }

}
