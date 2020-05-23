package br.com.takeaway;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityLogin extends AppCompatActivity {

    private TextView primeiraMensagem;
    private Button button;
    private EditText login;
    private EditText senha;
    private TextView mensagemAntesDeCriarConta;
    private TextView criarConta;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        primeiraMensagem = (TextView) findViewById(R.id.textViewInserirCredenciaisUsuario);
        primeiraMensagem.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));

        login = (EditText) findViewById(R.id.editTextLogin);
        login.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));

        senha = (EditText) findViewById(R.id.editTextSenha);
        senha.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        senha.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode == event.KEYCODE_ENTER) {

                    trataExcecao(v);
                    Intent intent = new Intent(getApplicationContext(), ActivityAberturaChamado.class);
                    startActivity(intent);
                    return true;

                } else {
                    return false;
                }
            }
        });

        mensagemAntesDeCriarConta = (TextView) findViewById(R.id.mensagemAntesDeCriarConta);
        mensagemAntesDeCriarConta.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));

        criarConta = (TextView) findViewById(R.id.textViewCriarConta);
        criarConta.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        criarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ActivityCriarConta.class);
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.buttonSubmitInfo);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                trataExcecao(view);
                Intent intent = new Intent(getApplicationContext(), ActivityAberturaChamado.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    void trataExcecao(View view) {

      
        if (login.getText().toString().trim().length() <= 0 ||
                senha.getText().toString().trim().length() <= 0) {
            snackBarMaker(view, "Um dos campos está vazio!");
            return;
        }
    }

    void snackBarMaker(View v, String mensagem) {

        Snackbar.make(v, mensagem, Snackbar.LENGTH_INDEFINITE)
                .setAction("OK", new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                    
                    }
                }).show();
    }
}