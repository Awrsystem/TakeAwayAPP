package br.com.takeaway;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityAtendente extends AppCompatActivity {

    TextView primeiraMensagem;
    private Button button;
    private EditText login;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atendente);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        primeiraMensagem = (TextView) findViewById(R.id.textViewInserirCredenciaisAtendente);
        primeiraMensagem.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));

        login = (EditText) findViewById(R.id.editTextLoginAtendente);
        login.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));

        senha = (EditText) findViewById(R.id.editTextSenhaAtendente);
        senha.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        senha.setOnKeyListener(new View.OnKeyListener(){

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event){

                if(keyCode == event.KEYCODE_ENTER){

                    trataExcecao(v);
                    Intent intent = new Intent(getApplicationContext(), ActivityAmbienteAtendenteRelatorioOuChamado.class);
                    startActivity(intent);
                    return true;

                }else {
                    return false;
                }
            }
        });

        button = (Button) findViewById(R.id.buttonValidaInfoAtendente);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                trataExcecao(view);
                Intent intent = new Intent(getApplicationContext(), ActivityAmbienteAtendenteRelatorioOuChamado.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
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