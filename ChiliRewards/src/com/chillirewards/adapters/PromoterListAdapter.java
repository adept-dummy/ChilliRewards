package com.chillirewards.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.chilirewards.R;

public class PromoterListAdapter extends ArrayAdapter<String> {

	int i = 0;
	Context context;
	String[] strings;
	int[] is;
	int[] images;
	ImageView bankIcon, selected;

	public PromoterListAdapter(Context context, int resource,
			String[] stringsed, int[] convertView, int[] select) {
		super(context, resource, stringsed);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.strings = stringsed;
		this.is = convertView;
		this.images = select;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = layoutInflater
				.inflate(R.layout.promoter_listview_row, null);
		selected = (ImageView) view.findViewById(R.id.promoters_selection_tick);
		bankIcon = (ImageView) view.findViewById(R.id.promoters_bankIcons);
		bankIcon.setImageResource(is[position]);
		TextView textView = (TextView) view
				.findViewById(R.id.promoters_bankNames);
		textView.setText(strings[position]);
		textView.setTextColor(Color.BLACK);
		selected.setImageResource(images[position]);
		/*
		 * ToggleButton toggleButton = (ToggleButton) view
		 * .findViewById(R.id.promoters_selectionToggle); // toggleButton.set
		 */
		return view;

	}

}
