package sg.edu.rp.c346.id21033869.airis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alan.alansdk.AlanConfig;
import com.alan.alansdk.button.AlanButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText etPass;
    private EditText etUser;
    private Button btnLogin;
    private TextView btnNewAcc;

    private AlanButton alanButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etPass = findViewById(R.id.editPass);
        etUser = findViewById(R.id.editUser);
        btnLogin = findViewById(R.id.btnLogin);
        btnNewAcc = findViewById(R.id.accText);

        mAuth = FirebaseAuth.getInstance();

        AlanConfig config = AlanConfig.builder().setProjectId("81c38e61708769f036394d63ca557ae32e956eca572e1d8b807a3e2338fdd0dc/stage").build();
        alanButton = findViewById(R.id.alan_button);
        alanButton.initWithConfig(config);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etUser.getText().toString();
                String password = etPass.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    // Show an error message indicating empty fields
                    Toast.makeText(MainActivity.this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(MainActivity.this, mainPage.class);
                                    startActivity(intent);
                                } else {
                                    showLoginFailedDialog();
                                }
                            }
                        });
            }
        });

        btnNewAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, createAcc.class);
                startActivity(intent);
            }
        });
    }

    private void showLoginFailedDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Invalid username or password. Please try again.")
                .setCancelable(true)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

//    void setVisualState() {
//        /// Providing any params
//        JSONObject params = new JSONObject();
//        try {
//            params.put("data","your data");
//        } catch (JSONException e) {
//            Log.e("AlanButton", e.getMessage());
//        }
//        alanButton.setVisualState(params.toString());
//    }
}
