package com.nothingatall.malicraft.core;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.nothingatall.malicraft.MaliCraftView;
import com.nothingatall.malicraft.R;

/**
 * Fragment to select the faction for the list
 *
 * Created by nothingatall on 1/26/2016.
 */
public class FactionFragment extends ListFragment {
    private MaliCraftView.OnFactionChoiceListener mFactionChoiceListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.faction_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(new ArrayAdapter<>(getActivity(), R.layout.faction_list_item, Faction.values()));
        getListView().setOnItemClickListener(new FactionClickListener(mFactionChoiceListener));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void setFactionChoiceListener(MaliCraftView.OnFactionChoiceListener factionChoiceListener) {
        mFactionChoiceListener = factionChoiceListener;
    }

    private static class FactionClickListener implements AdapterView.OnItemClickListener {
        private MaliCraftView.OnFactionChoiceListener mFactionChoiceListener;

        FactionClickListener(MaliCraftView.OnFactionChoiceListener factionChoiceListener) {
            mFactionChoiceListener = factionChoiceListener;
        }
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final Faction faction = (Faction) parent.getItemAtPosition(position);
            mFactionChoiceListener.onFactionChoice(faction);
        }
    }
}
