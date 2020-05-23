package br.com.takeaway;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import model.dal_pedidos.Pedidos;

public class ActivityConfirmaPedido extends AppCompatActivity {

    private TextView mostraQuantidade;
    private TextView mostraPeso;
    private TextView mostraCoberturas;
    private TextView mostraPrecoFinal;
    private Button formasDePagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_pedido);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Pedidos pedidos = populaPedido(getIntent());

        mostraQuantidade = (TextView) findViewById(R.id.mostraQuantidade);
        mostraQuantidade.setText("Quantidade: " + getIntent().getStringExtra("quantidade"));

        mostraPeso = (TextView) findViewById(R.id.mostraPeso);
        verificaPeso(getIntent().getStringExtra("peso"));

        mostraPrecoFinal = (TextView) findViewById(R.id.mostraPrecoFinal);
        mostraPrecoFinal.setText("Preço Final: " + getIntent().getStringExtra("precoFinal"));

        formasDePagamento = (Button) findViewById(R.id.formasDePagamento);
        formasDePagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ActivityFormasDePagamento.class);

                model.dal_pedidos.Update insertPedido = new model.dal_pedidos.Update(getApplicationContext());
                insertPedido.insertPedido(pedidos);

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    void verificaPeso(String valorCampo) {

        if (valorCampo.equals("100g - R$ 4,00")) {

            mostraPeso.setText("Peso: 100g");
        } else if (valorCampo.equals("200g - R$ 5,00")) {

            mostraPeso.setText("Peso: 200g");
        } else if (valorCampo.equals("300g - R$ 8,00")) {

            mostraPeso.setText("Peso: 300g");
        } else if (valorCampo.equals("400g - R$ 10,00")) {

            mostraPeso.setText("Peso: 400g");
        } else if (valorCampo.equals("500g - R$ 12,00")) {

            mostraPeso.setText("Peso: 500g");
        } else if (valorCampo.equals("700g - R$ 14,00")) {

            mostraPeso.setText("Peso: 700g");
        } else if (valorCampo.equals("1Kg - R$ 19,00")) {

            mostraPeso.setText("Peso: 1Kg");
        }
    }

    Pedidos populaPedido(Intent intent) {

        Pedidos pedidos = new Pedidos();

        pedidos.setPreco(intent.getStringExtra("precoFinal"));
        pedidos.setDataAberturaDoPedido("10/08/2016");
        pedidos.setDataFechamentoDoPedido("10/08/2016");

        return pedidos;
    }
}