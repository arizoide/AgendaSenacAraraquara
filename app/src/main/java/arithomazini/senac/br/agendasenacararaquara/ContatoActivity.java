package arithomazini.senac.br.agendasenacararaquara;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        // ******************************
        // Acao de click no salvar
        // ******************************

        //Recuperto o botao de salvar
        Button salvarContatoButton = findViewById(R.id.salvarContatoButton);

        salvarContatoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ContatoActivity.this,
                        "Contato Salvo!",
                        Toast.LENGTH_SHORT).show();

                finish();
            }
        });

    }
}
