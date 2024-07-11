package ClientServer.Server;

import ClientServer.Client.TCPClient;
import ClientServer.MessageClasses.*;
import ClientServer.Server.model.GameServer;
import ClientServer.Server.model.Lobby;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.*;
import model.User.User;
import view.Chat.ChatMenuViewController;

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
    private static final String INVALID_SENDER_OR_RECEIVER = "invalid sender or receiver";

    public static ArrayList<Socket> connections;

    private DataOutputStream sendBuffer;
    private DataInputStream receiveBuffer;

    public static void setUpServer() {
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
                case getUser:
                    return gsonAgent.fromJson(clientStr, GetUserMessage.class);
                case getRequestFriend:
                    return gsonAgent.fromJson(clientStr, GetRequestFriendMessages.class);
                case getRequestGame:
                    return gsonAgent.fromJson(clientStr, GetRequestGameMessage.class);
                case findGameServer:
                    return gsonAgent.fromJson(clientStr, FindGameServerMessage.class);
                case canGoToNextPhase:
                    return gsonAgent.fromJson(clientStr, CanGoToNextPhaseMessage.class);
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
                System.out.println("CONNECTION DETECTED");
                connections.add(socket);
                connections.notify();
            }
        }
    }

    public void handleConnection(Socket socket) {
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

            System.out.println("Server received " + clientRequest);

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
            acceptGame((AcceptGameMessage) msg);
        } else if (msg instanceof ChangeEmailMessage) {
            changeEmail((ChangeEmailMessage) msg);
        } else if (msg instanceof ChangeNicknameMessage) {
            changeNickname((ChangeNicknameMessage) msg);
        } else if (msg instanceof ChangePasswordMessage) {
            changePassword((ChangePasswordMessage) msg);
        } else if (msg instanceof ChangeUsernameMessage) {
            changeUsername((ChangeUsernameMessage) msg);
        } else if (msg instanceof EndGameMessage) {
            //do something
        } else if (msg instanceof ForgetPasswordMessage) {
            forgetPassword((ForgetPasswordMessage) msg);
        } else if (msg instanceof LoginMessage) {
            loginUser((LoginMessage) msg);
        } else if (msg instanceof LogoutMessage) {
            logoutUser((LogoutMessage) msg);
        } else if (msg instanceof MoveCardMessage) {
            //moveCard((MoveCardMessage) msg);
        } else if (msg instanceof PreGameMessage) {
            //do something
        } else if (msg instanceof RequestFriendMessage) {
            friendRequest((RequestFriendMessage) msg);
        } else if (msg instanceof RequestGameMessage) {
            requestGame((RequestGameMessage) msg);
        } else if (msg instanceof SignupMessage) {
            signupUser((SignupMessage) msg);
        } else if (msg instanceof SkipTurnMessage) {
            //do something
        } else if (msg instanceof VetoMessage) {
            //do something
        } else if (msg instanceof GetUserMessage) {
            getUser((GetUserMessage) msg);
        } else if (msg instanceof GetRequestFriendMessages) {
        } else if (msg instanceof GetRequestGameMessage) {
            getRequestGame((GetRequestGameMessage) msg);
        } else if (msg instanceof FindGameServerMessage) {
            findGameServer((FindGameServerMessage) msg);
        } else if (msg instanceof CanGoToNextPhaseMessage) {
            canGoToNextPhase((CanGoToNextPhaseMessage) msg);
        } else if (msg instanceof SendMessageToPlayerMessage) {
            sendMessageToPlayer((SendMessageToPlayerMessage) msg);
        } else {
            // do something
        }
    }

    private void sendMessageToPlayer(SendMessageToPlayerMessage msg) {
        User sender = TCPClient.getInstance().getUserFromUsername(ApplicationController.getLoggedInUser().getUsername());
        User receiver = TCPClient.getInstance().getUserFromUsername(msg.getEnemyUsername());
        String receiverToken = receiver.getCurrentToken();
        if (receiverToken == null || receiverToken == null) {
            sendFailure(INVALID_SENDER_OR_RECEIVER);
            return;
        }
        ChatMenuViewController chatMenuViewController = new ChatMenuViewController();
        chatMenuViewController.sendMessage(sender, receiver, msg.getMessage());
    }

    private void friendRequest(RequestFriendMessage msg) {
        String token = msg.getToken();
        User user = User.findUserByToken(token);
        if (user == null) {
            sendFailure("1"); // invalid token
            return;
        }
        User friendUser = User.getUserByUsername(msg.getFriendUsername());
        if (friendUser == null) {
            sendFailure("2"); // no user exists with such username
            return;
        }
        if (user.getFriends().contains(friendUser)) {
            sendFailure("3"); // already friends
            return;
        }
        if (user.getFriendRequests().contains(friendUser)) {
            sendFailure("4"); // already requested
            return;
        }
        friendUser.addToPendingFriendRequests(user);
        sendSuccess("0");
    }

    private void canGoToNextPhase(CanGoToNextPhaseMessage msg) {
        String token = msg.getToken();
        User user = User.findUserByToken(token);
        GameServer gameServer = GameServer.getGame(user.getGameId());
        if (gameServer.getUser1().equals(user)) {
            if (gameServer.getUser2() != null) {
                sendSuccess("true");
                System.out.println("user 1 is: "+gameServer.getUser1().getUsername() + " user 2 is: "+gameServer.getUser2().getUsername());
                return;
            }
            System.out.println("user 1 is: "+gameServer.getUser1().getUsername());

            sendFailure("false");
            return;
        } else if (gameServer.getUser2().equals(user)) {
            System.out.println("user 1 is: "+gameServer.getUser1().getUsername() + " user 2 is: "+gameServer.getUser2().getUsername());

            sendSuccess("true");
            return;
        }
    }

    private void findGameServer(FindGameServerMessage msg) {
        String token = msg.getToken();
        User user = User.findUserByToken(token);
        User enemy = user.getEnemyUser();
        if (GameServer.getGames() != null)
            for (GameServer gameServer : GameServer.getGames().values()) {
                if (gameServer.getUser1().getCurrentToken().equals(enemy.getCurrentToken())) {
                    gameServer.setUser2(user);
                    user.setGameId(gameServer.getId());
                    gameServer.setDeckCards2(msg.getDeckCards());
                    sendSuccess(String.valueOf(gameServer.getId()));
                    return;
                }
            }
        GameServer gameServer = new GameServer();
        gameServer.setUser1(user);
        user.setGameId(gameServer.getId());
        gameServer.setDeckCards1(msg.getDeckCards());
        sendSuccess(String.valueOf(gameServer.getId()));
    }

    private void acceptGame(AcceptGameMessage msg) {
        String token = msg.getToken();
        User user = User.findUserByToken(token);
        if (user == null) {
            sendFailure("1"); // invalid token
            return;
        }
        String requester = msg.getFriendName();
        if (requester == null) {
            sendFailure("2"); // no request exists
            return;
        }
        User enemyUser = User.getUserByUsername(requester);
        if (enemyUser == null) {
            sendFailure("3"); // no user exists with such username
            return;
        }
        if (msg.isAccept()) {
            user.setEnemyUser(enemyUser);
            user.setInGame(true);
            enemyUser.setEnemyUser(user);
            enemyUser.setInGame(true);
        }
        Lobby.getInstance().removeRequest(enemyUser.getUsername());
        sendSuccess("0");
    }

    private void getRequestGame(GetRequestGameMessage msg) {
        String token = msg.getToken();
        User user = User.findUserByToken(token);
        if (user == null) {
            sendFailure("1"); // invalid token
            return;
        }
        String requester = Lobby.getInstance().getRequester(user.getUsername());
        if (requester == null) {
            sendFailure("2"); // no request exists
            return;
        }
        User enemyUser = User.getUserByUsername(requester);
        if (enemyUser == null) {
            sendFailure("3"); // no user exists with such username
            return;
        }
        sendSuccess(enemyUser.getUsername());
    }

    private void getUser(GetUserMessage msg) {
        User user = User.getUserByUsername(msg.getUsername());
        if (user == null) {
            sendFailure(INVALID_USERNAME);
            return;
        }
        sendSuccess(gsonAgent.toJson(user));
    }

    private void requestGame(RequestGameMessage msg) {
        String token = msg.getToken();
        User user = User.findUserByToken(token);
        if (user == null) {
            sendFailure("1"); // invalid token
            return;
        }
        User enemyUser = User.getUserByUsername(msg.getFriendUsername());
        if (enemyUser == null) {
            sendFailure("2"); // no user exists with such username
            return;
        }
        if (enemyUser.isInGame()) {
            sendFailure("3"); // user is in a game
            return;
        }
        Lobby.getInstance().addRequest(user.getUsername(), enemyUser.getUsername());
        sendSuccess("0");
    }

    private void signupUser(SignupMessage msg) {
        int result = (new RegisterMenuController()).register(msg.getNickname(), msg.getUsername(),
                msg.getEmail(), msg.getPassword(), msg.getConfirmPassword(), generateNewToken());

        if (result == 0) {
            sendSuccess("0");
        } else {
            sendFailure(Integer.valueOf(result).toString());
        }
    }

    private void loginUser(LoginMessage msg) {
        DataBaseController.loadUsersFromJson();
        String username = msg.getUsername();
        String password = msg.getPassword();
        int answer = (new LoginMenuController()).loginUser(username, password);
        if (answer == 0) {
            sendSuccess("0");
        } else {
            sendFailure(Integer.valueOf(answer).toString());
        }
    }

    private void logoutUser(LogoutMessage msg) {
        String token = msg.getToken();
        User user = User.findUserByToken(token);
        if (user == null) {
            sendFailure(INVALID_TOKEN);
            return;
        }
        ApplicationController.setLoggedInUser(null);
        sendSuccess("logged out successfully");
    }

    private void forgetPassword(ForgetPasswordMessage msg) {
        int answer = (new QuestionMenuController()).submitAnswer(msg.getUsername(), msg.getQuestion(), msg.getAnswer(), msg.getNewPassword(), msg.getConfirmPassword());
        if (answer == 0) {
            (new QuestionMenuController()).changePassword(msg.getUsername(), msg.getNewPassword());
            sendSuccess("0");
        } else {
            sendFailure(Integer.valueOf(answer).toString());
        }
    }

    private void changeUsername(ChangeUsernameMessage msg) {
        String token = msg.getToken();
        String newUsername = msg.getNewUsername();
        User user = User.findUserByToken(token);
        if (user == null) {
            sendFailure(INVALID_TOKEN);
            return;
        }
        if (User.getUserByUsername(newUsername) != null) {
            sendFailure(USERNAME_TAKEN);
            return;
        }
        user.setUsername(newUsername);
        sendSuccess("username changed successfully");
    }

    private void changePassword(ChangePasswordMessage msg) {
        String token = msg.getToken();
        String newPassword = msg.getNewPassword();
        String oldPassword = msg.getOldPassword();
        User user = User.findUserByToken(token);
        if (user == null) {
            sendFailure(INVALID_TOKEN);
            return;
        }
        if (!user.getPassword().equals(oldPassword)) {
            sendFailure(WRONG_PASSWORD);
            return;
        }
        user.setPassword(newPassword);
        sendSuccess("password changed successfully");
    }

    private void changeNickname(ChangeNicknameMessage msg) {
        String token = msg.getToken();
        String newNickname = msg.getNewNickname();
        User user = User.findUserByToken(token);
        if (user == null) {
            sendFailure(INVALID_TOKEN);
            return;
        }
        user.setNickname(newNickname);
        sendSuccess("nickname changed successfully");
    }

//    private void moveCard(MoveCardMessage msg) {
//        String token = msg.getToken();
//        User user = User.findUserByToken(token);
//        if (user == null) {
//            sendFailure(INVALID_TOKEN);
//            return;
//        }
//        Player player = user.getPlayer();
//        Game game = player.getGame();
//        if (game == null) {
//            sendFailure("you are not in a game");
//            return;
//        }
//
//    }

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
