package com.nothingatall.malicraft.models;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.nothingatall.malicraft.core.Faction;

import java.util.Set;

/**
 * Created by nothingatall on 1/26/2016.
 */
public class Model {
    public enum Level {
        MASTER,
        HENTCHMEN,
        ENFORCER,
        MINION,
        PEON
    }

    public enum Status {
        LIVING,
        UNDEAD,
        CONSTRUCT,
        LOST,
        MERCENARY
    }

    private final String mName;
    private final Iterable<Faction> mFactions;
    private final int mCost;
    private final int mCache;
    private final Level mLevel;
    private final Iterable<Status> mStats;

    private Model(String name, Iterable<Faction> faction, int cost, int cache, Level level, Iterable<Status> stats) {
        mName = name;
        mFactions = faction;
        mCost = cost;
        mCache = cache;
        mLevel = level;
        mStats = stats;
    }

    public static class Builder {
        private String mName = "";
        private Set<Faction> mFactions = Sets.newHashSet();
        private int mCost = -1;
        private int mCache = -1;
        private Level mLevel = null;
        private Set<Status> mStats = Sets.newHashSet();

        public Builder name(String name) {
            mName = name;
            return this;
        }

        public Builder faction(Faction faction) {
            mFactions.add(faction);
            return this;
        }

        public Builder cost(int cost) {
            mCost = cost;
            return this;
        }

        public Builder cache(int cache) {
            mCache = cache;
            return this;
        }

        public Builder level(Level level) {
            mLevel = level;
            return this;
        }

        public Builder status(Status status) {
            mStats.add(status);
            return this;
        }

        public Model build() {
            return new Model(mName, mFactions, mCost, mCache, mLevel, mStats);
        }
    }

    public boolean is(Level level) {
        return mLevel.equals(level);
    }

    public boolean is(Status status) {
        return Iterables.contains(mStats, status);
    }

    public boolean is(Faction faction) {
        return Iterables.contains(mFactions, faction);
    }
}
