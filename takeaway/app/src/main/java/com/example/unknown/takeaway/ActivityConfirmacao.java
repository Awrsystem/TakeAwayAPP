package br.com.takeaway;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import model.dal_clientes.Clientes;
import model.dal_funcionarios.Funcionarios;

public class ActivityConfirmacao extends AppCompatActivity {

    private TextView confirmarDados;
    private TextView confirmaNome;
    private TextView nome;
    private TextView confirmaApelido;
    private TextView apelido;
    private TextView confirmaDataDeNascimento;
    private TextView dataDeNascimento;
    private TextView confirmanif;
    private TextView nif;
    private TextView confirmaEndereco;
    private TextView endereco;
    private TextView confirmaTelefone;
    private TextView telefone;
    private TextView confirmaEmail;
    private TextView email;
    private TextView confirmaSenha;
    private TextView senha;
    private Button buttonFinalizarCadastro;

    private Clientes cliente;

    private Funcionarios funcionarios;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cliente = populateCliente(getIntent());

        funcionarios = populateFuncionarios();

        confirmarDados = prepareField(findViewById(R.id.textViewConfirmaDadosDeCadastro));

        confirmaNome = prepareField(findViewById(R.id.confirmaNome));

        nome = prepareField(findViewById(R.id.nome), getIntent().getStringExtra("nome"));

        confirmaApelido = prepareField(findViewById(R.id.confirmaApelido));

        apelido = prepareField(findViewById(R.id.apelido), getIntent().getStringExtra("apelido"));

        confirmaDataDeNascimento = prepareField(findViewById(R.id.confirmaDataNascimento));

        dataDeNascimento = prepareField(findViewById(R.id.dataNascimento), getIntent().getStringExtra("data_nascimento"));

        confirmanif = prepareField(findViewById(R.id.confirmanif));

        nif = prepareField(findViewById(R.id.nif), getIntent().getStringExtra("nif"));

        confirmaEndereco = prepareField(findViewById(R.id.confirmaEndereco));

        endereco = prepareField(findViewById(R.id.endereco), getIntent().getStringExtra("endereco"));

        confirmaTelefone = prepareField(findViewById(R.id.confirmaTelefone));

        telefone = prepareField(findViewById(R.id.telefone), getIntent().getStringExtra("telefone"));

        confirmaEmail = prepareField(findViewById(R.id.confirmaEmail));

        email = prepareField(findViewById(R.id.email), getIntent().getStringExtra("email"));

        confirmaSenha = prepareField(findViewById(R.id.confirmaSenha));

        senha = prepareField(findViewById(R.id.senha), getIntent().getStringExtra("senha"));

        buttonFinalizarCadastro = (Button) findViewById(R.id.buttonFinalizarCadastro);
        buttonFinalizarCadastro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                model.dal_clientes.Update updateDatabase = new model.dal_clientes.Update(getApplicationContext());
                updateDatabase.insertCliente(cliente);

                model.dal_funcionarios.Update insertFuncionario = new model.dal_funcionarios.Update(getApplicationContext());
                insertFuncionario.insertFuncionario(funcionarios);

                Intent intent = new Intent(getApplicationContext(), ActivityFinalizaCadastro.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


    private Clientes populateCliente(Intent intent) {

        Clientes cliente = new Clientes();

        cliente.setNome(intent.getStringExtra("nome"));
        cliente.setApelido(intent.getStringExtra("apelido"));
        cliente.setDataNascimento(intent.getStringExtra("data_nascimento"));
        cliente.setNif(intent.getStringExtra("nif"));
        cliente.setEndereco(intent.getStringExtra("endereco"));
        cliente.setTelefone(intent.getStringExtra("telefone"));
        cliente.setEmail(intent.getStringExtra("email"));
        cliente.setSenha(intent.getStringExtra("senha"));

        return cliente;
    }

    private Funcionarios populateFuncionarios(){

        Funcionarios funcionarios = new Funcionarios();

        funcionarios.setNome("Amanda");
        funcionarios.setSexo("Feminino");

        return funcionarios;
    }

    private TextView prepareField(View view) {

        TextView textView = (TextView) view;
        textView.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));

        return textView;
    }

    private TextView prepareField(View view, String value) {

        TextView textView = (TextView) view;
        textView.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        textView.setText(value);

        return textView;
    }
}