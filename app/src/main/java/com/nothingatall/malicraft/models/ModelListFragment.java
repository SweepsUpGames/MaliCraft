package com.nothingatall.malicraft.models;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nothingatall.malicraft.MaliCraftView;
import com.nothingatall.malicraft.R;

import java.util.List;

/**
 * fragment to show a list of models, may need to split between leader and crew selection for
 * multiple choices
 * <p/>
 * Created by nothingatall on 1/31/2016.
 */
public class ModelListFragment extends ListFragment {
    private MaliCraftView.ModelChoiceListener mModelChoiceListener;
    private List<Model> mModelList;

    public void initialize(List<Model> modelList, MaliCraftView.ModelChoiceListener modelChoiceListener) {
        mModelList = modelList;
        mModelChoiceListener = modelChoiceListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.faction_fragment, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(new ArrayAdapter<>(getActivity(), R.layout.faction_list_item, mModelList));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mModelChoiceListener.onModelChoice(mModelList.get(position));
    }
}
