package com.example.animatedlistviewsample;

import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SwingBottomInAnimationAdapter swingBottomInAdapter = new SwingBottomInAnimationAdapter(new MyBaseAdapter());
		swingBottomInAdapter.setAbsListView(getListView());
		getListView().setAdapter(swingBottomInAdapter);
	}


	private class MyBaseAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 100;
		}

		@Override
		public String getItem(int position) {
			return String.format("Элемент номер: %d", position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if(convertView == null) {
				convertView = LayoutInflater.from(getBaseContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
			}
			((TextView)convertView.findViewById(android.R.id.text1)).setText(getItem(position));
			return convertView;
		}
	}
}
