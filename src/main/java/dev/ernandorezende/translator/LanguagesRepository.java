package dev.ernandorezende.translator;

public class LanguagesRepository {
    private final String[] languages = {
            "en| English",
            "es| Spanish",
            "zh| Mandarin Chinese",
            "hi| Hindi",
            "ar| Arabic",
            "bn| Bengali",
            "ru| Russian",
            "pt| Portuguese",
            "ja| Japanese",
            "de| German",
            "fr| French",
            "ms| Malay",
            "sw| Swahili",
            "ko| Korean",
            "it| Italian",
            "he| Hebrew",
            "el| Greek",
            "la| Latin"
    };

    public String [] getLanguages() {
        return this.languages;
    }
}
