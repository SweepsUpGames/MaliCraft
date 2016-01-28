package com.nothingatall.malicraft.list;

import android.util.Log;

import com.nothingatall.malicraft.MaliCraftView;
import com.nothingatall.malicraft.core.Faction;

/**
 * Presenter to control the application flow while creating a new list
 * Created by nothingatall on 1/27/2016.
 */
public class MaliCraftPresenter {
    private final MaliCraftView mMaliCraftView;

    public MaliCraftPresenter(MaliCraftView maliCraftView) {
        mMaliCraftView = maliCraftView;
    }

    public void startNewList() {
        mMaliCraftView.showFactionList(new MaliCraftView.OnFactionChoiceListener() {
            @Override
            public void onFactionChoice(Faction faction) {
                //listModel.setFaction(faction)
                //view.showListPage(listener)
                Log.d("TAG", String.format("%s selected", faction));
            }
        });
    }
}
