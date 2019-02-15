package arithomazini.senac.br.agendasenacararaquara.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import arithomazini.senac.br.agendasenacararaquara.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recupera a referencia da lista que tem no layout do aplicativo
        ListView lista = findViewById(R.id.listaContatosListView);

        //Cria a lista de contatos como string
        String[] contatos = {"André", "Ari", "Roberto", "Luzia", "André", "Ari", "Roberto", "Luzia", "André", "Ari", "Roberto", "Luzia", "André", "Ari", "Roberto", "Luzia","André", "Ari", "Roberto", "Luzia"};

        //Para conseguirmos exibir a lista do listView, preciso
        //criar um adaptor
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contatos);

        //insere o adpter na lista de contatos
        lista.setAdapter(adapter);

        //Recuperar o botao e criar acao para ele
        Button novoContato = findViewById(R.id.novoContatoButton);

        novoContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contato = new Intent(MainActivity.this, ContatoActivity.class);
                startActivity(contato);
            }
        });


    }
}
