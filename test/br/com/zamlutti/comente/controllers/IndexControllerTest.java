package br.com.zamlutti.comente.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.vraptor.Result;
import br.com.zamlutti.comente.utils.Urlizer;

public class IndexControllerTest {

    private IndexController controller;
    private Result resultMock;
    private Urlizer urlizerMock;
    private CommentsController commentsControllerMock;

    @Before
    public void setUp() throws Exception {
        // Mock comments controller
        this.commentsControllerMock = Mockito.mock(CommentsController.class);

        // Mock result
        this.resultMock = Mockito.mock(Result.class);
        Mockito.when(this.resultMock.redirectTo(CommentsController.class))
                .thenReturn(this.commentsControllerMock);

        // Mock urlizer
        this.urlizerMock = Mockito.mock(Urlizer.class);
        Mockito.when(
                this.urlizerMock.urlize(Mockito.anyString(), Mockito.anyChar()))
                .thenReturn("urlized-string");

        this.controller = new IndexController(this.resultMock, this.urlizerMock);
    }

    @Test
    public void shouldCallUrlizerWhenAddingEntry() {
        String title = "Métodos Ágeis";
        this.controller.add(title);
        Mockito.verify(this.urlizerMock, Mockito.times(1)).urlize(title, '-');
    }

    @Test
    public void shouldRedirectToCommentsControllerWhenAddingEntry() {
        String title = "Métodos Ágeis";
        this.controller.add(title);
        Mockito.verify(this.resultMock, Mockito.times(1)).redirectTo(
                CommentsController.class);
    }

    @Test
    public void shouldRedirectToCommentsControllerAddActionWhenAddingEntry() {
        String title = "Métodos Ágeis";
        this.controller.add(title);
        Mockito.verify(this.commentsControllerMock, Mockito.times(1)).add(
                "urlized-string");
    }
}
