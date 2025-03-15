package dev.ernandorezende.translator;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Logger;

public class Translator {

    public static final String BASE_URL = "https://api.mymemory.translated.net/get?q=";
    private final Logger logger = Logger.getLogger("Translator");

    public String translate(String query, String sourceLang, String targetLang) {
        try {
            String encodedQuery = URLEncoder.encode(query, "UTF-8");
            String langPair = sourceLang+"|"+targetLang;
            langPair = URLEncoder.encode(langPair,"UTF-8");
            String apiUrl = BASE_URL + encodedQuery + "&langpair=" + langPair;

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                String jsonResponse = response.toString();
                // Parse the JSON response
                JSONObject object = new JSONObject(jsonResponse);
                JSONObject responseData = object.getJSONObject("responseData");
                String translatedText = responseData.getString("translatedText");

                logger.info("Response Data: {}" + responseData);
                logger.info("Translated Text: " + translatedText);
                connection.disconnect();
                return translatedText;
            } else {
                logger.info("Request failed with response code: " + responseCode);
                connection.disconnect();
                return "Request failed with response code: " +responseCode;
            }

        } catch (IOException e) {
            logger.severe(e.getMessage());

            return e.getMessage();
        }
    }
}
