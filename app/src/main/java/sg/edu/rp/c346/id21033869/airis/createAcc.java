package sg.edu.rp.c346.id21033869.airis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class createAcc extends AppCompatActivity {
    EditText etEmail;
    EditText etPass;
    EditText etFName;
    EditText etLName;
    RadioButton rbHandler;
    Button btnCreate;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);

        etEmail = findViewById(R.id.createEmail);
        etPass = findViewById(R.id.createPass);
        etFName = findViewById(R.id.nameFirst);
        etLName = findViewById(R.id.nameLast);
        rbHandler = findViewById(R.id.handlerRadBtn);
        btnCreate = findViewById(R.id.createBtn);
        mAuth = FirebaseAuth.getInstance();

    btnCreate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String email = etEmail.getText().toString();
            String password = etPass.getText().toString();
            String firstName = etFName.getText().toString();
            String lastName = etLName.getText().toString();

            if (email.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
                // Show an error message indicating empty fields
                Toast.makeText(createAcc.this, "Please fill up all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(createAcc.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();

                                // Set the display name
                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(firstName +" "+lastName)
                                        .build();
                                finish();
                            } else {
                                Toast.makeText(createAcc.this, "Invalid information. Please try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }
    });

    }
}