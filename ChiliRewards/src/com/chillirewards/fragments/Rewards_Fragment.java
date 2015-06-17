package com.chillirewards.fragments;

import com.chillirewards.constants.ConstantsClass;
import com.example.chilirewards.R;
import com.example.chilirewards.R.id;
import com.example.chilirewards.R.layout;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Rewards_Fragment extends Fragment implements OnClickListener {

	ImageButton btn_selector;
	ImageView image_promoterSelected;
	RelativeLayout rewards_promoterSelector;
	Button btn_plus, btn_minus, btn_confirm;
	TextView tv_people, tv_promoterImage, tv_promoted;
	FragmentManager manager;
	Promoters_selectorFragment promoters_selectorFragment;
	FragmentTransaction t;
	int position;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		btn_plus = (Button) getActivity()
				.findViewById(R.id.rewards_button_plus);
		btn_minus = (Button) getActivity().findViewById(
				R.id.rewards_button_minus);
		tv_people = (TextView) getActivity().findViewById(
				R.id.rewards_textView_peopleCount);
		btn_confirm = (Button) getActivity().findViewById(
				R.id.rewards_button_confirm);
		rewards_promoterSelector = (RelativeLayout) getActivity().findViewById(
				R.id.rewards_SelectPromoterLayout);
		tv_promoted = (TextView) getActivity().findViewById(
				R.id.rewards_text_SelectPromoter);
		image_promoterSelected = (ImageView) getActivity().findViewById(
				R.id.rewards_image_promoterSelectorIcon);

		btn_plus.setOnClickListener(this);
		btn_minus.setOnClickListener(this);
		btn_confirm.setOnClickListener(this);
		rewards_promoterSelector.setOnClickListener(this);

		manager = getFragmentManager();

		position = Promoters_selectorFragment.pos;
		if (position != -1) {
			tv_promoted.setText("Promoted through "
					+ ConstantsClass.bank_names[position]);
			image_promoterSelected.setVisibility(View.VISIBLE);
			image_promoterSelected
					.setImageResource(ConstantsClass.bank_images[position]);
		}

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.frag_rewards, container, false);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String x = (String) tv_people.getText().toString();

		t = manager.beginTransaction();
		int count = Integer.parseInt(x);

		switch (v.getId()) {

		case R.id.rewards_button_plus:

			count = count + 1;
			tv_people.setText(String.valueOf(count));
			break;

		case R.id.rewards_button_minus:

			if (count != 0) {
				count = count - 1;
			}
			tv_people.setText(String.valueOf(count));
			break;

		case R.id.rewards_SelectPromoterLayout:
			// adding the fragment to navigate to the selector screen

			promoters_selectorFragment = new Promoters_selectorFragment();
			t=getFragmentManager().beginTransaction();
			t.replace(R.id.rewards_mainLayout, promoters_selectorFragment);
			t.commit();
			break;

		case R.id.rewards_button_confirm:
			// adding the reward confirmation view upon clicking confirm button

			Confirmation_Fragment confirmation = new Confirmation_Fragment();
			t=getFragmentManager().beginTransaction();
			t.replace(R.id.rewards_mainLayout, confirmation);
			t.addToBackStack(null);
			t.commit();

		default:
			break;
		}

	}

}
