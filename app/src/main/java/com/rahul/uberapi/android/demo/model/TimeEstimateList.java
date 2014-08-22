package com.rahul.uberapi.android.demo.model;

import java.util.List;

/**
 * Used by the time estimates endpoint and lists the ETAs for all products offered at a given
 * location.
 */
public class TimeEstimateList extends UberModel {

    /**
     * List of the ETAs for all products offered at a given location.
     */
    List<TimeEstimate> times;

    public List<TimeEstimate> getTimes() {
        return times;
    }

}
