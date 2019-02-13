package arithomazini.senac.br.agendasenacararaquara;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

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

                //Edit Text
                EditText nomeEditText = findViewById(R.id.nomeEditText);
                EditText telefoneEditText = findViewById(R.id.telefoneEditText);
                EditText emailEditText = findViewById(R.id.emailEditText);

                //Rating Bar
                RatingBar pontuacaoRatingBar = findViewById(R.id.pontuacaoRatingBar);

                //Texto que estavam presentes nos objetos
                String nome = nomeEditText.getText().toString();
                String telefone = telefoneEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String pontuacao = String.valueOf(pontuacaoRatingBar.getRating());

                //Exibe uma mensagem
                Toast.makeText(ContatoActivity.this,
                        "Contato Salvo! Nome: " + nome + " - Tel: " + telefone
                                + " - E-mail: " + email + "Pontuacao: " + pontuacao,
                        Toast.LENGTH_SHORT).show();

                //Finaliza a activity atual e volta para a MainActivity
                finish();
            }
        });

    }
}
