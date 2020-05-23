package model.dal_pedidos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Update extends SQLiteOpenHelper {

    private Context mContext;
    private static final String NOME_DB = "TAKE_AWAY";
    private static final int VERSAO_DB = 2;
    private static final String NOME_TABELA = "Pedidos";
    private static final String PATH_DB = "/data/user/0/com.example.unknown.crud/databases/TAKE_AWAY";
    private SQLiteDatabase db;

    public Update(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
        this.mContext = context;
        db = getWritableDatabase();
    }

    private void openDB(){

        if(!db.isOpen()){
            db = mContext.openOrCreateDatabase(PATH_DB, SQLiteDatabase.OPEN_READWRITE, null);
        }
    }

    public boolean insertPedido(Pedidos p){

        openDB();

        try{
            ContentValues cv = new ContentValues();

            cv.put("PROTOCOLO", p.getProtocolo());
            cv.put("PROTOCOLO", p.getProtocolo());
            cv.put("PRECO", p.getPreco());
            cv.put("DATA_ABERTURA", p.getDataAberturaDoPedido());
            cv.put("DATA_FECHAMENTO", p.getDataFechamentoDoPedido());

            db.insert(NOME_TABELA, null, cv);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            db.close();
        }
    }

    public boolean updatePessoa(Pedidos p){

        openDB();

        try{
            String where = "PROTOCOLO = '" + p.getProtocolo() + "'";
            ContentValues cv = new ContentValues();

            cv.put("PROTOCOLO", p.getProtocolo());
            cv.put("PRECO", p.getPreco());
            cv.put("DATAABERTURA", p.getDataAberturaDoPedido());
            cv.put("DATAFECHAMENTO", p.getDataFechamentoDoPedido());

            db.update(NOME_TABELA, cv, where, null);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            db.close();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}