package ClientServer.MessageClasses;

public enum ClientMessageType {
    signup,
    login,
    forgetPassword,
    logout,
    changeUsername,
    changeNickname,
    changePassword,
    changeEmail,
    requestFriend,
    acceptFriend,
    requestGame,
    acceptGame,
    preGame,
    veto,
    skipTurn,
    moveCard,
    endGame,
    getUser,
    sendMessageToPlayer,
}
