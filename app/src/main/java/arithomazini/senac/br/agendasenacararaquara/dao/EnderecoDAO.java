package arithomazini.senac.br.agendasenacararaquara.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import arithomazini.senac.br.agendasenacararaquara.model.EnderecoEntity;

public class EnderecoDAO {
    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase sqLiteDatabase;

    public EnderecoDAO(Context context) {
        sqLiteHelper = new SQLiteHelper(context);
    }

    public void salvar(EnderecoEntity endereco){
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("RUA", endereco.getRua());
        values.put("NUMERO", endereco.getNumero());
        values.put("CIDADE_ESTADO", endereco.getCidadeEstado());

        sqLiteDatabase.insert("ENDERECO", null, values);

        sqLiteDatabase.close();
    }
}
