package sg.edu.rp.c346.id21033869.airis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alan.alansdk.AlanConfig;
import com.alan.alansdk.button.AlanButton;

public class mainPage extends AppCompatActivity {

    Button emBtn;
    Button contactBtn;
    Button locBtn;
    Button camBtn;
    Button settingsBtn;

    private AlanButton alanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Intent intent = getIntent();
        String value = intent.getStringExtra("username"); //if it's a string you stored.

        emBtn = findViewById(R.id.emergency);
        contactBtn = findViewById(R.id.contactBtn);
        locBtn = findViewById(R.id.locationBtn);
        camBtn = findViewById(R.id.cameraBtn);
        settingsBtn = findViewById(R.id.settingsBtn);

        emBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +995));
                startActivity(intentCall);
            }
        });

        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainPage.this, ContactsActivity.class);
                startActivity(intent);
            }
        });

        locBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainPage.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        camBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainPage.this, CameraActivity.class);
                startActivity(intent);
            }
        });

        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainPage.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

    }

}