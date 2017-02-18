package uk.co.gumtree.addressbook.service;


import org.junit.Before;
import org.junit.Test;

public class InputReaderTest {
    private InputReader underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new InputReader();
    }

    @Test
    public void itShouldReadInputFile() {
        String filePath = getClass().getResource("/addressBookValid").getPath();
        underTest.read(filePath);
    }

}