package com.vimemacs.spitter;

import com.vimemacs.spitter.domain.Spittle;
import com.vimemacs.spitter.mvc.HomeController;
import com.vimemacs.spitter.service.SpitterService;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static com.vimemacs.spitter.mvc.HomeController.*;
import static java.util.Arrays.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by HWD on 2017/6/19.
 */
public class HomeControllerTest {
    @Test
    public void shouldDisplayRecentSpittles() {
        List<Spittle> expectedSpittles = asList(new Spittle(), new Spittle(), new Spittle());

        SpitterService spitterService = mock(SpitterService.class);

        when(spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE)).thenReturn(expectedSpittles);
        HomeController controller = new HomeController(spitterService);
        HashMap<String, Object> model = new HashMap<String, Object>();
        String viewName = controller.showHomePage(model);

        assertEquals("home", viewName);

        assertSame(expectedSpittles, model.get("spittles"));
        verify(spitterService).getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE);
    }
}
