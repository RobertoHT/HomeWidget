package micromaster.beginner.com.homewidget.widget;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;
import java.util.List;

import micromaster.beginner.com.homewidget.R;

/**
 * Created by praxis on 05/04/17.
 */

public class WidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return (new ListProvider(this.getApplicationContext(), intent));
    }

    private class ListProvider implements RemoteViewsFactory{
        private List<String> listNames = new ArrayList<>();
        private Context context = null;

        public ListProvider(Context context, Intent intent) {
            this.context = context;

            populateListItem();
        }

        private void populateListItem() {
            listNames.add("John");
            listNames.add("Mary");
            listNames.add("Emma");
            listNames.add("William");
            listNames.add("Noah");
            listNames.add("Susan");
            listNames.add("Patricia");
            listNames.add("Robert");
        }

        @Override
        public void onCreate() {

        }

        @Override
        public void onDataSetChanged() {

        }

        @Override
        public void onDestroy() {

        }

        @Override
        public int getCount() {
            return listNames.size();
        }

        @Override
        public RemoteViews getViewAt(int position) {
            final RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.list_row);
            remoteView.setTextViewText(R.id.tvText, listNames.get(position));

            return remoteView;
        }

        @Override
        public RemoteViews getLoadingView() {
            return null;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }
    }
}
