package com.example.jr.roteiro01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMensagem = (TextView) findViewById(R.id.mensagem);
        Bundle b = getIntent().getExtras();
        String texto = b.getString("nome") + " " + b.getString("sobrenome");
        mMensagem.setText("Olá, " + texto + ", Seja bem vindo, querido!");
    }
}
