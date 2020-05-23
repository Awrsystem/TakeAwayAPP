package model.dal_clientes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class Read extends SQLiteOpenHelper {

    private Context mContext;
    private static final String NOME_DB = "TAKE_AWAY";
    private static final int VERSAO_DB = 2;
    private static final String NOME_TABELA = "Clientes";
    private static final String PATH_DB = "/data/user/0/com.example.unknown.crud/databases/TAKE_AWAY";
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

    public ArrayList<Clientes> getClientes(){

        openDB();
        ArrayList<Clientes> pArray = new ArrayList<>();
        String getClientes = "SELECT * FROM " + NOME_TABELA + ";";

        try {
            Cursor c = db.rawQuery(getClientes, null);

            if (c.moveToFirst()){

                do{
                    Clientes clientes = new Clientes();

                    clientes.setId(c.getInt(0));
                    clientes.setNome(c.getString(1));
                    clientes.setApelido(c.getString(2));
                    clientes.setDataNascimento(c.getString(3));
                    clientes.setNif((c.getString(4)));
                    clientes.setEndereco(c.getString(5));
                    clientes.setTelefone(c.getString(6));
                    clientes.setEmail(c.getString(7));
                    clientes.setSenha(c.getString(8));

                    pArray.add(clientes);
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