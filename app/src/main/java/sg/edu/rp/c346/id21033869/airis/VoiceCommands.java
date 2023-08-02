package sg.edu.rp.c346.id21033869.airis;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.alan.alansdk.Alan;
import com.alan.alansdk.AlanCallback;
import com.alan.alansdk.AlanConfig;
import com.alan.alansdk.button.AlanButton;
import com.alan.alansdk.events.EventCommand;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.Map;

import java.util.Map;

public class VoiceCommands extends MainActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Register Alan AI callback to handle voice command responses
        AlanCallback callback = new AlanCallback() {
            public void onCommandReceived(Map<String, String> data) {
                String command = data.get("command");
                if (command != null) {
                    // Handle the voice command here
                    switchActivity(command);
                }
            }
            public void onError(int code, String error) {
                // Handle error responses from Alan AI if needed
            }
        };

        Alan.getInstance().setCallback(callback);
    }

    private void switchActivity(String command) {
        // Implement the logic to switch between activities based on the command
        if (command.equalsIgnoreCase("Open maps")) {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        } else if (command.equalsIgnoreCase("Open camera")) {
            Intent intent = new Intent(this, CameraActivity.class);
            startActivity(intent);
        }
        // Add more cases for other activities you want to switch to
    }
}