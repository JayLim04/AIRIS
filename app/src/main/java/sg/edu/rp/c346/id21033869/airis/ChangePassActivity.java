package sg.edu.rp.c346.id21033869.airis;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChangePassActivity extends AppCompatActivity {

    Button changePassBtn;
    EditText etOldPass, etNewPass, etNewPass2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        changePassBtn = findViewById(R.id.changePassButton);
        etOldPass = findViewById(R.id.oldPass);
        etNewPass = findViewById(R.id.newPass);
        etNewPass2 = findViewById(R.id.newPass2);

        changePassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldPass = etOldPass.getText().toString();
                String newPass = etNewPass.getText().toString();
                String newPass2 = etNewPass2.getText().toString();

                if (oldPass.isEmpty() || newPass.isEmpty() || newPass2.isEmpty() ) {
                    // Show an error message indicating empty fields
                    Toast.makeText(ChangePassActivity.this, "Please fill up all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });


    }
}
