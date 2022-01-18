package ru.filimonov.kanyequotecatpicture;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.filimonov.kanyequotecatpicture.service.QuoteAndPictureService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KanyeQuoteCatPictureApplicationTest {

    @Autowired
    QuoteAndPictureService quoteAndPictureService;

    @Test
    void isQuoteAndPictureNotNull() {
        final var result = quoteAndPictureService.getQuoteAndPicture();
        assertNotNull(result);
        assertNotNull(result.getImage());
        assertNotNull(result.getQuote());
    }

    @Test
    void isKanyeQuoteApiWorking() {
        var actualResponseCode = 0;
        try {
            URL url = new URL("https://api.kanye.rest/");
            actualResponseCode = getHttpConnection(url).getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }

        final var expectedResponseCode = 200;
        assertEquals(expectedResponseCode, actualResponseCode);
    }

    @Test
    void isPictureApiWorking() {
        var actualResponseCode = 0;
        try {
            URL url = new URL("https://thatcopy.pw/catapi/rest/");
            actualResponseCode = getHttpConnection(url).getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }

        final var expectedResponseCode = 200;
        assertEquals(expectedResponseCode, actualResponseCode);
    }

    private HttpURLConnection getHttpConnection(URL url) throws IOException {
        var connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        return connection;
    }

}