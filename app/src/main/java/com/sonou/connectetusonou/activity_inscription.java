package com.sonou.connectetusonou;

import static com.sonou.connectetusonou.R.id.btnvalider;
import static com.sonou.connectetusonou.R.id.etnom;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class activity_inscription extends AppCompatActivity {
    private MaterialButton btn_valider ,btn_jaicompte;
    private TextInputEditText login, motpasse,confmdp,nom,prenom,sexe;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inscription);

        login = findViewById(R.id.etlogin);
        motpasse = findViewById(R.id.etpassword);
        confmdp = findViewById(R.id.etconfmdp);
        nom = findViewById(R.id.etnom);
        prenom = findViewById(R.id.etprenom);
        sexe = findViewById(R.id.spinnerSexe);


    btn_valider.setOnClickListener(View -> {
        String login_str = login.getText().toString();
        String mdp_str = motpasse.getText().toString();
        String confmd = confmdp.getText().toString();
        String sexes = sexe.getText().toString();
        String noms = nom.getText().toString();
        String prenoms = prenom.getText().toString();
    });
  
    RetrofitCli.executionretrofit().execInscription(nom,prenom,sexe,motpasse,login,confmdp);



   /*    btn_jaicompte = findViewById(R.id.jaicompte);

        btn_jaicompte.setOnClickListener(View -> {
            Intent intent = new Intent( activity_inscription.this,MainActivity.class);
            startActivity(intent);
            finish();
        });*/

    }
}