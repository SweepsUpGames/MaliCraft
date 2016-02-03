package com.nothingatall.malicraft.list;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.nothingatall.malicraft.R;
import com.nothingatall.malicraft.Util.Null;

/**
 * fragment showing the crew view
 * <p/>
 * Created by nothingatall on 1/28/2016.
 */
public class CrewFragment extends Fragment {
    private EditText mCrewNameEditText;
    private TextView mCrewFactionView;
    private TextView mCrewLeaderView;

    private CrewListener mCrewListener;

    private CrewList mCrewList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.malicraft_crew_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCrewNameEditText = (EditText) view.findViewById(R.id.crew_name);
        mCrewNameEditText.setHint(mCrewList.getCrewName());
        mCrewFactionView = (TextView) view.findViewById(R.id.faction_choice);
        mCrewFactionView.setText(mCrewList.getFaction().toString());
        mCrewFactionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCrewListener.onFactionButtonClick();
            }
        });
        mCrewLeaderView = (TextView) view.findViewById(R.id.leader_choice);
        mCrewLeaderView.setText(mCrewList.getLeader());
        mCrewLeaderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCrewListener.onLeaderButtonClick();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        if (Null.isNot(savedInstanceState)) {
            //TODO handle case where the crew list is not in the bundle
        }
        super.onViewStateRestored(savedInstanceState);
    }

    public void initialize(CrewList crewList, CrewListener crewListener) {
        mCrewList = crewList;
        mCrewListener = crewListener;
    }

    public interface CrewListener {
        void onCrewNameChange(String crewName);
        void onFactionButtonClick();

        void onLeaderButtonClick();
    }
}
