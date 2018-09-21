package com.example.recoded.myapplication;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.save_to_widget_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(MainActivity.this);
                int ids[] = appWidgetManager.getAppWidgetIds(new ComponentName(MainActivity.this, NEWSWidget.class));

                for (int id : ids) {
                    NEWSWidget.updateAppWidget(MainActivity.this,
                            appWidgetManager, id, new News("new keyboard",
                                    "https://papeersupportcoalition.org/wp-content/uploads/2017/01/6a00d83420c49153ef01b7c781a9b2970b.jpg"));
                }
            }
        });

//        https://papeersupportcoalition.org/wp-content/uploads/2017/01/6a00d83420c49153ef01b7c781a9b2970b.jpg
        // new keyboard


    }
}
