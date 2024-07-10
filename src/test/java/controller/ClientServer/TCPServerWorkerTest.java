package controller.ClientServer;

import ClientServer.Server.TCPServerWorker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

public class TCPServerWorkerTest {

    private TCPServerWorker serverWorker;
    private ServerSocket mockServerSocket;
    private Socket mockSocket;
    private DataOutputStream mockDataOutputStream;
    private DataInputStream mockDataInputStream;

    @BeforeEach
    public void setUp() throws IOException {
        mockServerSocket = mock(ServerSocket.class);
        mockSocket = mock(Socket.class);
        mockDataOutputStream = mock(DataOutputStream.class);
        mockDataInputStream = mock(DataInputStream.class);
        serverWorker = new TCPServerWorker();
    }

    @Test
    public void testSetUpServer() {
        try (MockedStatic<ServerSocket> mockedServerSocket = mockStatic(ServerSocket.class);
             MockedStatic<ArrayList> mockedArrayList = mockStatic(ArrayList.class)) {

            mockedServerSocket.when(() -> new ServerSocket(5000)).thenReturn(mockServerSocket);
            mockedArrayList.when(ArrayList::new).thenReturn(new ArrayList<>());

            assertDoesNotThrow(TCPServerWorker::setUpServer);
        }
    }

    @Test
    public void testRun() {
        ArrayList<Socket> mockConnections = mock(ArrayList.class);

        try (MockedStatic<TCPServerWorker> mockedTCPServerWorker = mockStatic(TCPServerWorker.class)) {
            mockedTCPServerWorker.when(TCPServerWorker::setUpServer).thenAnswer(invocation -> {
                TCPServerWorker.connections = mockConnections;
                return null;
            });

            when(mockConnections.isEmpty()).thenReturn(false).thenReturn(true);
            when(mockConnections.get(0)).thenReturn(mockSocket);

            Thread serverThread = new Thread(serverWorker);
            serverThread.start();

            synchronized (mockConnections) {
                mockConnections.notify();
            }

            serverThread.interrupt();
            verify(mockConnections, atLeastOnce()).remove(0);
        }
    }

    @Test
    public void testHandleConnection() throws IOException {
        when(mockSocket.getInputStream()).thenReturn(mockDataInputStream);
        when(mockSocket.getOutputStream()).thenReturn(mockDataOutputStream);

        assertDoesNotThrow(() -> serverWorker.handleConnection(mockSocket));

        verify(mockSocket).getInputStream();
        verify(mockSocket).getOutputStream();
    }

    @Test
    public void testMain() {
        try (MockedStatic<TCPServerWorker> mockedTCPServerWorker = mockStatic(TCPServerWorker.class)) {
            mockedTCPServerWorker.when(TCPServerWorker::setUpServer).thenAnswer(invocation -> null);
            assertDoesNotThrow(() -> TCPServerWorker.main(new String[]{}));
            mockedTCPServerWorker.verify(TCPServerWorker::setUpServer);
        }
    }
}
