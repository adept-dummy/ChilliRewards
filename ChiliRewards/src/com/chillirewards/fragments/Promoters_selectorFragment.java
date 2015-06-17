package com.chillirewards.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.chillirewards.adapters.PromoterListAdapter;
import com.chillirewards.constants.ConstantsClass;
import com.example.chilirewards.R;

public class Promoters_selectorFragment extends Fragment {

	TextView tv;
	View view;
	Fragment fragment;
	ListView listView;
	public PromoterListAdapter promoter_adapter;
	ImageView selected;
	public static int pos = -1;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) { // TODO Auto-generated method stub

		View view = inflater.inflate(R.layout.frag_promoterselector, container,
				false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		listView = (ListView) getActivity().findViewById(
				R.id.promoters_listView);

		promoter_adapter = new PromoterListAdapter(getActivity(),
				R.layout.promoter_listview_row, ConstantsClass.bank_names,
				ConstantsClass.bank_images, ConstantsClass.select);
		listView.setAdapter(promoter_adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int arg2,
					long arg3) {
				// TODO Auto-generated method stub

				pos = arg2;

				for (int i = 0; i < ConstantsClass.bank_names.length; i++) {
					TextView tv = (TextView) v
							.findViewById(R.id.promoters_bankNames);

					if (tv.getText().equals(ConstantsClass.bank_names[i])) {
						ConstantsClass.select[i] = R.drawable.tick_selected;

					} else {
						ConstantsClass.select[i] = R.drawable.tick_unselected;
					}

				}
				promoter_adapter.notifyDataSetChanged();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();
				Rewards_Fragment rewards_Fragment = new Rewards_Fragment();
				transaction.replace(R.id.rewards_mainLayout, rewards_Fragment);
				transaction.commit();
			}

		});

	}

}
