package org.ccflying;

import org.ccflying.MultiLineRadioGroup.OnCheckedChangedListener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener,
		OnCheckedChangedListener {
	private MultiLineRadioGroup group;
	private EditText mInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.append).setOnClickListener(this);
		findViewById(R.id.clearchecked).setOnClickListener(this);
		findViewById(R.id.getchecked).setOnClickListener(this);
		findViewById(R.id.toggleMode).setOnClickListener(this);
		findViewById(R.id.insert).setOnClickListener(this);
		findViewById(R.id.remove).setOnClickListener(this);
		findViewById(R.id.setChecked).setOnClickListener(this);
		mInput = (EditText) findViewById(R.id.insert_position);
		group = (MultiLineRadioGroup) findViewById(R.id.content);
		group.setOnCheckChangedListener(this);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		int j = -1;
		switch (v.getId()) {
		case R.id.append:
			group.append("Append>>" + group.getChildCount());
			break;
		case R.id.clearchecked:
			group.clearChecked();
			break;
		case R.id.getchecked:
			int[] cs = group.getCheckedItems();
			if (cs == null || cs.length == 0) {
				Toast.makeText(this, "none checked current!",
						Toast.LENGTH_SHORT).show();
			} else {
				String str = "";
				for (int i : cs) {
					str += i + ",";
				}
				Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.toggleMode:
			if (group.isSingleChoice()) {
				group.setChoiceMode(false);
			} else {
				group.setChoiceMode(true);
			}
			break;
		case R.id.insert:
			j = getFunkIndex();
			if (j >= 0) {
				boolean bl = group.insert(j,
						"Inserted>" + group.getChildCount());
				if (bl) {
					Toast.makeText(this, "Inserted child at " + j,
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(this, "Invalid position!",
							Toast.LENGTH_SHORT).show();
				}
			}
			break;
		case R.id.remove:
			j = getFunkIndex();
			if (j >= 0) {
				boolean bl = group.remove(j);
				if (bl) {
					Toast.makeText(this, "Child " + j + " removed!",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(this, "Invalid position!",
							Toast.LENGTH_SHORT).show();
				}
			}
			break;
		case R.id.setChecked:
			j = getFunkIndex();
			if (j >= 0) {
				boolean bl = group.setItemChecked(j);
				if (bl) {

				} else {
					Toast.makeText(this, "Invalid position!",
							Toast.LENGTH_SHORT).show();
				}
			}
			break;
		}
	}

	protected int getFunkIndex() {
		try {
			return Integer.valueOf(mInput.getText().toString());
		} catch (Exception e) {
			Toast.makeText(this, "Please input a number!", Toast.LENGTH_SHORT)
					.show();
			return -1;
		}
	}

	@Override
	public void onItemChecked(MultiLineRadioGroup group, int position) {
		Log.e("MainActivity", "poi:" + position);
	}
}
