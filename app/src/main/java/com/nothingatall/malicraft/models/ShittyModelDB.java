package com.nothingatall.malicraft.models;

import com.nothingatall.malicraft.core.Faction;
import com.nothingatall.malicraft.models.Model.Level;
import com.nothingatall.malicraft.models.Model.Status;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

/**
 * Created by nothingatall on 1/26/2016.
 */
public class ShittyModelDB implements Models {
    private final Iterable<Model> mDataBase;

    public ShittyModelDB() {
        mDataBase = Lists.newArrayList(
                new Model.Builder()
                        .name("Viktoria of Ash")
                        .faction(Faction.OUTCAST)
                        .cache(1)
                        .level(Level.MASTER)
                        .status(Status.LIVING)
                        .build(),
                new Model.Builder()
                        .name("Viktoria of Blood")
                        .faction(Faction.OUTCAST)
                        .cost(0)
                        .cache(1)
                        .level(Level.HENTCHMEN)
                        .status(Status.LIVING)
                        .build(),
                new Model.Builder()
                        .name("Johan")
                        .faction(Faction.OUTCAST)
                        .cost(6)
                        .level(Level.ENFORCER)
                        .status(Status.LIVING)
                        .status(Status.MERCENARY)
                        .build(),
                new Model.Builder()
                        .name("McMourning")
                        .faction(Faction.RESURRECTIONIST)
                        .faction(Faction.GUILD)
                        .status(Status.LIVING)
                        .level(Level.MASTER)
                        .cache(4)
                        .build());
    }

    @Override
    public Iterable<Model> get() {
        return mDataBase;
    }

    public class LevelFilter implements Predicate<Model> {
        private final Model.Level mLevel;

        public LevelFilter(Model.Level level) {
            mLevel = level;
        }

        @Override
        public boolean apply(Model model) {
            return model.is(mLevel);
        }
    }

    public class StatusFilter implements Predicate<Model> {
        private final Model.Status mStatus;

        public StatusFilter(Model.Status status) {
            mStatus = status;
        }

        @Override
        public boolean apply(Model model) {
            return model.is(mStatus);
        }
    }

    public class FactionFilter implements Predicate<Model> {
        private final Faction mFaction;

        public FactionFilter(Faction faction) {
            mFaction = faction;
        }

        @Override
        public boolean apply(Model model) {
            return model.is(mFaction);
        }
    }
}
