package com.example.nounours.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nounours.Controllers.LoginController;
import com.example.nounours.R;

public class LoginActivity extends AppCompatActivity {
    private EditText UserEmail;
    private EditText Password;
    private Button Login;
    public static Activity fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserEmail = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        Login = findViewById(R.id.login);

        fa = this;

        final String[] username = {""};
        final String[] password = {""};

        LoginController controller = new LoginController();

        Login.setEnabled(false);

        UserEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) { username[0] = s.toString(); }
        });

        Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Login.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                password[0] = s.toString();
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String token = controller.getToken();

                if (token != null) {
                controller.getLogin(username[0], password[0], token);
                }
                else {
                }
            }
        });
    }
}