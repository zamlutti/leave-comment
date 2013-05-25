package test.unit.br.com.zamlutti.comente.utils;

import static org.junit.Assert.assertEquals;
import main.java.br.com.zamlutti.comente.utils.Urlizer;
import main.java.br.com.zamlutti.comente.utils.UrlizerImp;

import org.junit.Before;
import org.junit.Test;

public class UrlizerTest {

    private Urlizer urlizer;

    @Before
    public void setUp() throws Exception {
        urlizer = new UrlizerImp();
    }

    @Test
    public void shouldConvertTextToLowerCase() {
        String text = "SomeCapitalizedText";
        String urlizedText = urlizer.urlize(text, '-');
        assertEquals("somecapitalizedtext", urlizedText);
    }

    @Test
    public void shouldRemoveAccentsFromText() {
        String text = "áÄãàâéëèêíìïîóöôõòúüùûçñ";
        String urlizedText = urlizer.urlize(text, '-');
        assertEquals("aaaaaeeeeiiiiooooouuuucn", urlizedText);
    }

    @Test
    public void shouldRemoveSpecialChars() {
        String text = "SomeStringWith!@#$%ˆ&*()_-+={}|\\<>?,./;:";
        String urlizedText = urlizer.urlize(text, '-');
        assertEquals("somestringwith", urlizedText);
    }

    @Test
    public void shouldReplaceSpacesWithSeparatorChar() {
        String text = "Some string with lots of spaces";
        String urlizedText = urlizer.urlize(text, '-');
        assertEquals("some-string-with-lots-of-spaces", urlizedText);
    }

}
