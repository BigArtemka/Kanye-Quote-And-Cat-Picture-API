package ru.filimonov.kanyequotecatpicture.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.filimonov.kanyequotecatpicture.model.Picture;
import ru.filimonov.kanyequotecatpicture.model.Quote;
import ru.filimonov.kanyequotecatpicture.model.QuoteAndPicture;

@Service
public class QuoteAndPictureService {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String IMAGE_API_URL = "https://some-random-api.ml/animal/cat";
    private static final String QUOTE_API_URL = "https://api.kanye.rest/";

    public QuoteAndPicture getQuoteAndPicture() {
        final var picture = restTemplate.getForObject(IMAGE_API_URL, Picture.class);
        final var quote = restTemplate.getForObject(QUOTE_API_URL, Quote.class);
        return new QuoteAndPicture(quote != null ? quote.getQuote() : "", picture != null ? picture.getImage() : "");
    }
}
