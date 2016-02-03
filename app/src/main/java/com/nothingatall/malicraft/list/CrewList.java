package com.nothingatall.malicraft.list;

import android.os.Bundle;

import com.google.common.base.Preconditions;
import com.nothingatall.malicraft.core.Faction;
import com.nothingatall.malicraft.models.Model;

/**
 * Builder to represent a list in progress that is built for a snapshot
 * <p/>
 * Created by nothingatall on 1/28/2016.
 */
public class CrewList {
    private static final String NAME = "crew_name";
    private static final String FACTION = "crew_faction";
    private static final String LEADER = "crew_leader";

    private final String mCrewName;
    private final Faction mCrewFaction;
    private final Model mLeader;

    private CrewList(String crewName, Faction faction, Model leader) {
        mCrewName = crewName;
        mCrewFaction = faction;
        mLeader = leader;
    }

    public String getCrewName() {
        return mCrewName;
    }

    public String getLeader() {
        return mLeader.toString();
    }

    public Faction getFaction() {
        return mCrewFaction;
    }

    public static class Builder {
        private String mCrewName = "Crew Name";
        private Faction mCrewFaction = Faction.UNKNOWN;
        private Model mLeader = Model.UNKNOWN_MODEL;

        public Builder crewName(String crewName) {
            mCrewName = crewName;
            return this;
        }

        public Builder faction(Faction faction) {
            mCrewFaction = faction;
            return this;
        }

        public Builder leader(Model model) {
            mLeader = model;
            return this;
        }

        public CrewList build() {
            return new CrewList(
                    mCrewName,
                    mCrewFaction,
                    mLeader
            );
        }
    }
}
