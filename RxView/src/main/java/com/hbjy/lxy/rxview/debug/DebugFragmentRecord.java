package com.hbjy.lxy.rxview.debug;

import java.util.List;

/**
 * Created by 李小勇 on 2017/3/14.
 */

public class DebugFragmentRecord {
    public String                    fragmentName;
    public List<DebugFragmentRecord> childFragmentRecord;

    public DebugFragmentRecord(String fragmentName, List<DebugFragmentRecord> childFragmentRecord) {
        this.fragmentName = fragmentName;
        this.childFragmentRecord = childFragmentRecord;
    }
}
