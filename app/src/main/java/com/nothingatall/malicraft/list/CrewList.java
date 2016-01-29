package com.nothingatall.malicraft.list;

import com.nothingatall.malicraft.core.Faction;

/**
 * Builder to represent a list in progress that is built for a snapshot
 * <p/>
 * Created by nothingatall on 1/28/2016.
 */
public class CrewList {
    private final String mCrewName;
    private final Faction mCrewFaction;

    private CrewList(String crewName, Faction faction) {
        mCrewName = crewName;
        mCrewFaction = faction;
    }

    public String getCrewName() {
        return mCrewName;
    }

    public Faction getFaction() {
        return mCrewFaction;
    }

    public static class Builder {
        private String mCrewName = "Crew Name";
        private Faction mCrewFaction = Faction.UNKNOWN;

        public Builder crewName(String crewName) {
            mCrewName = crewName;
            return this;
        }

        public Builder faction(Faction faction) {
            mCrewFaction = faction;
            return this;
        }

        public CrewList build() {
            return new CrewList(
                    mCrewName,
                    mCrewFaction
            );
        }
    }
}
