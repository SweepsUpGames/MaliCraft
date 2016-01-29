package com.nothingatall.malicraft.core;

/**
 * Different factions that a list/model/upgrade can be
 * Created by nothingatall on 1/26/2016.
 */
public enum Faction {
    GUILD("Guild"),
    RESURRECTIONIST("Resurrectionist"),
    ARCANIST("Arcanist"),
    NEVERBORN("Neverborn"),
    OUTCAST("Outcast"),
    GREMLIN("Gremlin"),
    TEN_THUNDER("Ten Thunders"),
    UNKNOWN("Select Faction");

    private final String mName;

    Faction(String name) {
        mName = name;
    }

    @Override
    public String toString() {
        return mName;
    }
}
