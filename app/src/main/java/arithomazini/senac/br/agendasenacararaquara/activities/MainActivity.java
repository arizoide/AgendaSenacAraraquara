package arithomazini.senac.br.agendasenacararaquara.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import arithomazini.senac.br.agendasenacararaquara.R;
import arithomazini.senac.br.agendasenacararaquara.dao.ContatoDAO;
import arithomazini.senac.br.agendasenacararaquara.model.ContatoEntity;

public class MainActivity extends AppCompatActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recupera a referencia da lista que tem no layout do aplicativo
        lista = findViewById(R.id.listaContatosListView);

        //Cria a lista de contatos como string
        ContatoDAO contatoDAO = new ContatoDAO(this);
        List<ContatoEntity> contatos = contatoDAO.listar();

        //Para conseguirmos exibir a lista do listView, preciso
        //criar um adaptor
        ArrayAdapter<ContatoEntity> adapter =
                new ArrayAdapter<ContatoEntity>(this, android.R.layout.simple_list_item_1, contatos);

        //insere o adpter na lista de contatos
        lista.setAdapter(adapter);

        registerForContextMenu(lista);

        //Recuperar o botao e criar acao para ele
        Button novoContato = findViewById(R.id.novoContatoButton);

        novoContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contato = new Intent(MainActivity.this, ContatoActivity.class);
                startActivity(contato);
            }
        });

        Button buscar = findViewById(R.id.buscarButton);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContatoDAO dao = new ContatoDAO(MainActivity.this);

                EditText x =  findViewById(R.id.nomeBuscarEditText);

                List<ContatoEntity> contatos = dao.listar(x.getText().toString());

                //Para conseguirmos exibir a lista do listView, preciso
                //criar um adaptor
                ArrayAdapter<ContatoEntity> adapter =
                        new ArrayAdapter<ContatoEntity>(MainActivity.this, android.R.layout.simple_list_item_1, contatos);

                lista.setAdapter(adapter);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
//        ContatoDAO dao = new ContatoDAO(MainActivity.this);
//
//        List<ContatoEntity> contatos = dao.listar();
//
//        //Para conseguirmos exibir a lista do listView, preciso
//        //criar um adaptor
//        ArrayAdapter<ContatoEntity> adapter =
//                new ArrayAdapter<ContatoEntity>(MainActivity.this, android.R.layout.simple_list_item_1, contatos);
//
//        lista.setAdapter(adapter);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem remover = menu.add("Remover");

        remover.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo infoMenuClicado = (AdapterView.AdapterContextMenuInfo) menuInfo;

                ContatoEntity contato = (ContatoEntity) lista.getItemAtPosition(infoMenuClicado.position);

                //Remover contato com o DAO
                ContatoDAO dao = new ContatoDAO(MainActivity.this);
                dao.remover(contato);

                List<ContatoEntity> contatos = dao.listar();

                //Para conseguirmos exibir a lista do listView, preciso
                //criar um adaptor
                ArrayAdapter<ContatoEntity> adapter =
                        new ArrayAdapter<ContatoEntity>(MainActivity.this, android.R.layout.simple_list_item_1, contatos);

                lista.setAdapter(adapter);

                return false;
            }
        });
    }
}
