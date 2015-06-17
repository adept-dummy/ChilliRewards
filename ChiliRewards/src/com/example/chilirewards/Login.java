package com.example.chilirewards;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {
	
	Button btn_facebookLogin, btn_submit;
	EditText et_email, et_pwd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		View decorView = getWindow().getDecorView();
		int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
		decorView.setSystemUiVisibility(uiOptions);
		
		btn_facebookLogin=(Button) findViewById(R.id.login_facebook);
		btn_submit=(Button) findViewById(R.id.login_button_signin);
		et_email=(EditText) findViewById(R.id.login_edit_email);
		et_pwd=(EditText) findViewById(R.id.login_edit_pwd);
	}
}
