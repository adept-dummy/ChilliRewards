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

public class Rating_fragment extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.frag_rating, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		Button ratingShare=(Button) getActivity().findViewById(R.id.rating_button_share);
		ratingShare.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Rating_ThankYou_Fragment thankYou= new Rating_ThankYou_Fragment();
				FragmentTransaction t= getFragmentManager().beginTransaction();
				t.replace(R.id.rewards_mainLayout, thankYou);
				t.addToBackStack(null);
				t.commit();
				
			}
		});
		
		
	}
	
}
