package com.example.chilirewards;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.chillirewards.fragments.Rewards_Fragment;

public class RewardsActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rewards);

		FragmentManager fragmentManager = getFragmentManager();
		Rewards_Fragment fragment = new Rewards_Fragment();
		FragmentTransaction t = fragmentManager.beginTransaction();
		t.replace(R.id.rewards_mainLayout, fragment);
		t.commit();

	}

	@Override
	public void onBackPressed() {
		if (getFragmentManager().getBackStackEntryCount() == 0) {
			this.finish();
		} else {
			getFragmentManager().popBackStack();
		}
	}

}
