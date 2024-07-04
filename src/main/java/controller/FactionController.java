package controller;

import enums.Card.FactionsEnum;
import model.Player;

public class FactionController {
    public FactionsEnum getFaction(String factionId){
        if(factionId.equals("monstersCard")){
            return FactionsEnum.MONSTERS;
        } else if(factionId.equals("nilfgaardCard")){
            return FactionsEnum.NILFGAARD;
        } else if(factionId.equals("realmsCard")){
            return FactionsEnum.NORTHERN_REALMS;
        } else if(factionId.equals("scoiataelCard")){
            return FactionsEnum.SCOIATAEL;
        } else if(factionId.equals("skelligeCard")){
            return FactionsEnum.SKELLIGE;
        } else {
            return null;
        }
    }

}
