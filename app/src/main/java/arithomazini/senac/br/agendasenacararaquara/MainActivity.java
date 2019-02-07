package arithomazini.senac.br.agendasenacararaquara;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recupera a referencia da lista que tem no layout do aplicativo
        ListView lista = findViewById(R.id.listaContatos);

        //Cria a lista de contatos como string
        String[] contatos = {"André", "Ari", "Roberto", "Luzia"};

        //Para conseguirmos exibir a lista do listView, preciso
        //criar um adaptor
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contatos);

        //insere o adpter na lista de contatos
        lista.setAdapter(adapter);





    }
}
