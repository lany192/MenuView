package com.github.lany192.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 自定义菜单列表item视图
 */
public class MenuView extends FrameLayout {
    private ImageView mIconImg;
    private TextView mNameText;
    private TextView mHintText;
    private ImageView mArrowImg;
    @DrawableRes
    private int mIconResId;
    private CharSequence mName = "";
    private CharSequence mHint = "";
    @ColorInt
    private int mHintColor = R.color.menu_hint;
    @ColorInt
    private int mNameColor = R.color.menu_name;
    private boolean mIsShowArrow = true;
    private boolean mIsShowIcon = true;
    private boolean mIsShowHint = true;
    private float mHintSize = 12;
    private float mNameSize = 14;

    public MenuView(Context context) {
        super(context);
        init(null, 0);
    }

    public MenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public MenuView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        View view = View.inflate(getContext(), R.layout.view_menu, this);
        mIconImg = view.findViewById(R.id.menu_icon_img);
        mArrowImg = view.findViewById(R.id.menu_arrow_img);
        mNameText = view.findViewById(R.id.menu_name_text);
        mHintText = view.findViewById(R.id.menu_hint_text);

        final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MenuView, defStyle, 0);
        mName = a.getString(R.styleable.MenuView_menu_name);
        mHint = a.getString(R.styleable.MenuView_menu_hint);
        mHintColor = a.getColor(R.styleable.MenuView_menu_hintColor, getResources().getColor(R.color.menu_hint));
        mNameColor = a.getColor(R.styleable.MenuView_menu_nameColor, getResources().getColor(R.color.menu_name));
        mIsShowArrow = a.getBoolean(R.styleable.MenuView_menu_isShowArrow, true);
        mIsShowIcon = a.getBoolean(R.styleable.MenuView_menu_isShowIcon, true);
        mIsShowHint = a.getBoolean(R.styleable.MenuView_menu_isShowHint, true);
        mHintSize = a.getFloat(R.styleable.MenuView_menu_hintSize, 12);
        mNameSize = a.getFloat(R.styleable.MenuView_menu_nameSize, 14);
        if (a.hasValue(R.styleable.MenuView_menu_icon)) {
            mIconResId = a.getResourceId(R.styleable.MenuView_menu_icon, R.drawable.vector_android);
        }
        a.recycle();
        reset();
    }

    private void reset() {
        if (mIsShowIcon && mIconResId > 0) {
            mIconImg.setImageResource(mIconResId);
            mIconImg.setVisibility(View.VISIBLE);
        } else {
            mIconImg.setVisibility(View.GONE);
        }
        mHintText.setTextColor(mNameColor);
        mHintText.setTextSize(mNameSize);
        mNameText.setText(mName);
        if (mIsShowHint) {
            mHintText.setText(mHint);
            mHintText.setTextColor(mHintColor);
            mHintText.setTextSize(mHintSize);
            mHintText.setVisibility(View.VISIBLE);
        } else {
            mHintText.setVisibility(View.GONE);
        }
        mArrowImg.setVisibility(mIsShowArrow ? View.VISIBLE : View.GONE);
    }

    public MenuView setIcon(@DrawableRes int iconResId) {
        if (mIsShowIcon && iconResId > 0) {
            this.mIconResId = iconResId;
            this.mIconImg.setImageResource(iconResId);
        }
        return this;
    }

    public MenuView setName(CharSequence text) {
        if (!TextUtils.isEmpty(text)) {
            this.mName = text;
            this.mNameText.setText(text);
        }
        return this;
    }

    public MenuView setHint(CharSequence text) {
        if (!TextUtils.isEmpty(text)) {
            this.mHint = text;
            this.mHintText.setText(text);
        }
        return this;
    }

    public MenuView setHintColor(@ColorInt int color) {
        if (color > 0) {
            this.mHintText.setTextColor(color);
        }
        return this;
    }

    public MenuView setIsShowArrow(boolean isShow) {
        this.mIsShowArrow = isShow;
        invalidate();
        return this;
    }

    public MenuView setIsShowIcon(boolean isShow) {
        this.mIsShowIcon = isShow;
        invalidate();
        return this;
    }

    public MenuView setHintTextSize(float size) {
        if (!TextUtils.isEmpty(mHint) && size > 0) {
            this.mHintText.setTextSize(size);
        }
        return this;
    }

    public MenuView setNameTextSize(float size) {
        if (size > 0) {
            this.mNameText.setTextSize(size);
        }
        return this;
    }

    public MenuView setNameColor(@ColorInt int color) {
        if (color > 0) {
            this.mNameText.setTextColor(color);
        }
        return this;
    }
}
