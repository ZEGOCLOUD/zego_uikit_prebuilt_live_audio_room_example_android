package com.zegocloud.uikit.prebuilt.liveaudioroomexample;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zegocloud.uikit.utils.Utils;

public class AudioRoomBackgroundView extends FrameLayout {

    private TextView roomName;
    private TextView roomID;

    public AudioRoomBackgroundView(@NonNull Context context) {
        super(context);
        initView();
    }

    public AudioRoomBackgroundView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public AudioRoomBackgroundView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, -2);
        int marginEnd = Utils.dp2px(12, getResources().getDisplayMetrics());
        params.setMargins(0, 0, marginEnd, 0);

        roomName = new TextView(getContext());
        roomName.setMaxLines(1);
        roomName.setEllipsize(TruncateAt.END);
        roomName.setSingleLine(true);
        roomName.getPaint().setFakeBoldText(true);
        roomName.setTextColor(Color.parseColor("#ff1b1b1b"));
        roomName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        roomName.setMaxWidth(Utils.dp2px(200, getResources().getDisplayMetrics()));
        linearLayout.addView(roomName, params);

        roomID = new TextView(getContext());
        roomID.setMaxLines(1);
        roomID.setEllipsize(TruncateAt.END);
        roomID.setSingleLine(true);
        roomID.setTextColor(Color.parseColor("#ff606060"));
        roomID.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        roomID.setMaxWidth(Utils.dp2px(120, getResources().getDisplayMetrics()));
        linearLayout.addView(roomID, params);

        LayoutParams layoutParams = new LayoutParams(-2, -2);
        int marginStart = Utils.dp2px(16, getResources().getDisplayMetrics());
        int marginTop = Utils.dp2px(10, getResources().getDisplayMetrics());
        layoutParams.setMargins(marginStart, marginTop, 0, 0);
        addView(linearLayout, layoutParams);
    }

    public void setRoomName(String roomName) {
        this.roomName.setText(roomName);
    }

    public void setRoomID(String roomID) {
        this.roomID.setText("ID: " + roomID);
    }
}