package com.crab.doit.meetingonline.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.crab.doit.meetingonline.R;
import com.crab.doit.meetingonline.utils.ToastUtils;

/**
 * Created by pangjiaqi on 2016/11/30.
 */

public class SignUpActivity extends Activity {
    //public static int signUpStatus;
    public static final int RESULT_OK = 200;
    public static final int RESULI_EMPTY = 400;

    private EditText editTextNickName, editPassword, editPassConfirm;
    private Button buttonSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editTextNickName= (EditText) findViewById(R.id.et_name);
        editPassword = (EditText) findViewById(R.id.et_password);
        editPassConfirm = (EditText) findViewById(R.id.et_password_again);
        buttonSignup = (Button) findViewById(R.id.bt_signUp);
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.bt_signUp:
                String pass1 = editPassword.getText().toString();
                String pass2 = editPassConfirm.getText().toString();
                if (checkPassword(pass1, pass2) == false) {
                    editPassword.setText("");
                    editPassConfirm.setText("");
                    ToastUtils.ToastShort(SignUpActivity.this, R.string.pass_different);
                } else if (TextUtils.isEmpty(editTextNickName.getText().toString().trim()) ||
                        editTextNickName.getText().toString().trim().length() < 6 ||
                        editTextNickName.getText().toString().trim().length() > 16) {
                    ToastUtils.ToastShort(SignUpActivity.this, R.string.nickname_none);
                } else if (TextUtils.isEmpty(editPassword.getText().toString()) ||
                        TextUtils.isEmpty(editPassConfirm.getText().toString())) {
                    ToastUtils.ToastShort(SignUpActivity.this, R.string.pass_none);
                } else {
                    String userId = requestForUserId();
                    Intent intent=new Intent();
                    intent.putExtra("userId",userId);
                    intent.putExtra("password",pass1);
                    setResult(RESULT_OK,intent);
                    ToastUtils.ToastShort(SignUpActivity.this,R.string.sign_success);
                    finish();
                }
                break;
            default:
                break;
        }
    }

    //检查两次密码是否一致
    public boolean checkPassword(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        return false;
    }

    public String requestForUserId() {
        return "pangjiaqi";
    }
}
