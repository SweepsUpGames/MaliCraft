package com.nothingatall.malicraft;

import com.nothingatall.malicraft.core.Faction;

/**
 * interface to remove android from the application logic
 * Created by nothingatall on 1/27/2016.
 */
public interface MaliCraftView {
    void showFactionList(OnFactionChoiceListener onFactionChoiceListener);

    interface OnFactionChoiceListener {
        void onFactionChoice(Faction faction);
    }
}
