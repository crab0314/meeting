package com.crab.doit.meetingonline.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.crab.doit.meetingonline.R;
import com.crab.doit.meetingonline.utils.ToastUtils;

public class LoginActivity extends Activity {

    private EditText editTextUserId, editTextPassword;
    private CheckBox checkBoxPass;
    //private Button buttonLogin, buttonSignUp;
    private static final int SIGN_UP_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        editTextUserId = (EditText) findViewById(R.id.et_userId);
        editTextPassword = (EditText) findViewById(R.id.et_password);
        checkBoxPass = (CheckBox) findViewById(R.id.check_password);
        //buttonLogin = (Button) findViewById(R.id.bt_login);
        //buttonSignUp = (Button) findViewById(R.id.bt_signUp);
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.check_password:

                break;
            case R.id.bt_login:
                String name = editTextUserId.getText().toString();
                String password = editTextPassword.getText().toString();
                if (CheckForLogin(name, password) == true) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    showErrorToast();
                }
                break;
            case R.id.bt_signUp:
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivityForResult(intent, SIGN_UP_CODE);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SIGN_UP_CODE:
                if (resultCode == SignUpActivity.RESULT_OK) {
                    String userId = data.getStringExtra("userId");
                    String passWord = data.getStringExtra("password");
                    editTextUserId.setText(userId);
                    editTextPassword.setText(passWord);
                }
                break;
        }
    }

    //TODO 从网络请求数据查看密码账户是否正确
    public boolean CheckForLogin(String userId, String password) {
        if (userId.equals("pangjiaqi") && password.equals("hahaha")) return true;
        return false;
    }

    public void showErrorToast() {
        ToastUtils.ToastShort(LoginActivity.this, R.string.login_error);
        editTextUserId.setText("");
        editTextPassword.setText("");
    }

}
