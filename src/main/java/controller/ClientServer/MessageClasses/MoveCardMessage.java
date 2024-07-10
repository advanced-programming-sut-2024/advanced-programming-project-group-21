package controller.ClientServer.MessageClasses;

public class MoveCardMessage extends ClientMessage{
    private int cardIndex;
    private int fromRowNum; // 0 for hand,
    // 1 for close, 2 for close special,
    // 3 for range, 4 for range special,
    // 5 for siege, 6 for siege special,
    // 7 for discardPile
    private int toRowNum; // ... same as above

    public MoveCardMessage(int cardIndex, int fromRowNum, int toRowNum) {
        this.type = ClientMessageType.moveCard;
        this.cardIndex = cardIndex;
        this.fromRowNum = fromRowNum;
        this.toRowNum = toRowNum;
    }


    public int getCardIndex() {
        return cardIndex;
    }

    public int getFromRowNum() {
        return fromRowNum;
    }

    public int getToRowNum() {
        return toRowNum;
    }

}
