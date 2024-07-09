package controller.ClientServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPServerWorker extends Thread {
    static ServerSocket server;
    static ArrayList<Socket> connections;

    private DataOutputStream sendBuffer;
    private DataInputStream receiveBuffer;

    static void setUpServer() {
        try {
            server = new ServerSocket(5000);
            connections = new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        Socket socket;
        while (true) {
            synchronized (connections) {
                while (connections.isEmpty()) {
                    try {
                        connections.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                socket = connections.get(0);
                connections.remove(0);
            }
            if (socket != null) {
                handleConnection(socket);
            }
        }
    }

    public void listen() throws IOException {
        Socket socket;
        while (true) {
            socket = server.accept();
            synchronized (connections) {
                connections.add(socket);
                connections.notify();
            }
        }
    }

    void handleConnection(Socket socket) {
        try {
            receiveBuffer = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream())
            );
            sendBuffer = new DataOutputStream(
                    new BufferedOutputStream(socket.getOutputStream())
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            TCPServerWorker.setUpServer();
            for (int i = 0; i < 10; i++) {
                new TCPServerWorker().start();
            }
            new TCPServerWorker().listen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
