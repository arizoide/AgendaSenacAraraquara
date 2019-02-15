package arithomazini.senac.br.agendasenacararaquara.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import arithomazini.senac.br.agendasenacararaquara.R;
import arithomazini.senac.br.agendasenacararaquara.dao.ContatoDAO;
import arithomazini.senac.br.agendasenacararaquara.model.ContatoEntity;
import arithomazini.senac.br.agendasenacararaquara.model.EnderecoEntity;

public class ContatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        // ******************************
        // Acao de click no salvar
        // ******************************

        //Recupero o botao de salvar
        Button salvarContatoButton = findViewById(R.id.salvarContatoButton);

        salvarContatoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Recuperar o texto dos EditText
                //Objetos da tela

                //Edit Text - Contato
                EditText nomeEditText = findViewById(R.id.nomeEditText);
                EditText telefoneEditText = findViewById(R.id.telefoneEditText);

                //Edit Text - Endereco
                EditText ruaEditText = findViewById(R.id.ruaEditText);
                EditText numeroEditText = findViewById(R.id.numeroEditText);
                EditText cidadeEstadoEditText = findViewById(R.id.cidadeEstadoEditText);

                //Rating Bar
                RatingBar pontuacaoRatingBar = findViewById(R.id.pontuacaoRatingBar);

                //Texto que estavam presentes nos objetos
                ContatoEntity contato = new ContatoEntity(nomeEditText.getText().toString(),
                        telefoneEditText.getText().toString(),
                        Double.valueOf(pontuacaoRatingBar.getProgress()));

                ContatoDAO contatoDAO = new ContatoDAO(ContatoActivity.this);
                contatoDAO.salvar(contato);

                //Criar a entidade de endereco
                EnderecoEntity endereco = new EnderecoEntity(ruaEditText.getText().toString(),
                        numeroEditText.getText().toString(),
                        cidadeEstadoEditText.getText().toString());

                //Exibe uma mensagem
                Toast.makeText(ContatoActivity.this,
                        "Contato Salvo!",
                        Toast.LENGTH_LONG).show();

                //Finaliza a activity atual e volta para a MainActivity
                finish();
            }
        });

    }
}

