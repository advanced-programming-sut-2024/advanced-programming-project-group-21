package controller;

import enums.Card.CardEnum;
import enums.Card.FactionsEnum;
import model.Card;
import model.Game;
import model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

public class GameMenuControllerTest {

    private GameMenuController gameMenuController;
    private Player mockPlayer1;
    private Player mockPlayer2;
    private Game mockGame;

    @BeforeEach
    public void setUp() {
        gameMenuController = new GameMenuController();
        mockPlayer1 = mock(Player.class);
        mockPlayer2 = mock(Player.class);
        mockGame = mock(Game.class);
    }

    @Test
    public void testShuffleDeckCards() {
        ArrayList<Card> originalDeck = new ArrayList<>();
        for (CardEnum cardEnum : CardEnum.values()) {
            originalDeck.add(new Card(cardEnum));
        }
        when(mockPlayer1.getDeck()).thenReturn(new ArrayList<>(originalDeck));

        gameMenuController.shuffleDeckCards(mockPlayer1);

        verify(mockPlayer1, atLeastOnce()).setDeck(originalDeck);

        List<Card> shuffledDeck = mockPlayer1.getDeck();
        assertNotEquals(originalDeck, shuffledDeck);
    }

    @Test
    public void testSetCurrentPlayer() {
        when(mockGame.getPlayer1()).thenReturn(mockPlayer1);
        when(mockGame.getPlayer2()).thenReturn(mockPlayer2);
        FactionsEnum mockFaction1 = mock(FactionsEnum.class);
        FactionsEnum mockFaction2 = mock(FactionsEnum.class);
        when(mockPlayer1.getCurrentFaction()).thenReturn(mockFaction1);
        when(mockPlayer2.getCurrentFaction()).thenReturn(mockFaction2);

        try (MockedStatic<Math> mockedMath = mockStatic(Math.class)) {
            mockedMath.when(Math::random).thenReturn(0.3);
            gameMenuController.setCurrentPlayer();
            verify(mockGame).setCurrentPlayer(mockPlayer1);
            verify(mockGame).setEnemyPlayer(mockPlayer2);

            mockedMath.when(Math::random).thenReturn(0.7);
            gameMenuController.setCurrentPlayer();
            verify(mockGame).setCurrentPlayer(mockPlayer2);
            verify(mockGame).setEnemyPlayer(mockPlayer1);
        }

        verify(mockFaction1, atLeastOnce()).doAbility(mockPlayer1);
        verify(mockFaction2, atLeastOnce()).doAbility(mockPlayer2);
    }
}
