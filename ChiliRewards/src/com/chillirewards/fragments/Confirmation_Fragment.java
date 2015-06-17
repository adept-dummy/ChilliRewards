package com.chillirewards.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.chilirewards.R;

public class Confirmation_Fragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.frag_promotion_confirmation, container,false);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		Button whatsapp= (Button) getActivity().findViewById(R.id.confirmation_button_whatsapp);
		whatsapp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentTransaction transaction=getFragmentManager().beginTransaction();
				Rating_fragment rate= new Rating_fragment();
				transaction.replace(R.id.rewards_mainLayout, rate);
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
	}
}
