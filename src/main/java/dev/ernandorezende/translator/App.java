package dev.ernandorezende.translator;

public class App {

	private void initialize() {
        Translator translator = new Translator();
        LanguagesRepository languagesRepository = new LanguagesRepository();
		new Frame(translator, languagesRepository.getLanguages());

	}

    public static void main(String[] args) {
    	App app = new App();
    	app.initialize();
    }
}
