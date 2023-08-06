package sg.edu.rp.c346.id21033869.airis;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ContactsActivity extends AppCompatActivity {

    Button btnJohn, btnJim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        btnJohn = findViewById(R.id.buttonCallJohn);
        btnJim = findViewById(R.id.buttonCallJim);

        btnJohn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +92240336));
                startActivity(intentCall);
            }
        });

        btnJim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +89675543));
                startActivity(intentCall);
            }
        });
    }

}
