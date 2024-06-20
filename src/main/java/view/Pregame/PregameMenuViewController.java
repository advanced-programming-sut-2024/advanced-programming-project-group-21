package view.Pregame;

import enums.Card.CardEnum;
import enums.Card.Factions;
import model.Card;

public class PregameMenuViewController {
    public void initialize(){

    }

    private void loadPreGameCards(Factions faction){
        // search in CardEnum for faction
        for(CardEnum cardEnum : CardEnum.values()){
            if(cardEnum.getFaction().equals(faction)){
                for(int i = 0; i < cardEnum.getPreGameCount(); i++){
                    Card card = new Card(cardEnum);
                    addCardToPreGameCards(card);
                }
            }
        }
    }

    private void addCardToPreGameCards(Card card){
        // add card to pregame list
    }
}
