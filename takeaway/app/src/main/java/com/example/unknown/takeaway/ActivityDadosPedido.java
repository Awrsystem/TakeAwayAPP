package br.com.takeaway;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import static com.example.unknown.meuacai.R.string.cemGramas;
import static com.example.unknown.meuacai.R.string.duzentasGramas;
import static com.example.unknown.meuacai.R.string.quatrocentasGramas;
import static com.example.unknown.meuacai.R.string.quinhentasGramas;
import static com.example.unknown.meuacai.R.string.setecentasGramas;
import static com.example.unknown.meuacai.R.string.trezentasGramas;
import static com.example.unknown.meuacai.R.string.umQuilo;

public class ActivityDadosPedido extends AppCompatActivity {

    private double precoBaseCoberturasEAcompanhamentos = 0.50;

    private double precoTemp;

    private double PrecoCoberturasEAcompanhamentos;

    private double precoFinal;

    private CheckBox coberturaMorango;
    private CheckBox coberturaCupuacu;
    private CheckBox coberturaAbacaxi;
    private CheckBox coberturaChocolate;
    private CheckBox coberturaLeiteCondensado;
    private CheckBox coberturaKiwi;
    private CheckBox coberturaMel;

    private CheckBox acompanhamentoAbacate;
    private CheckBox acompanhamentoCupuacu;
    private CheckBox acompanhamentoKiwi;
    private CheckBox acompanhamentoAbacaxi;
    private CheckBox acompanhamentoMorango;
    private CheckBox acompanhamentoGranola;
    private CheckBox acompanhamentoBanana;

    private TextView fazerPedido;
    private TextView textViewQuantidade;
    private EditText quantidade;
    private TextView peso;
    private Spinner spinner;
    private TextView acompanhamentos1;
    private TextView acompanhamentos2;
    private TextView coberturas;
    private TextView mensagemPrecoFinal;
    private TextView textViewPrecoFinal;
    private Button confirmarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_chamado);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fazerPedido = (TextView) findViewById(R.id.facaSeuPedido);
        fazerPedido.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));

        textViewQuantidade = (TextView) findViewById(R.id.quantidade);
        textViewQuantidade.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));

        quantidade = (EditText) findViewById(R.id.editTextQuantidade);
        quantidade.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));

        peso = (TextView) findViewById(R.id.peso);
        peso.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));

        Resources res = getResources();

        spinner = (Spinner) findViewById(R.id.spinnerPesos);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, R.layout.my_spinner_layout, res.getStringArray(R.array.arrayPesos));

        spinner.setOnTouchListener(new View.OnTouchListener() {


            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    trataExcecao(v);
                    calculaPreco(spinner.getSelectedItem().toString(), v);
                }
                return false;
            }
        });

        spinner.setAdapter(adapter);

        coberturas = (TextView) findViewById(R.id.coberturas);
        coberturas.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));

        coberturaMorango = (CheckBox) findViewById(R.id.coberturaMorango);
        coberturaMorango.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        coberturaMorango.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                verificaCheckBoxes(coberturaMorango, getString(R.string.coberturaDeMorango));
                obtemNomesCheckBoxes(coberturaMorango);
            }
        });

        coberturaCupuacu = (CheckBox) findViewById(R.id.coberturaCupuacu);
        coberturaCupuacu.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        coberturaCupuacu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                verificaCheckBoxes(coberturaCupuacu, getString(R.string.coberturaDeCupuacu));
                obtemNomesCheckBoxes(coberturaCupuacu);
            }
        });

        coberturaAbacaxi = (CheckBox) findViewById(R.id.coberturaAbacaxi);
        coberturaAbacaxi.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        coberturaAbacaxi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                verificaCheckBoxes(coberturaAbacaxi, getString(R.string.coberturaDeAbacaxi));
                obtemNomesCheckBoxes(coberturaAbacaxi);
            }
        });

        coberturaChocolate = (CheckBox) findViewById(R.id.coberturaChocolate);
        coberturaChocolate.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        coberturaChocolate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                verificaCheckBoxes(coberturaChocolate, getString(R.string.coberturaDeChocolate));
                obtemNomesCheckBoxes(coberturaChocolate);
            }
        });

        coberturaLeiteCondensado = (CheckBox) findViewById(R.id.coberturaLeiteCondensado);
        coberturaLeiteCondensado.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        coberturaLeiteCondensado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                verificaCheckBoxes(coberturaLeiteCondensado, getString(R.string.leiteCondensado));
                obtemNomesCheckBoxes(coberturaLeiteCondensado);
            }
        });

        coberturaKiwi = (CheckBox) findViewById(R.id.coberturaKiwi);
        coberturaKiwi.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        coberturaKiwi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                verificaCheckBoxes(coberturaKiwi, getString(R.string.coberturaDeKiwi));
                obtemNomesCheckBoxes(coberturaKiwi);
            }
        });

        coberturaMel = (CheckBox) findViewById(R.id.coberturaMel);
        coberturaMel.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        coberturaMel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                verificaCheckBoxes(coberturaMel, getString(R.string.mel));
                obtemNomesCheckBoxes(coberturaMel);
            }
        });

        acompanhamentoAbacate = (CheckBox) findViewById(R.id.acompanhamentoAbacate);
        acompanhamentoAbacate.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        acompanhamentoAbacate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                verificaCheckBoxes(acompanhamentoAbacate, getString(R.string.abacate));
                obtemNomesCheckBoxes(acompanhamentoAbacate);
            }
        });

        acompanhamentoCupuacu = (CheckBox) findViewById(R.id.acompanhamentoCupuacu);
        acompanhamentoCupuacu.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        acompanhamentoCupuacu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                verificaCheckBoxes(acompanhamentoCupuacu, getString(R.string.cupuacu));
                obtemNomesCheckBoxes(acompanhamentoCupuacu);
            }
        });

        acompanhamentoKiwi = (CheckBox) findViewById(R.id.acompanhamentoKiwi);
        acompanhamentoKiwi.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        acompanhamentoKiwi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                verificaCheckBoxes(acompanhamentoKiwi, getString(R.string.kiwi));
                obtemNomesCheckBoxes(acompanhamentoKiwi);
            }
        });

        acompanhamentoAbacaxi = (CheckBox) findViewById(R.id.acompanhamentoAbacaxi);
        acompanhamentoAbacaxi.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        acompanhamentoAbacaxi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                verificaCheckBoxes(acompanhamentoAbacaxi, getString(R.string.abacaxi));
                obtemNomesCheckBoxes(acompanhamentoAbacaxi);
            }
        });

        acompanhamentoMorango = (CheckBox) findViewById(R.id.acompanhamentoMorango);
        acompanhamentoMorango.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        acompanhamentoMorango.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                verificaCheckBoxes(acompanhamentoMorango, getString(R.string.morango));
                obtemNomesCheckBoxes(acompanhamentoMorango);
            }
        });

        acompanhamentoGranola = (CheckBox) findViewById(R.id.acompanhamentoGranola);
        acompanhamentoGranola.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        acompanhamentoGranola.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                verificaCheckBoxes(acompanhamentoGranola, getString(R.string.granola));
                obtemNomesCheckBoxes(acompanhamentoGranola);
            }
        });

        acompanhamentoBanana = (CheckBox) findViewById(R.id.acompanhamentoBanana);
        acompanhamentoBanana.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        acompanhamentoBanana.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                verificaCheckBoxes(acompanhamentoBanana, getString(R.string.banana));
                obtemNomesCheckBoxes(acompanhamentoBanana);
            }
        });

        acompanhamentos1 = (TextView) findViewById(R.id.acompanhamentos1);
        acompanhamentos1.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));

        acompanhamentos2 = (TextView) findViewById(R.id.acompanhamentos2);
        acompanhamentos2.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));

        mensagemPrecoFinal = (TextView) findViewById(R.id.precoFinal);
        mensagemPrecoFinal.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));

        textViewPrecoFinal = (TextView) findViewById(R.id.textViewPrecoFinal);
        textViewPrecoFinal.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));

        confirmarPedido = (Button) findViewById(R.id.buttonConfirmarPedido);
        confirmarPedido.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ActivityConfirmaPedido.class);

                trataExcecao(v);

                intent.putExtra("quantidade", quantidade.getText().toString());
                intent.putExtra("peso", spinner.getSelectedItem().toString());
                intent.putExtra("precoFinal", textViewPrecoFinal.getText());

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

        final String text = quantidade.getText().toString();

        if (text.trim().length() <= 0) {
            snackBarMaker(view, "O campo quantidade está vazio!");
            return;
        } else if (Integer.valueOf(text) <= 0) {
            snackBarMaker(view, "O valor do campo quantidade é menor ou igual a zero!");
            return;
        } else if (Integer.valueOf(text) > 100) {
            snackBarMaker(view, "O valor do campo quantidade é maior do que 100!");
            return;
        }
    }

    void verificaCheckBoxes(CheckBox checkBox, String nomeCobertura) {

        if (checkBox.isChecked()) {
            PrecoCoberturasEAcompanhamentos += precoBaseCoberturasEAcompanhamentos;
            mostraPrecoFinal();
            Toast.makeText(getApplicationContext(), " Opção cobertura de " + nomeCobertura + " marcada", Toast.LENGTH_SHORT).show();
        } else {
            PrecoCoberturasEAcompanhamentos -= precoBaseCoberturasEAcompanhamentos;
            mostraPrecoFinal();
            Toast.makeText(getApplicationContext(), " Opção cobertura de " + nomeCobertura + " desmarcada", Toast.LENGTH_SHORT).show();
        }
    }

    void obtemNomesCheckBoxes(CheckBox checkBox) {

        List<String> checkBoxes = new ArrayList<>();

        if (checkBox.isChecked()) {

            checkBoxes.add(checkBox.getText().toString());
        }
        retornaCheckbox(checkBoxes);
    }

    List retornaCheckbox(List<String> checkBoxes) {

        return checkBoxes;
    }

    void calculaPreco(String msgSpinner, View v) {

        double valorCemGramas = 4;
        double valorDuzentasGramas = 5;
        double valorTrezentasGramas = 8;
        double valorQuatrocentasGramas = 10;
        double valorQuinhentasGramas = 12;
        double valorSetecentasGramas = 14;
        double valorUmQuilo = 19;

        String text = quantidade.getText().toString();

        if (msgSpinner.equals(getString(cemGramas))) {

            trataExcecao(v);
            precoTemp = (valorCemGramas * Double.valueOf(text));
            mostraPrecoFinal();
        }

        else if (msgSpinner.equals(getString(duzentasGramas))) {

            trataExcecao(v);
            precoTemp = (valorDuzentasGramas * Double.valueOf(text));
            mostraPrecoFinal();
        }

        else if (msgSpinner.equals(getString(trezentasGramas))) {

            trataExcecao(v);
            precoTemp = (valorTrezentasGramas * Double.valueOf(text));
            mostraPrecoFinal();

        } else if (msgSpinner.equals(getString(quatrocentasGramas))) {

            trataExcecao(v);
            precoTemp = (valorQuatrocentasGramas * Double.valueOf(text));
            mostraPrecoFinal();

        } else if (msgSpinner.equals(getString(quinhentasGramas))) {

            trataExcecao(v);
            precoTemp = (valorQuinhentasGramas * Double.valueOf(text));
            mostraPrecoFinal();

        } else if (msgSpinner.equals(getString(setecentasGramas))) {

            trataExcecao(v);
            precoTemp = (valorSetecentasGramas * Double.valueOf(text));
            mostraPrecoFinal();

        } else if (msgSpinner.equals(getString(umQuilo))) {

            trataExcecao(v);
            precoTemp = (valorUmQuilo * Double.valueOf(text));
            mostraPrecoFinal();
        }
    }

    //Método original
    void mostraPrecoFinal() {
        precoFinal = (precoTemp + PrecoCoberturasEAcompanhamentos);
        textViewPrecoFinal.setText(String.valueOf(NumberFormat.getCurrencyInstance().format(precoFinal)));
    }

    void snackBarMaker(View v, String mensagem) {

        Snackbar.make(v, mensagem, Snackbar.LENGTH_INDEFINITE)
                .setAction("OK", new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        //Dismiss
                    }
                }).show();
    }
}