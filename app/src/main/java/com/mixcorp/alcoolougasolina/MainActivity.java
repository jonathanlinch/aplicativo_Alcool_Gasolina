package com.mixcorp.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        //editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }
    public void calcularPreco(View view){
        //recuperar valores
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();
        //validar os dados
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if (camposValidados){
            //convertendo String para numeros
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);
            if (valorAlcool/valorGasolina >= 0.7){
                textResultado.setText(R.string.usar_gasolina);
            }else {
                textResultado.setText(R.string.usar_alcool);
            }

        }else{
            textResultado.setText("Preencha os campos primeiro!");
        }
    }
    public Boolean validarCampos(String pAlcool, String pGasolina){

        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }else if (pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }
        return camposValidados;
    }
}