package com.nothingatall.malicraft.models;

import com.nothingatall.malicraft.core.Faction;

import java.util.List;

/**
 * interface for the database
 *
 * //TODO this api needs thought
 *
 * Created by nothingatall on 1/26/2016.
 */
public interface Models {
    List<Model> get();

    List<Model> getLeaders(int ss, Faction faction);
}
