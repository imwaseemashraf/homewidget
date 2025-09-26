package com.example.homewidget

import android.appwidget.AppWidgetManager
import android.content.Context
import android.widget.RemoteViews
import es.antonborri.home_widget.HomeWidgetProvider
import android.content.SharedPreferences
/**
 * Implementation of App Widget functionality.
 */
class AudioPlayerWidget : HomeWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray,
        widgetData: SharedPreferences
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId, widgetData)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int,
    widgetData: SharedPreferences
) {
    val views = RemoteViews(context.packageName, R.layout.audio_player_widget)
    val title = widgetData.getString("title", "Default Title")
    val author = widgetData.getString("author", "Default Author")
    val counter = widgetData.getInt("counter", 0)
    // Construct the RemoteViews object
    views.setTextViewText(R.id.appwidget_title, title)
    views.setTextViewText(R.id.appwidget_author, author)
    views.setTextViewText(R.id.appwidget_counter, counter.toString())
    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}