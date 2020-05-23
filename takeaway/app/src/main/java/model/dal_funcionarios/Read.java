package model.dal_funcionarios;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;


public class Read extends SQLiteOpenHelper {

    private Context mContext;
    private static final String NOME_DB = "TAKE_AWAY";
    private static final int VERSAO_DB = 2;
    private static final String NOME_TABELA = "Funcionarios";
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

    public ArrayList<Funcionarios> getFuncionarios(){

        openDB();
        ArrayList<Funcionarios> fArray = new ArrayList<>();
        String getPessoas = "SELECT * FROM " + NOME_TABELA + ";";

        try {
            Cursor c = db.rawQuery(getPessoas, null);

            if (c.moveToFirst()){

                do{
                    Funcionarios f = new Funcionarios();

                    f.setId(c.getInt(0));
                    f.setNome(c.getString(1));
                    f.setSexo(c.getString(2));

                    fArray.add(f);
                }
                while (c.moveToNext());
                c.close();
            }

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            db.close();
        }

        return fArray;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}