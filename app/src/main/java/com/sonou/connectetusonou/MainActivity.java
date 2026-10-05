package com.sonou.connectetusonou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText login ,motpasse;
    private MaterialButton btn, btn_inscription;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.etlogin);
        motpasse = findViewById(R.id.etpassword);
        btn = findViewById(R.id.btnconnexion);
        btn_inscription = findViewById(R.id.btninscription);


       btn_inscription.setOnClickListener(View -> {
            Intent intent = new Intent( MainActivity.this,activity_inscription.class);
            startActivity(intent);
        });
        btn.setOnClickListener(View ->{
            String login_str = login.getText().toString();
            String mdp_str = motpasse.getText().toString();
            if (login_str.isEmpty()) {
                login.setError("Veuillez entrez le login");
                login.requestFocus();
                return;
            }
            if (mdp_str.isEmpty()) {
                motpasse.setError("Veuillez entrez le mot de passe");
                motpasse.requestFocus();
                return;
            }
            RetrofitCli.executionretrofit().execInscription(login_str,mdp_str).enqueue(new Toast.Callback())
            Toast.makeText(this, "Bienvenue sur notre application" , Toast.LENGTH_SHORT).show();
        });

    }
}