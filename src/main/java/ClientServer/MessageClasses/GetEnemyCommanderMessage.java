package ClientServer.MessageClasses;

public class GetEnemyCommanderMessage extends ClientMessage{

        public GetEnemyCommanderMessage() {
            this.type = ClientMessageType.getEnemyCommander;
        }
}
