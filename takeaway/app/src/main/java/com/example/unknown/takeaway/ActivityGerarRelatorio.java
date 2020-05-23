package br.com.takeaway;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

import model.dal_pedidos.Pedidos;

public class ActivityGerarRelatorio extends AppCompatActivity {

    private TextView mostraRelatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerar_relatorio);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mostraRelatorio = (TextView) findViewById(R.id.mostraRelatorio);

        model.dal_pedidos.Read pedidos = new model.dal_pedidos.Read(getApplicationContext());
        ArrayList<Pedidos> pedidosArray = pedidos.getPedidos();

        for (int i = 0; i < pedidosArray.size(); i++) {
            Pedidos pedidos1 = pedidosArray.get(i);


            mostraRelatorio.setText("Chamado(s) finalizados:" +
                    " \n\n" + pedidos1.getProtocolo() +
                    " \n" + pedidos1.getPreco() +
                    " \n" + pedidos1.getDataAberturaDoPedido() +
                    " \n" + pedidos1.getDataFechamentoDoPedido() +
                    "\n///////////////////"
            );
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
