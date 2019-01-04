package com.system.rongyunlib.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.system.rongyunlib.R;
import com.system.uilibrary.views.titlebar.TitleBarView;


public class ConversationActivity extends FragmentActivity {

    private TitleBarView titleBar;
    private String title;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversation);
        titleBar = (TitleBarView) findViewById(R.id.titleBar);
        title = getIntent().getData().getQueryParameter("title");
        userId = getIntent().getData().getQueryParameter("targetId");

        titleBar.setTitleMainText(title)
                .setLeftTextDrawable(R.mipmap.ic_toolbar_back_white_48dp)
                .setOnLeftTextClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
    }

}
