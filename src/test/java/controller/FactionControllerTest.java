package controller;

import enums.Card.FactionsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactionControllerTest {

    private FactionController factionController;

    @BeforeEach
    public void setUp() {
        factionController = new FactionController();
    }

    @Test
    public void testGetFaction_Monsters() {
        FactionsEnum result = factionController.getFaction("monstersCard");
        assertNotNull(result);
        assertEquals(FactionsEnum.MONSTERS, result);
    }

    @Test
    public void testGetFaction_Nilfgaard() {
        FactionsEnum result = factionController.getFaction("nilfgaardCard");
        assertNotNull(result);
        assertEquals(FactionsEnum.NILFGAARD, result);
    }

    @Test
    public void testGetFaction_NorthernRealms() {
        FactionsEnum result = factionController.getFaction("realmsCard");
        assertNotNull(result);
        assertEquals(FactionsEnum.NORTHERN_REALMS, result);
    }

    @Test
    public void testGetFaction_Scoiatael() {
        FactionsEnum result = factionController.getFaction("scoiataelCard");
        assertNotNull(result);
        assertEquals(FactionsEnum.SCOIATAEL, result);
    }

    @Test
    public void testGetFaction_Skellige() {
        FactionsEnum result = factionController.getFaction("skelligeCard");
        assertNotNull(result);
        assertEquals(FactionsEnum.SKELLIGE, result);
    }

    @Test
    public void testGetFaction_InvalidId() {
        FactionsEnum result = factionController.getFaction("invalidCard");
        assertNull(result);
    }

    @Test
    public void testGetFaction_EmptyId() {
        FactionsEnum result = factionController.getFaction("");
        assertNull(result);
    }

    @Test
    public void testGetFaction_NullId() {
        FactionsEnum result = factionController.getFaction(null);
        assertNull(result);
    }
}
