package sg.edu.rp.c346.id21033869.airis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etPass;
    EditText etEmail;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    etPass = findViewById(R.id.editPass);
    etEmail = findViewById(R.id.editEmail);
    btnLogin = findViewById(R.id.login);
    }
}