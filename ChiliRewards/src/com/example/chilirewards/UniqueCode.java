package com.example.chilirewards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UniqueCode extends Activity implements OnClickListener{
	
	Button btn_submit;
	EditText et_uniqueCode;
	TextView tv_skip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uniquecode);
		
		View decorView = getWindow().getDecorView();
		int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
		decorView.setSystemUiVisibility(uiOptions);
		
		btn_submit=(Button) findViewById(R.id.button_submit);
		et_uniqueCode=(EditText) findViewById(R.id.edit_uniqueCode);
		tv_skip=(TextView) findViewById(R.id.text_skip);
		
		btn_submit.setOnClickListener(this);
		et_uniqueCode.setOnClickListener(this);
		tv_skip.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button_submit:
				Intent submitIntent= new Intent(UniqueCode.this, Login.class);
				startActivity(submitIntent);
			break;
			
		case R.id.text_skip:
			Intent textIntent= new Intent(UniqueCode.this, RewardsActivity.class);
			startActivity(textIntent);
		default:
			break;
		}
	}
}
