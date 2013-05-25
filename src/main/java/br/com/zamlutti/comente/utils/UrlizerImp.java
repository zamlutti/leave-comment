package main.java.br.com.zamlutti.comente.utils;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class UrlizerImp implements Urlizer {
    @Override
    public String urlize(String text, char separator) {
        String urlizedText = text.toLowerCase();
        urlizedText = this.removeAccents(urlizedText);
        urlizedText = this.removeSpecialChars(urlizedText);
        return urlizedText.replace(' ', separator);
    }

    private String removeSpecialChars(String text) {
        return text.replaceAll("[^a-z0-9\\s]", "");
    }

    private String removeAccents(String text) {
        return text.replaceAll("[áäàãâ]", "a").replaceAll("[éëèê]", "e")
                .replaceAll("[íïìî]", "i").replaceAll("[óöòõô]", "o")
                .replaceAll("[úüùû]", "u").replace('ç', 'c').replace('ñ', 'n');
    }

}
