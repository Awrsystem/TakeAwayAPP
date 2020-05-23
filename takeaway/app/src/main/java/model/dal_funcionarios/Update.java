package model.dal_funcionarios;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Update extends SQLiteOpenHelper {

    private Context mContext;
    private static final String NOME_DB = "TAKE_AWAY";
    private static final int VERSAO_DB = 2;
    private static final String NOME_TABELA = "Funcionarios";
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

    public boolean insertFuncionario(Funcionarios f){

        openDB();

        try{
            ContentValues cv = new ContentValues();

            cv.put("NOME", f.getNome());
            cv.put("SEXO", f.getSexo());

            db.insert(NOME_TABELA, null, cv);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            db.close();
        }
    }

    public boolean updatePessoa(Funcionarios f){

        openDB();

        try{
            String where = "ID = '" + f.getId() + "'";
            ContentValues cv = new ContentValues();

            cv.put("ID", f.getId());
            cv.put("NOME", f.getNome());
            cv.put("SEXO", f.getSexo());

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