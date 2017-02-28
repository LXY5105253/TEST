package com.hbjy.lxy.frame.app.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hbjy.lxy.frame.R;
import com.hbjy.lxy.frame.app.dialog.effects.BaseEffects;
import com.hbjy.lxy.frame.utils.ColorUtils;

import butterknife.InjectView;

/**
 * Created by Administrator on 2017/2/27 0027.
 */

public class NiftyDialogBuilder extends Dialog implements DialogInterface {

    private static final String TAG = NiftyDialogBuilder.class.getSimpleName();
    private static Context mContext;
    private View mDialogView;

    private RelativeLayout mRelative;
    private LinearLayout mTitleLinear;
    private LinearLayout mContentLinear;
    private LinearLayout mParentLinear;
    private FrameLayout mFrame;
    private RadioGroup mGroup;
    private View mDivider;
    private TextView mMsg;
    private Button mBtLeft,mBtRight;
    private TextView mTitle;
    private ImageView mIcon;

    private EffectsType type;
    private int mDuration = -1;
    private boolean isCancelable = true;
    private static NiftyDialogBuilder instance;

    public NiftyDialogBuilder(Context context) {
        super(context);
        init(context);
    }

    public NiftyDialogBuilder(Context context, int themeResId) {
        super(context, themeResId);
        init(context);
    }

    protected NiftyDialogBuilder(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(params);

    }

    public static NiftyDialogBuilder getInstance(Context context){
        if (instance == null || !mContext.equals(context) ){
            synchronized (NiftyDialogBuilder.class){
                if (instance == null || !mContext.equals(context) ){
                    instance = new NiftyDialogBuilder(context,R.style.dialog_untran);
                }
            }
        }
        mContext = context;
        return instance;
    }

    private void init(Context context) {
        mDialogView = View.inflate(context, R.layout.cutorm_dialog, null);
        mRelative = (RelativeLayout) mDialogView.findViewById(R.id.dialog_rl);
        mContentLinear = (LinearLayout) mDialogView.findViewById(R.id.dialog_contentPanel);
        mParentLinear = (LinearLayout) mDialogView.findViewById(R.id.dialog_parentPanel);
        mTitleLinear = (LinearLayout) mDialogView.findViewById(R.id.dialog_topPanel);
        mDivider = mDialogView.findViewById(R.id.dialog_divider);
        mFrame = (FrameLayout) mDialogView.findViewById(R.id.dialog_customPanel);
        mGroup = (RadioGroup) mDialogView.findViewById(R.id.dialog_group);
        mTitle = (TextView) mDialogView.findViewById(R.id.dialog_title_text);
        mIcon = (ImageView) mDialogView.findViewById(R.id.dialog_title_icon);
        mMsg = (TextView) mDialogView.findViewById(R.id.dialog_tv_message);
        mBtLeft = (Button) mDialogView.findViewById(R.id.dialog_bt_left);
        mBtRight = (Button) mDialogView.findViewById(R.id.dialog_bt_right);

        setContentView(mDialogView);

        this.setOnShowListener(new OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                mParentLinear.setVisibility(View.VISIBLE);
                if (type == null) {
                    type = EffectsType.Fall;
                }
                start(type);
            }
        });
        mRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCancelable) dismiss();
            }
        });
    }

    /**
     * 设置分割线颜色
     * @param colorString
     * @return
     */
    public NiftyDialogBuilder setDividerColor(String colorString) {
        mDivider.setBackgroundColor(Color.parseColor(colorString));
        return this;
    }

    /**
     * 设置分割线颜色
     * @param color
     * @return
     */
    public NiftyDialogBuilder setDividerColor(int color) {
        mDivider.setBackgroundColor(color);
        return this;
    }

    /**
     * 设置标题文字
     * @param title
     * @return
     */
    public NiftyDialogBuilder setTitleText(CharSequence title) {
        toggleView(mTitleLinear, title);
        mTitle.setText(title);
        return this;
    }

    /**
     * 设置标题颜色
     * @param colorString
     * @return
     */
    public NiftyDialogBuilder setTitleColor(String colorString) {
        mTitle.setTextColor(Color.parseColor(colorString));
        return this;
    }

    /**
     * 设置标题颜色
     * @param color
     * @return
     */
    public NiftyDialogBuilder setTitleColor(int color) {
        mTitle.setTextColor(color);
        return this;
    }

    /**
     * 设置dialog 背景颜色
     * @param colorString
     * @return
     */
    public NiftyDialogBuilder setDialogColor(String colorString) {
        mParentLinear.getBackground().setColorFilter(ColorUtils.getColorFilter(Color
                .parseColor(colorString)));
        return this;
    }

    /**
     * 设置dialog 背景颜色
     * @param color
     * @return
     */
    public NiftyDialogBuilder setDialogColor(int color) {
        mParentLinear.getBackground().setColorFilter(ColorUtils.getColorFilter(color));
        return this;
    }

    /**
     * 设置标题图片
     * @param drawableResId
     * @return
     */
    public NiftyDialogBuilder setIcon(int drawableResId) {
        mIcon.setImageResource(drawableResId);
        return this;
    }

    public NiftyDialogBuilder setIcon(Drawable icon) {
        mIcon.setImageDrawable(icon);
        return this;
    }

    /**
     * 设置动画时长
     * 默认为 700ms
     * @param duration
     * @return
     */
    public NiftyDialogBuilder setDuration(int duration) {
        this.mDuration = duration;
        return this;
    }

    /**
     * 设置动画类型
     * @param type
     * @return
     */
    public NiftyDialogBuilder setEffect(EffectsType type) {
        this.type = type;
        return this;
    }

    private void toggleView(View view, Object obj) {
        if (obj == null) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
        }
    }

    public NiftyDialogBuilder setMessage(CharSequence text){
        mMsg.setVisibility(View.VISIBLE);
        mMsg.setText(text);
        return this;
    }

    public NiftyDialogBuilder setMessageColor(int color){
        mMsg.setTextColor(color);
        return this;
    }

    public NiftyDialogBuilder setMessageColor(String colorString){
        mMsg.setTextColor(Color.parseColor(colorString));
        return this;
    }

    /**
     * 设置Button的背景
     * @param resid
     * @return
     */
    public NiftyDialogBuilder setButtonDrawable(int resid) {
        mBtLeft.setBackgroundResource(resid);
        mBtRight.setBackgroundResource(resid);
        return this;
    }

    /**
     * 设置左边Button的文字
     * @param text
     * @return
     */
    public NiftyDialogBuilder setButtonLeftText(CharSequence text) {
        mBtLeft.setVisibility(View.VISIBLE);
        mBtLeft.setText(text);

        return this;
    }

    /**
     * 设置右边Button的文字
     * @param text
     * @return
     */
    public NiftyDialogBuilder setButtonRightText(CharSequence text) {
        mBtRight.setVisibility(View.VISIBLE);
        mBtRight.setText(text);
        return this;
    }

    /**
     * 设置左边Button点击事件
     * @param click
     * @return
     */
    public NiftyDialogBuilder setButtonLeftClick(View.OnClickListener click) {
        mBtLeft.setVisibility(View.VISIBLE);
        mBtLeft.setOnClickListener(click);
        return this;
    }

    /**
     * 设置右边Button点击事件
     * @param click
     * @return
     */
    public NiftyDialogBuilder setButtonRightClick(View.OnClickListener click) {
        mBtRight.setVisibility(View.VISIBLE);
        mBtRight.setOnClickListener(click);
        return this;
    }

    /**
     * 设置自定义View
     * @param resId
     * @param context
     * @return
     */
    public NiftyDialogBuilder setCustomView(int resId, Context context) {
        View customView = View.inflate(context, resId, null);
        if (mFrame.getChildCount() > 0) {
            mFrame.removeAllViews();
        }
        mFrame.addView(customView);
        mFrame.setVisibility(View.VISIBLE);
        return this;
    }

    public NiftyDialogBuilder setCustomView(View view) {
        if (mFrame.getChildCount() > 0) {
            mFrame.removeAllViews();
        }
        mFrame.addView(view);
        mFrame.setVisibility(View.VISIBLE);
        return this;
    }

    public NiftyDialogBuilder isCancelableOnTouchOutside(boolean cancelable) {
        this.isCancelable = cancelable;
        this.setCanceledOnTouchOutside(cancelable);
        return this;
    }

    public NiftyDialogBuilder isCancelable(boolean cancelable) {
        this.isCancelable = cancelable;
        this.setCancelable(cancelable);
        return this;
    }

    /**
     * 开始动画
     * @param type
     */
    private void start(EffectsType type){
        BaseEffects animator = type.getAnimator();
        if (mDuration != -1){
            animator.setDuration(Math.abs(mDuration));
        }
        animator.start(mRelative);
    }

    /**
     * 设置RadioButton排列方式
     * 默认为vertical
     * @param orientation
     * @return
     */
    private NiftyDialogBuilder setOrientation(int orientation){
        mGroup.setOrientation(orientation);
        return this;
    }

    public NiftyDialogBuilder setSingleChoiceItems(final String[] items, int i, final OnClickListener listener){
        int temp;
        mGroup.removeAllViews();
        if (items.length < 1){
            Log.i(TAG, "error:字符串数组为空 ");
        }else {
            if (i < 0){
                temp = 0;
            }else if (i < items.length){
                temp = i;
            }else {
                temp = items.length;
            }
            for (int j = 0; j < items.length; j++) {
                RadioButton b = new RadioButton(mContext);
                b.setText(items[j]);
                b.setPadding(5,5,5,5);
//                b.setButtonDrawable(null);
                b.setGravity(Gravity.CENTER);
                mGroup.addView(b);
                if (j == temp){
                    b.setChecked(true);
                }else {
                    b.setChecked(false);
                }
            }
        }
        mGroup.setVisibility(View.VISIBLE);
        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton b = (RadioButton) findViewById(checkedId);
                if (b != null) {
                    for (int j = 0; j < items.length; j++) {
                        if (items[j] == b.getText().toString()){
                            listener.onClick(NiftyDialogBuilder.this,j);
                            break;
                        }
                    }
                }
            }
        });
        return this;
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        mBtRight.setVisibility(View.GONE);
        mBtLeft.setVisibility(View.GONE
        );
    }
}
