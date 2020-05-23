package br.com.takeaway;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import model.dal_pedidos.Pedidos;

public class ActivityVisualizacaoPedidosAtendente extends AppCompatActivity {

    private TextView pedido;
    private Button fechaPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizacao_pedidos_atendente);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        chamado = (TextView) findViewById(R.id.textViewChamado);

        model.dal_pedidos.Read pedidos = new model.dal_pedidos.Read(getApplicationContext());
        ArrayList<Pedidos> pedidosArray = pedidos.getPedidos();

        for (int i = 0; i < pedidosArray.size(); i++) {
            Pedidos pedidos1 = pedidosArray.get(i);

            chamado.setText("Pedido(s) realizado:" +
                    " \n\n" + pedidos1.getProtocolo() +
                    " \n" + pedidos1.getPreco() +
                    " \n" + pedidos1.getDataAberturaDoPedido() +
                    " \n" + pedidos1.getDataFechamentoDoPedido() +
                    "\n////////////////////////////"
            );
        }

        fechaPedido = (Button) findViewById(R.id.fechaAtendimento);
        fechaPedido.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                chamado.setText("Sem pedidos messe instante");
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
