import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class RequestSenderTest {

    @Mock
    private Connection connection;

    @InjectMocks
    private RequestSender sender;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void sendRequestOuter_withException_exceptionPoint() {
// return value
//        when(connection.sendRequest(anyString()))
//                .thenThrow(new RuntimeException("Test"));


        doThrow(new RuntimeException("Test"))
                .when(connection)
                .sendRequest(anyString());


        sender.sendRequestOuter();

        assertEquals("Exception Point", outContent.toString());
    }

    @Test
    public void sendRequestOuter_withoutException_testTest() {
        sender.sendRequestOuter();

        assertEquals("Test Test\n", outContent.toString());
    }


    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

}