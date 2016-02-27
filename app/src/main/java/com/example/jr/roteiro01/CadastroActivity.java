package com.example.jr.roteiro01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {
    private EditText mNome;
    private EditText mSobrenome;
    private EditText mUsuario;
    private EditText mSenha01;
    private EditText mSenha02;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mNome = (EditText) findViewById(R.id.nome);
        mSobrenome = (EditText) findViewById(R.id.sobrenome);
        mUsuario = (EditText) findViewById(R.id.usuario);
        mSenha01 = (EditText) findViewById(R.id.senha01);
        mSenha02 = (EditText) findViewById(R.id.senha02);
        mButton = (Button) findViewById(R.id.bTcadastrar);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logar();
            }
        });
    }

    private void logar() {

        String nome = mNome.getText().toString();
        String sobreNome = mSobrenome.getText().toString();
        String usuario = mUsuario.getText().toString();
        String senha01 = mSenha01.getText().toString();
        String senha02 = mSenha02.getText().toString();

        View focus = null;
        if(TextUtils.isEmpty(nome)){
            mNome.setError("Campo Vazio");
            focus = mNome;
            focus.requestFocus();

        }
        if(TextUtils.isEmpty(sobreNome)){
            mSobrenome.setError("Campo Vazio");
            focus = mSobrenome;
            focus.requestFocus();
        }
        if(TextUtils.isEmpty(usuario)){
            mUsuario.setError("Campo Vazio");
            focus = mUsuario;
            focus.requestFocus();
        }
        if(TextUtils.isEmpty(senha01)){
            mSenha01.setError("Campo Vazio");
            focus = mSenha01;
            focus.requestFocus();
        }
        if(TextUtils.isEmpty(senha02)){
            mSenha02.setError("Campo Vazio");
            focus = mSenha02;
            focus.requestFocus();
        } else {
            if(senha01.equalsIgnoreCase(senha02)) {
                Intent i = new Intent(this, MainActivity.class);
                Bundle b = new Bundle();
                b.putString("nome", nome);
                b.putString("sobrenome", sobreNome);
                i.putExtras(b);
                startActivity(i);
                finish();
            } else {
                mSenha02.setError("Senha diferente");
                focus = mSenha02;
                focus.requestFocus();
            }
        }
    }
}
