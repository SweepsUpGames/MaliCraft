package com.nothingatall.malicraft.core;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.nothingatall.malicraft.R;

/**
 * Created by nothingatall on 1/26/2016.
 */
public class FactionFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.faction_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(new ArrayAdapter<>(getActivity(), R.layout.faction_list_item, Faction.values()));
        getListView().setOnItemClickListener(new FactionClickListener());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private static class FactionClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final Faction faction = (Faction) parent.getItemAtPosition(position);
            Toast.makeText(view.getContext(), String.format("%s clicked", faction.toString()), Toast.LENGTH_SHORT).show();
        }
    }
}
