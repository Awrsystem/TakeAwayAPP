package br.com.takeaway;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityAmbienteAtendenteRelatorioOuPedido extends AppCompatActivity {

    private TextView textoEscolha;
    private Button verPedidosEmAberto;
    private Button gerarRelatorios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambiente_atendente_relatorio_ou_pedidos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textoEscolha = (TextView) findViewById(R.id.textViewEscolhaPedidosOuRelatorios);
        textoEscolha.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));

        verPedidosEmAberto = (Button) findViewById(R.id.visualizarPedidosEmAberto);
        verPedidosEmAberto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ActivityVisualizacaoChamadosAtendente.class);
                startActivity(intent);
            }
        });

        gerarRelatorios = (Button) findViewById(R.id.gerarRelatorios);
        gerarRelatorios.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ActivityGerarRelatorio.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}