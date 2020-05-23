package br.com.takeaway;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import model.dal_clientes.Clientes;
import model.dal_funcionarios.Funcionarios;
import model.dal_pedidos.Pedidos;

public class MainActivity extends AppCompatActivity {

    private Button cliente;
    private Button atendente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model.dal_clientes.Create c = new model.dal_clientes.Create(getApplicationContext());
        c.createTable();

        model.dal_funcionarios.Create f = new model.dal_funcionarios.Create(getApplicationContext());
        f.createTable();

        model.dal_pedidos.Create p = new model.dal_pedidos.Create(getApplicationContext());
        p.createTable();

        model.dal_clientes.Read r = new model.dal_clientes.Read(getApplicationContext());
        ArrayList<Clientes> pArray = r.getClientes();

        for (int i = 0; i < pArray.size(); i++) {
            Clientes clientes = pArray.get(i);
            System.out.println(

                    " ID: " + clientes.getId() + "   /   "
                            + " NOME: " + clientes.getNome() + "   /   "
                            + "APELIDO: " + clientes.getApelido() + "   /   "
                            + "DATA DE NASCIMENTO: " + clientes.getDataNascimento() + "   /   "
                            + "NIF: " + clientes.getNif() + "   /   "
                            + "ENDERECO: " + clientes.getEndereco() + "   /   "
                            + "TELEFONE: " + clientes.getTelefone() + "   /   "
                            + "EMAIL: " + clientes.getEmail() + "   /   "
                            + "SENHA: " + clientes.getSenha());
        }

        model.dal_funcionarios.Read func = new model.dal_funcionarios.Read(getApplicationContext());
        ArrayList<Funcionarios> fArray = func.getFuncionarios();

        for (int i = 0; i < fArray.size(); i++) {
            Funcionarios funcionarios = fArray.get(i);

            System.out.println(

                    " ID: " + funcionarios.getId() + "   /   "
                            + " NOME: " + funcionarios.getNome() + "   /   "
                            + "SEXO: " + funcionarios.getSexo());
        }

        model.dal_pedidos.Read pedidos = new model.dal_pedidos.Read(getApplicationContext());
        ArrayList<Pedidos> pedidosArray = pedidos.getPedidos();

        for (int i = 0; i < pedidosArray.size(); i++) {
            Pedidos pedidos1 = pedidosArray.get(i);

            System.out.println(

                    " PROTOCOLO: " + pedidos1.getProtocolo() + "   /   "
                            + " PRECO: " + pedidos1.getPreco() + "   /   "
                            + "DATA_ABERTURA: " + pedidos1.getDataAberturaDoPedido() + "   /   "
                            + "DATA_FECHAMENTO: " + pedidos1.getDataFechamentoDoPedido());
        }

        cliente = prepareButton(findViewById(R.id.buttonCliente));
        cliente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ActivityLogin.class);
                startActivity(intent);
            }
        });

        atendente = prepareButton(findViewById(R.id.buttonAtendente));
        atendente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ActivityAtendente.class);
                startActivity(intent);
            }
        });
    }

    private Button prepareButton(View view) {

        Button button = (Button) view;
        button.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));

        return button;
    }
}