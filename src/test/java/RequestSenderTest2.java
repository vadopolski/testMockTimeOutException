import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class RequestSenderTest2 {
    @Mock
    private Connection connection1;

    @Mock
    private Connection connection2;

    private RequestSender2 sender;

    @Before
    public void setUpStreams() {
        sender = new RequestSender2(connection1, connection2);
    }


    @Test
    public void sendRequestOuter_withException_connection2Used() {
        doThrow(new RuntimeException("Test"))
                .when(connection1)
                .sendRequest(anyString());

        sender.sendRequestOuter();

        verify(connection2).sendRequest(anyString());
    }

    @Test
    public void sendRequestOuter_withoutException_notUsedConnection2() {
        sender.sendRequestOuter();

        verifyZeroInteractions(connection2);
    }
}