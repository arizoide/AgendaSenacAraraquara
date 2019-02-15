package arithomazini.senac.br.agendasenacararaquara.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import arithomazini.senac.br.agendasenacararaquara.model.ContatoEntity;

public class ContatoDAO {

    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase sqLiteDatabase;

    public ContatoDAO(Context context) {
        this.sqLiteHelper = new SQLiteHelper(context);
    }

    public void salvar(ContatoEntity contato){
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("NOME", contato.getNome());
        values.put("TELEFONE", contato.getTelefone());
        values.put("PONTUACAO", contato.getPontuacao());

        sqLiteDatabase.insert("CONTATO", null, values);

        sqLiteDatabase.close();
    }
}
