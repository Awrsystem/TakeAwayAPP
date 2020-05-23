package br.com.takeaway;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityAberturaPedido extends AppCompatActivity {

    private TextView mensagemPedido;
    private ImageView addFloatingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abertura_pedido);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mensagemPedido = (TextView) findViewById(R.id.textViewPedido);
        mensagemPedio.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));

        addFloatingButton = (ImageView) findViewById(R.id.addFloatingButton);
        addFloatingButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ActivityDadosChamado.class);
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