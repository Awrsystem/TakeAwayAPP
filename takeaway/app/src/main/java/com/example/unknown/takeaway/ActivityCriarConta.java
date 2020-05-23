package com.example.unknown.meuacai;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityCriarConta extends AppCompatActivity {

    private TextView insiraSeusDados;
    private EditText nome;
    private EditText apelido;
    private EditText dataDeNascimento;
    private EditText nif;
    private EditText telefone;
    private EditText email;
    private EditText senha;
    private EditText endereco;
    private Button confirmarCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        insiraSeusDados = (TextView) findViewById(R.id.insiraSeusDados);
        insiraSeusDados.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));

        nome = (EditText) findViewById(R.id.nome);
        nome.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));

        apelido = (EditText) findViewById(R.id.apelido);
        apelido.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));

        dataDeNascimento = (EditText) findViewById(R.id.dataDeNascimento);
        dataDeNascimento.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));

        nif = (EditText) findViewById(R.id.nif);
        nif.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));

        telefone = (EditText) findViewById(R.id.telefone);
        telefone.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));

        endereco = (EditText) findViewById(R.id.endereco);
        endereco.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));

        email = (EditText) findViewById(R.id.email);
        email.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));

        senha = (EditText) findViewById(R.id.senha);
        senha.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        senha.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode == event.KEYCODE_ENTER) {

                    Intent intent = new Intent(getApplicationContext(), ActivityConfirmacao.class);

                    intent.putExtra("nome", nome.getText().toString());
                    intent.putExtra("apelido", apelido.getText().toString());
                    intent.putExtra("data_nascimento", dataDeNascimento.getText().toString());
                    intent.putExtra("nif", nif.getText().toString());
                    intent.putExtra("endereco", endereco.getText().toString());
                    intent.putExtra("telefone", telefone.getText().toString());
                    intent.putExtra("email", email.getText().toString());
                    intent.putExtra("senha", senha.getText().toString());

                    startActivity(intent);
                    return true;

                } else {
                    return false;
                }
            }
        });

        confirmarCadastro = (Button) findViewById(R.id.buttonConfirmarCadastro);
        confirmarCadastro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ActivityConfirmacao.class);

                intent.putExtra("nome", nome.getText().toString());
                intent.putExtra("apelido", apelido.getText().toString());
                intent.putExtra("data_nascimento", dataDeNascimento.getText().toString());
                intent.putExtra("nif", nif.getText().toString());
                intent.putExtra("endereco", endereco.getText().toString());
                intent.putExtra("telefone", telefone.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("senha", senha.getText().toString());

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}