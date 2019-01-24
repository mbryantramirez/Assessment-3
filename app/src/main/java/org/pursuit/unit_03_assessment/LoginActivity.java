package org.pursuit.unit_03_assessment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.pursuit.unit_03_assessment.R;

public class LoginActivity extends AppCompatActivity {
    public static final String MY_PREFS = "MyPrefs";
    private static String getUserName;
    private static boolean getCheckbox;
    private EditText emailView;
    private EditText passwordView;
    private CheckBox usernameCheckbox;
    SharedPreferences retrievePrefernces = getSharedPreferences(MY_PREFS, MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailView = (EditText) findViewById(R.id.email_edittext);
        passwordView = (EditText) findViewById(R.id.password_edittext);
        usernameCheckbox = (CheckBox) findViewById(R.id.remember_username_checkbox);


        String editUserName = emailView.getText().toString();
        String editPassword = passwordView.getText().toString();
        Boolean checkUserNameCheckbox = Boolean.valueOf(usernameCheckbox.getText().toString());

        passwordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        SharedPreferences pref = getApplicationContext().getSharedPreferences(MY_PREFS, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("Edit email", "Gregg");
        editor.putString("input password", "Pursuit");
        editor.putBoolean("checkbox", true);
        editor.apply();


        String getUserName = pref.getString("Edit email", "Gregg");
        String getPassword = pref.getString("input password", "Pursuit");
        Boolean getCheckbox = pref.getBoolean("checkbox", true);


        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    private void attemptLogin() {

        emailView.setError(null);
        passwordView.setError(null);

        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passwordView.setError(getString(R.string.error_invalid_password));
            focusView = passwordView;
            cancel = true;
        }
        if (TextUtils.isEmpty(email)) {
            emailView.setError(getString(R.string.error_field_required));
            focusView = emailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            emailView.setError(getString(R.string.error_invalid_email));
            focusView = emailView;
            cancel = true;
        } else {
            access();
            correct();
            accessGranted();
            ticked();
            notTicked();

        }

        if (cancel) {
            focusView.requestFocus();
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    public static void getViews(){


    public static String access(SharedPreferences) {
        if (getUserName != null && !getCheckbox) {
            editUserName = getCheckbox.toString();
            String s;
            checkUserNameCheckbox = getCheckbox;
        }
        return access();
    }


    public static boolean correct() {
        if (editUserName.equals(getString(R.id.dummy_username)) && editPassword.equals(getString(R.id.dummy_password))) {

        }
        return true;
    }

    //3
    public static boolean ticked() {
        if (editUserName.equals(getString(R.id.dummy_username)) && editPassword.equals(getString(R.id.dummy_password))) {
            getUserName = editUserName;
            getCheckbox = checkUserNameCheckbox.valueOf(checkUserNameCheckbox);
        }
        return ticked();
    }

    public static boolean notTicked() {
        if (!checkUserNameCheckbox) {
            getUserName = " ";

        }
        return notTicked();
    }

    public void accessGranted() {
        if (editUserName.equals(
                getString(R.id.dummy_username)) && editPassword.equals(
                getString(R.id.dummy_password))) {
            Intent intent = new Intent(getApplicationContext(), RecyclerActivity.class);
            startActivity(intent);

        }
    }

    ;




