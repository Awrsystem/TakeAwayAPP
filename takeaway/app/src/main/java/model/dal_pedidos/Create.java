package model.dal_pedidos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Create extends SQLiteOpenHelper {

    private Context mContext;
    private static final String NOME_DB = "TAKE_AWAY";
    private static final int VERSAO_DB = 2;
    private static final String NOME_TABELA = "Pedidos";
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
                + "PROTOCOLO INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + " PRECO TEXT NOT NULL,"
                + " DATA_ABERTURA TEXT NOT NULL,"
                + " DATA_FECHAMENTO TEXT NOT NULL"
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