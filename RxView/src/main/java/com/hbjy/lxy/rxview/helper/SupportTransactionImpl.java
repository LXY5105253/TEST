package com.hbjy.lxy.rxview.helper;

import android.view.View;

import com.hbjy.lxy.rxview.helper.internal.TransactionRecord;

/**
 * Created by 李小勇 on 2017/3/14.
 */

public class SupportTransactionImpl<T extends SupportFragment> extends SupportTransaction {
    private T mSupportFragment;
    private TransactionRecord mRecord;

    SupportTransactionImpl(T supportFragment) {
        this.mSupportFragment = supportFragment;
        mRecord = new TransactionRecord();
    }

    @Override
    public SupportTransaction setTag(String tag) {
        mRecord.tag = tag;
        return this;
    }

    @Override
    public SupportTransaction forResult(int requestCode) {
        mRecord.requestCode = requestCode;
        return this;
    }

    @Override
    public SupportTransaction setLaunchMode(@SupportFragment.LaunchMode int launchMode) {
        mRecord.launchMode = launchMode;
        return this;
    }

    @Override
    public SupportTransaction withPop(boolean with) {
        mRecord.withPop = with;
        return this;
    }

    @Override
    public SupportTransaction addSharedElement(View sharedElement, String sharedName) {
        mRecord.sharedElement = new TransactionRecord.SharedElement(sharedElement, sharedName);
        return this;
    }

    @Override
    public T commit() {
        mRecord.commitMode = TransactionRecord.COMMIT;
        mSupportFragment.setTransactionRecord(mRecord);
        return mSupportFragment;
    }

    @Override
    public T commitAllowingStateLoss() {
        mRecord.commitMode = TransactionRecord.COMMIT_ALLOWING_STATE_LOSS;
        mSupportFragment.setTransactionRecord(mRecord);
        return mSupportFragment;
    }

    @Override
    public T commitImmediate() {
        mRecord.commitMode = TransactionRecord.COMMIT_IMMEDIATE;
        mSupportFragment.setTransactionRecord(mRecord);
        return mSupportFragment;
    }
}
