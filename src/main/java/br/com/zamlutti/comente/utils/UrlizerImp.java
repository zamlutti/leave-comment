package br.com.zamlutti.comente.utils;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class UrlizerImp implements Urlizer {
    public String urlize(String text, char separator) {
        String urlizedText = text.toLowerCase();
        urlizedText = UrlizerImp.removeAccents(urlizedText);
        urlizedText = UrlizerImp.removeSpecialChars(urlizedText);
        return urlizedText.replace(' ', separator);
    }

    private static String removeSpecialChars(String text) {
        return text.replaceAll("[^a-z0-9\\s]", "");
    }

    private static String removeAccents(String text) {
        return text.replaceAll("[áäàãâ]", "a")
                .replaceAll("[éëèê]", "e")
                .replaceAll("[íïìî]", "i")
                .replaceAll("[óöòõô]", "o")
                .replaceAll("[úüùû]", "u")
                .replace('ç', 'c')
                .replace('ñ', 'n');
    }

}
