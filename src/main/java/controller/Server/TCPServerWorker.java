package controller.Server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.Server.Messages.ServerMessages;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class TCPServerWorker extends Thread {
    private static ServerSocket server;
    private static Gson gsonAgent;

    private static int WORKERS;

    private static ArrayList<Socket> connections;

    private DataOutputStream sendBuffer;
    private DataInputStream receiveBuffer;

    public TCPServerWorker() {
        GsonBuilder builder = new GsonBuilder();
        gsonAgent = builder.create();
    }

    private static boolean setupServer(int portNumber, int workerNum) {
        try {
            server = new ServerSocket(portNumber);
            connections = new ArrayList<>();
            WORKERS = workerNum;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
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

    @Override
    public void run() {
        Socket socket;
        while (true) {
            socket = null;
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

    private String generateNewToken() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 256; i++)
            sb.append((char) (random.nextInt(128)));
        return sb.toString();
    }

    private boolean sendFailure(String problem) {
        return sendMessage(false, problem);
    }

    private boolean sendSuccess(String info) {
        return sendMessage(true, info);
    }

    private boolean sendMessage(boolean success, String problem) {
        ServerMessages failureMessage = new ServerMessages(success, problem);
        String failureString = gsonAgent.toJson(failureMessage);
        try {
            sendBuffer.writeUTF(failureString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void handleConnection(Socket socket) {
        String clientRequest;
    }

    public static void main(String[] args) {
        try {
            TCPServerWorker.setupServer(5000, 10);
            for (int i = 0; i < WORKERS; i++) {
                new TCPServerWorker().start();
            }
            new TCPServerWorker().listen();
        } catch (Exception e) {
            System.out.println("Server encountered a problem!");
            e.printStackTrace();
        }
    }
}
