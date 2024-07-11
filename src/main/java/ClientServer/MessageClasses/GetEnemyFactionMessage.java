package ClientServer.MessageClasses;

public class GetEnemyFactionMessage extends ClientMessage{

        public GetEnemyFactionMessage() {
            this.type = ClientMessageType.getEnemyFaction;
        }
}
