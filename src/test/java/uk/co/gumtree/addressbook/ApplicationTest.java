package uk.co.gumtree.addressbook;

import org.junit.Test;

import java.io.IOException;

public class ApplicationTest {

    @Test
    public void itShouldReadInputFileAndRunApplication() throws IOException {
        Application.main(getClass().getResource("/addressBookValid").getPath());
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldFailIfInputFileNotGiven() throws IOException {
        Application.main();
    }

}
