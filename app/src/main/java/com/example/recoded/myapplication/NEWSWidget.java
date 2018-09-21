package com.example.recoded.myapplication;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Implementation of App Widget functionality.
 */
public class NEWSWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId, News news) {

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.newswidget);

        views.setTextViewText(R.id.title, news.getTitle());
//        views.setImageViewUri(R.id.image, Uri.parse(news.getImage() ));

        try {
            URL url = new URL(news.getImage());
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream) url.getContent());
            views.setImageViewBitmap(R.id.image, bitmap);
        } catch (IOException e) {
        }

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId, new News("add a news in the app", ""));
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

