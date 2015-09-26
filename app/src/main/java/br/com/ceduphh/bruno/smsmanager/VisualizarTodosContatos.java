package br.com.ceduphh.bruno.smsmanager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by BRUNO on 25/09/2014.
 */
public class VisualizarTodosContatos extends Activity implements View.OnClickListener {
    private static final int SELECIONAR_CONTATO = 1;
    private static final String CATEGORIA = "livro";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_visualizar_contatos);
        Button button = (Button) findViewById(R.id.botaoOk);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Uri uri = Uri.parse("content:\\com.android.contacts/contacts/");
        Intent it = new Intent(Intent.ACTION_PICK, uri);
        startActivityForResult(it, SELECIONAR_CONTATO);
    }

    @Override
    protected void onActivityResult(int codigo, int resultado, Intent it){
        if (it == null){
            Toast.makeText(this, "Nenhum Contato", Toast.LENGTH_SHORT).show();
            return;
        }
        Uri uri = it.getData();
        Toast.makeText(this,"Contato: " + uri, Toast.LENGTH_SHORT).show();
    }
}
