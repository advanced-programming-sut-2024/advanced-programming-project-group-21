package controller.ClientServer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.ClientServer.MessageClasses.*;
import model.Game;
import model.Player;
import model.User.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class TCPServerWorker extends Thread {
    private static ServerSocket server;
    private static Gson gsonAgent;

    private static final String INTERNAL_ERROR = "internal server error";
    private static final String INVALID_USERNAME = "no user exists with such username";
    private static final String USERNAME_TAKEN = "this username is taken";
    private static final String INVALID_TOKEN = "this token belongs to no user";
    private static final String WRONG_PASSWORD = "wrong password";
    private static final String SAME_EMAIL = "new email is the same as the old one";

    private static ArrayList<Socket> connections;

    private DataOutputStream sendBuffer;
    private DataInputStream receiveBuffer;

    private static void setUpServer() {
        try {
            server = new ServerSocket(5000);
            connections = new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TCPServerWorker() {
        GsonBuilder builder = new GsonBuilder();
        gsonAgent = builder.create();
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

    private ClientMessage extractClientMessage(String clientStr) {
        try {
            ClientMessage clientMessage = gsonAgent.fromJson(clientStr, ClientMessage.class);
            switch (clientMessage.getType()) {
                case acceptFriend:
                    return gsonAgent.fromJson(clientStr, AcceptFriendMessage.class);
                case acceptGame:
                    return gsonAgent.fromJson(clientStr, AcceptGameMessage.class);
                case changeEmail:
                    return gsonAgent.fromJson(clientStr, ChangeEmailMessage.class);
                case changeNickname:
                    return gsonAgent.fromJson(clientStr, ChangeNicknameMessage.class);
                case changePassword:
                    return gsonAgent.fromJson(clientStr, ChangePasswordMessage.class);
                case changeUsername:
                    return gsonAgent.fromJson(clientStr, ChangeUsernameMessage.class);
                case endGame:
                    return gsonAgent.fromJson(clientStr, EndGameMessage.class);
                case forgetPassword:
                    return gsonAgent.fromJson(clientStr, ForgetPasswordMessage.class);
                case login:
                    return gsonAgent.fromJson(clientStr, LoginMessage.class);
                case logout:
                    return gsonAgent.fromJson(clientStr, LogoutMessage.class);
                case moveCard:
                    return gsonAgent.fromJson(clientStr, MoveCardMessage.class);
                case preGame:
                    return gsonAgent.fromJson(clientStr, PreGameMessage.class);
                case requestFriend:
                    return gsonAgent.fromJson(clientStr, RequestFriendMessage.class);
                case requestGame:
                    return gsonAgent.fromJson(clientStr, RequestGameMessage.class);
                case signup:
                    return gsonAgent.fromJson(clientStr, SignupMessage.class);
                case skipTurn:
                    return gsonAgent.fromJson(clientStr, SkipTurnMessage.class);
                case veto:
                    return gsonAgent.fromJson(clientStr, VetoMessage.class);
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
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

    private void handleConnection(Socket socket) {
        String clientRequest;
        try {
            receiveBuffer = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream())
            );
            sendBuffer = new DataOutputStream(
                    new BufferedOutputStream(socket.getOutputStream())
            );

            clientRequest = receiveBuffer.readUTF();
            ClientMessage msg = extractClientMessage(clientRequest);

            doMessageFunctions(msg);
            sendBuffer.close();
            receiveBuffer.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doMessageFunctions(ClientMessage msg) throws IOException {
        if (msg instanceof AcceptFriendMessage) {
            //do something
        } else if (msg instanceof AcceptGameMessage) {
            //do something
        } else if (msg instanceof ChangeEmailMessage) {
            changeEmail((ChangeEmailMessage) msg);
        } else if (msg instanceof ChangeNicknameMessage) {
            //do something
        } else if (msg instanceof ChangePasswordMessage) {
            //do something
        } else if (msg instanceof ChangeUsernameMessage) {
            //do something
        } else if (msg instanceof EndGameMessage) {
            //do something
        } else if (msg instanceof ForgetPasswordMessage) {
            //do something
        } else if (msg instanceof LoginMessage) {
            //do something
        } else if (msg instanceof LogoutMessage) {
            //do something
        } else if (msg instanceof MoveCardMessage) {
            moveCard((MoveCardMessage) msg);
        } else if (msg instanceof PreGameMessage) {
            //do something
        } else if (msg instanceof RequestFriendMessage) {
            //do something
        } else if (msg instanceof RequestGameMessage) {
            //do something
        } else if (msg instanceof SignupMessage) {
            //do something
        } else if (msg instanceof SkipTurnMessage) {
            //do something
        } else if (msg instanceof VetoMessage) {
            //do something
        } else {
            // do something
        }
    }

    private void moveCard(MoveCardMessage msg) {
        String token = msg.getToken();
        User user = User.findUserByToken(token);
        if (user == null) {
            sendFailure(INVALID_TOKEN);
            return;
        }
        Player player = user.getPlayer();
        Game game = player.getGame();
        if (game == null) {
            sendFailure("you are not in a game");
            return;
        }

    }

    private void changeEmail(ChangeEmailMessage msg) {
        String token = msg.getToken();
        String newEmail = msg.getNewEmail();
        User user = User.findUserByToken(token);
        if (user == null) {
            sendFailure(INVALID_TOKEN);
            return;
        }
        if (user.getEmail().equals(newEmail)) {
            sendFailure(SAME_EMAIL);
            return;
        }
        user.setEmail(newEmail);
        sendSuccess("email changed successfully");
    }

    private boolean sendMessage(boolean success, String problem) {
        ServerMessage failureMessage = new ServerMessage(success, problem);
        String failureString = gsonAgent.toJson(failureMessage);
        try {
            sendBuffer.writeUTF(failureString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean sendFailure(String problem) {
        return sendMessage(false, problem);
    }

    private boolean sendSuccess(String info) {
        return sendMessage(true, info);
    }

    private String generateNewToken() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 256; i++)
            sb.append((char) (random.nextInt(128)));
        return sb.toString();
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
