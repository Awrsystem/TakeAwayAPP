package model.dal_clientes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Create extends SQLiteOpenHelper {

    private Context mContext;
    private static final String NOME_DB = "TAKE_AWAY";
    private static final int VERSAO_DB = 2;
    private static final String NOME_TABELA = "Clientes";
    private static final String PATH_DB = "/data/user/0/com.example.unknown.crud/databases/TAKE_AWAY";
    private SQLiteDatabase db;

    public Create(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
        this.mContext = context;
        db = getWritableDatabase();
    }

    public boolean createTable(){

        openDB();

        String createTable = ("CREATE TABLE IF NOT EXISTS " + NOME_TABELA + "("
                + "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + " NOME TEXT NOT NULL,"
                + " APELIDO TEXT NOT NULL,"
                + " DATA_NASC TEXT NOT NULL,"
                + " NIF TEXT NOT NULL,"
                + " ENDERECO TEXT NOT NULL,"
                + " TELEFONE TEXT NOT NULL,"
                + " EMAIL TEXT NOT NULL,"
                + " SENHA TEXT NOT NULL"
                + ");");

        try {
            db.execSQL(createTable);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            db.close();
        }
    }

    private void openDB(){

        if(!db.isOpen()){
            db = mContext.openOrCreateDatabase(PATH_DB, SQLiteDatabase.OPEN_READWRITE, null);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}