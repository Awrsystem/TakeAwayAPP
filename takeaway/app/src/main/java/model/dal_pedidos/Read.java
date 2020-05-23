package model.dal_pedidos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class Read extends SQLiteOpenHelper {

    private Context mContext;
    private static final String NOME_DB = "TAKE_AWAY";
    private static final int VERSAO_DB = 2;
    private static final String NOME_TABELA = "Pedidos";
    private static final String PATH_DB = "/data/user/0/com.example.unknown.meuacai/databases/TAKE_AWAY";
    private SQLiteDatabase db;

    public Read(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
        this.mContext = context;
        db = getReadableDatabase();
    }

    private void openDB(){

        if(!db.isOpen()){
            db = mContext.openOrCreateDatabase(PATH_DB, SQLiteDatabase.OPEN_READWRITE, null);
        }
    }

    public ArrayList<Pedidos> getPedidos(){

        openDB();
        ArrayList<Pedidos> pArray = new ArrayList<>();
        String getPedidos = "SELECT * FROM " + NOME_TABELA + ";";

        try {
            Cursor c = db.rawQuery(getPedidos, null);

            if (c.moveToFirst()){

                do{
                    Pedidos p = new Pedidos();
                    p.setProtocolo(c.getString(0));
                    p.setPreco(c.getString(1));
                    p.setDataAberturaDoPedido(c.getString(2));
                    p.setDataFechamentoDoPedido(c.getString(3));
                    pArray.add(p);
                }
                while (c.moveToNext());
                c.close();
            }

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            db.close();
        }

        return pArray;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}