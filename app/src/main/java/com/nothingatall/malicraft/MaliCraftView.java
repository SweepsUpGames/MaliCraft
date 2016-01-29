package com.nothingatall.malicraft;

import com.nothingatall.malicraft.core.Faction;
import com.nothingatall.malicraft.list.CrewFragment;
import com.nothingatall.malicraft.list.CrewList;

/**
 * interface to remove android from the application logic
 * Created by nothingatall on 1/27/2016.
 */
public interface MaliCraftView {
    void logMessage(String message);

    void showCrewList(CrewList crewList, CrewFragment.CrewListener listener);
    void showFactionList(OnFactionChoiceListener onFactionChoiceListener);

    interface OnFactionChoiceListener {
        void onFactionChoice(Faction faction);
    }
}
