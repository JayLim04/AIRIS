package sg.edu.rp.c346.id21033869.airis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainPage extends AppCompatActivity {

    Button contactBtn;
    Button locBtn;
    Button camBtn;
    Button settingsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Intent intent = getIntent();
        String value = intent.getStringExtra("username"); //if it's a string you stored.

        contactBtn = findViewById(R.id.contactBtn);
        locBtn = findViewById(R.id.locationBtn);
        camBtn = findViewById(R.id.cameraBtn);
        settingsBtn = findViewById(R.id.settingsBtn);

        camBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainPage.this, CameraActivity.class);
                startActivity(intent);
            }
        });

    }

}