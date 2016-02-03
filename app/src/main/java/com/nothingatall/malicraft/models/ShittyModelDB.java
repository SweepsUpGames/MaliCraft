package com.nothingatall.malicraft.models;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.nothingatall.malicraft.core.Faction;
import com.nothingatall.malicraft.models.Model.Level;
import com.nothingatall.malicraft.models.Model.Status;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * placeholder database to use until a more full one can be implemented
 * <p/>
 * Created by nothingatall on 1/26/2016.
 */
public class ShittyModelDB implements Models {
    private final List<Model> mDataBase;

    public ShittyModelDB() {
        mDataBase = Lists.newArrayList(
                new Model.Builder()
                        .name("Viktoria of Ash")
                        .faction(Faction.OUTCAST)
                        .cache(1)
                        .rare(1)
                        .level(Level.MASTER)
                        .status(Status.LIVING)
                        .build(),
                new Model.Builder()
                        .name("Viktoria of Blood")
                        .faction(Faction.OUTCAST)
                        .cost(0)
                        .rare(1)
                        .cache(1)
                        .level(Level.HENTCHMEN)
                        .status(Status.LIVING)
                        .build(),
                new Model.Builder()
                        .name("Johan")
                        .faction(Faction.OUTCAST)
                        .cost(6)
                        .rare(1)
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
                        .rare(1)
                        .build(),
                new Model.Builder()
                        .name("Coryphee")
                        .faction(Faction.ARCANIST)
                        .level(Level.MINION)
                        .cost(7)
                        .status(Status.CONSTRUCT)
                        .status(Status.PUPPET)
                        .status(Status.SHOWGIRL)
                        .rare(2)
                        .build());
    }

    @Override
    public List<Model> get() {
        return mDataBase;
    }

    @Override
    public List<Model> getLeaders(int ss, Faction faction) {
        final ImmutableList.Builder<Model> models = ImmutableList.builder();
        if (ss >= 25) {
            models.addAll(getMasterOptions(faction));
        }
        if (ss <= 40) {
            models.addAll(getHenchmenOptions(faction));
        }
        return models.build();
    }

    private ImmutableList<Model> getMasterOptions(Faction faction) {
        return ImmutableList.copyOf(
                Iterables.filter(
                        mDataBase,
                        new AndFilter(
                                new LevelFilter(Level.MASTER),
                                new FactionFilter(faction))));
    }

    private ImmutableList<Model> getHenchmenOptions(Faction faction) {
        return ImmutableList.copyOf(
                Iterables.filter(
                        mDataBase,
                        new AndFilter(
                                new LevelFilter(Level.HENTCHMEN),
                                new FactionFilter(faction))));
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

    public class AndFilter implements Predicate<Model> {
        private final Predicate<Model>[] mFilters;

        public AndFilter(Predicate<Model>... filters) {
            mFilters = filters;
        }

        @Override
        public boolean apply(Model input) {
            boolean results = true;
            for (Predicate<Model> filter : mFilters) {
                results = results && filter.apply(input);
            }
            return results;
        }
    }
}
