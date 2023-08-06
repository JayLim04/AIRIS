package sg.edu.rp.c346.id21033869.airis;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.alan.alansdk.Alan;
import com.alan.alansdk.AlanCallback;
import com.alan.alansdk.AlanConfig;
import com.alan.alansdk.AlanState;
import com.alan.alansdk.button.AlanButton;
import com.alan.alansdk.events.EventCommand;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import java.util.Map;

public class VoiceCommands extends AppCompatActivity {

    private AlanButton alanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setContentView(R.layout.activity_main_page);

        /// Set up the Alan AI button
        AlanConfig config = AlanConfig.builder().setProjectId("").build();
        alanButton = findViewById(R.id.alan_button);
        alanButton.initWithConfig(config);

        AlanCallback alanCallback = new AlanCallback() {
            /// Handle commands from Alan AI Studio
            @Override
            public void onCommand(final EventCommand eventCommand) {
                try {
                    JSONObject command = eventCommand.getData();
                    String commandName = command.getJSONObject("data").getString("command");
                    Log.d("AlanButton", "onCommand: commandName: " + commandName);
                } catch (JSONException e) {
                    Log.e("AlanButton", e.getMessage());
                }
            }
        };

        /// Register callbacks
        alanButton.registerCallback(alanCallback);

//        AlanCallback alanCallback = new AlanCallback() {
//
//            /// Handle button state
//            @Override
//            public void onButtonState(AlanState alanState) {
//                Log.d("AlanButton", "onButtonState: " + alanState);
//            }
//        };

        alanButton.isActive();
        boolean enabled = alanButton.getWakewordEnabled();
        alanButton.setWakewordEnabled(true);
    }
    void setVisualState() {
        /// Providing any params
        JSONObject params = new JSONObject();
        try {
            params.put("data","your data");
        } catch (JSONException e) {
            Log.e("AlanButton", e.getMessage());
        }
        alanButton.setVisualState(params.toString());
    }

    void callProjectApi() {
        /// Providing any params
        JSONObject params = new JSONObject();
        try {
            params.put("data","your data");
        } catch (JSONException e) {
            Log.e("AlanButton", e.getMessage());
        }
        alanButton.callProjectApi("script::funcName", params.toString());
    }

    /// Playing any text message
    void playText() {
        /// Providing text as string param
        alanButton.playText("Hi");
    }

    /// Sending any text message
    void sendText() {
        /// Providing text as string param
        alanButton.sendText("Hello Alan, can you help me?");
    }

    /// Executing a command locally
    void playCommand() {
        /// Providing any params
        JSONObject params = new JSONObject();
        try {
            params.put("action","openSomePage");
        } catch (JSONException e) {
            Log.e("AlanButton", e.getMessage());
        }
        alanButton.playCommand(params.toString(), null);
    }

    /// Activating the Alan AI button programmatically
    void activate() {
        alanButton.activate();
    }

    /// Deactivating the Alan AI button programmatically
    void deactivate() {
        alanButton.deactivate();
    }

//
//    private void switchActivity(String command) {
//        // Implement the logic to switch between activities based on the command
//        if (command.equalsIgnoreCase("Open maps")) {
//            Intent intent = new Intent(this, MapsActivity.class);
//            startActivity(intent);
//        } else if (command.equalsIgnoreCase("Open camera")) {
//            Intent intent = new Intent(this, CameraActivity.class);
//            startActivity(intent);
//        }
//        // Add more cases for other activities you want to switch to
//    }
}