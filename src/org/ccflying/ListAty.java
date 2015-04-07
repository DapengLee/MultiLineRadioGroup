package org.ccflying;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class ListAty extends Activity {
	private ListView lv;
	private List<String> list;
	private Adapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aty_list);
		lv = (ListView) findViewById(R.id.lv);
		list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		adapter = new Adapter();
		lv.setAdapter(adapter);
	}

	class Adapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 1;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = getLayoutInflater().inflate(R.layout.list_item, null);
			MultiLineRadioGroup rg = (MultiLineRadioGroup) v
					.findViewById(R.id.content);
			rg.addAll(list);
			return v;
		}
	}
}
