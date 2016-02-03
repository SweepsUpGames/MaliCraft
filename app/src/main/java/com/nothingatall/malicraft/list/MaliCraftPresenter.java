package com.nothingatall.malicraft.list;

import android.support.annotation.NonNull;

import com.nothingatall.malicraft.MaliCraftView;
import com.nothingatall.malicraft.core.Faction;
import com.nothingatall.malicraft.models.Model;
import com.nothingatall.malicraft.models.Models;
import com.nothingatall.malicraft.models.ShittyModelDB;

import java.util.List;

/**
 * Presenter to control the application flow while creating a new list
 * Created by nothingatall on 1/27/2016.
 */
public class MaliCraftPresenter {
    private final MaliCraftView mMaliCraftView;
    private final Models mModels;
    private final CrewList.Builder mCrew;

    private final CrewFragment.CrewListener mCrewListener;

    public MaliCraftPresenter(@NonNull MaliCraftView maliCraftView) {
        mMaliCraftView = maliCraftView;
        mModels = new ShittyModelDB();
        mCrew = new CrewList.Builder();

        mCrewListener = new MaliCraftCrewListener(this);
    }

    public void startNewList() {
        mMaliCraftView.showCrewList(mCrew.build(), mCrewListener);
    }

    public void chooseFaction() {
        mMaliCraftView.showFactionList(new MaliCraftView.OnFactionChoiceListener() {
            @Override
            public void onFactionChoice(Faction faction) {
                mCrew.faction(faction);
                mMaliCraftView.showCrewList(mCrew.build(), mCrewListener);
                mMaliCraftView.logMessage(String.format("%s selected", faction));
            }
        });
    }

    public void chooseLeader() {
        final List<Model> modelList = mModels.getLeaders(30, mCrew.build().getFaction());
        mMaliCraftView.showModelList(modelList, new MaliCraftView.ModelChoiceListener() {
            @Override
            public void onModelChoice(Model model) {
                mCrew.leader(model);
                mMaliCraftView.showCrewList(mCrew.build(), mCrewListener);
                mMaliCraftView.logMessage(String.format("%s selected", model));
            }

            @Override
            public void onModelChoice(List<Model> models) {
                //TODO re-think this api
            }
        });

    }

    private static class MaliCraftCrewListener implements CrewFragment.CrewListener {
        private final MaliCraftPresenter mPresenter;

        private MaliCraftCrewListener(MaliCraftPresenter presenter) {
            mPresenter = presenter;
        }

        @Override
        public void onCrewNameChange(String crewName) {

        }

        @Override
        public void onFactionButtonClick() {
            mPresenter.chooseFaction();
        }

        @Override
        public void onLeaderButtonClick() {
            mPresenter.chooseLeader();
        }
    }
}
