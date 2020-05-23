package br.com.takeaway;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityFinalizaCadastro extends AppCompatActivity {

    private TextView mensagemFinal;
    private Button voltaParaOLogin;
    private Button voltaParaAHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finaliza_cadastro);

        mensagemFinal = (TextView) findViewById(R.id.cadastroFinalizado);
        mensagemFinal.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));

        voltaParaOLogin = (Button) findViewById(R.id.buttonVoltaParaATelaDeLogin);
        voltaParaOLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ActivityLogin.class);
                startActivity(intent);
            }
        });

        voltaParaAHome = (Button) findViewById(R.id.buttonVoltaParaATelaPrincipal);
        voltaParaAHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
