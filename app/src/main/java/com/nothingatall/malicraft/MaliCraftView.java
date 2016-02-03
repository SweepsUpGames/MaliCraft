package com.nothingatall.malicraft;

import android.graphics.AvoidXfermode;

import com.nothingatall.malicraft.core.Faction;
import com.nothingatall.malicraft.list.CrewFragment;
import com.nothingatall.malicraft.list.CrewList;
import com.nothingatall.malicraft.models.Model;

import java.util.List;

/**
 * interface to remove android from the application logic
 * Created by nothingatall on 1/27/2016.
 */
public interface MaliCraftView {
    void logMessage(String message);

    void showCrewList(CrewList crewList, CrewFragment.CrewListener listener);
    void showFactionList(OnFactionChoiceListener onFactionChoiceListener);

    void showModelList(List<Model> modelList, ModelChoiceListener modelChoiceListener);

    interface OnFactionChoiceListener {
        void onFactionChoice(Faction faction);
    }

    interface ModelChoiceListener {
        void onModelChoice(Model model);

        void onModelChoice(List<Model> models);
    }
}
