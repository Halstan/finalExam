package com.example.finalexam.Class;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLDB extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "FinalDB";

    private static final int VERSION_BD = 1;

    private static final String TABLA_USUARIOS = "CREATE TABLE USUARIO(" +
            "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre text," +
            "usuario text, " +
            "password text)";

    public SQLDB(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_USUARIOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion>oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS TABLA_USUARIOS");
            db.execSQL(TABLA_USUARIOS);
        }
    }

    public void insertUser(String nombre, String usuario, String password){
        SQLiteDatabase db = getWritableDatabase();
        if(db!=null){
            db.execSQL("INSERT INTO USUARIO(nombre,usuario,password) VALUES ('"+nombre+"','"+usuario+"','"+password+"')");
            db.close();
        }
    }

    public void updateUser(Integer idUser, String nombre, String usuario, String password){
        SQLiteDatabase db = getWritableDatabase();
        if(db!=null){
            db.execSQL("UPDATE USUARIO SET id_usuario = '"+idUser+"', nombre = '"+nombre+"', usuario = '"+usuario+"', password = '"+password+"' WHERE id_usuario = '"+idUser+"'");
            db.close();
        }
    }

    public void deleteUser(Integer idUser){
        SQLiteDatabase db = getWritableDatabase();
        if(db!=null){
            db.execSQL("DELETE FROM USUARIO WHERE id_usuario = '"+idUser+"'");
            db.close();
        }
    }

    public List<User> visualizarUsuarios(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USUARIO", null);
        List<User> users = new ArrayList<>( );
        if(cursor.moveToFirst()){
            do{
                users.add(new User( cursor.getInt( 0 ),
                        cursor.getString( 1 ),
                        cursor.getString( 2 ),
                        cursor.getString( 3 )));
            }while(cursor.moveToNext());
        }
        return users;
    }

    public void findUser(User user, Integer idUser){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USUARIO WHERE id_usuario = '"+idUser+"'", null);
        if(cursor.moveToFirst()){
            do{
                user.setNombre(cursor.getString(1));
                user.setUsername(cursor.getString(2));
                user.setPassword(cursor.getString(3));
            }while(cursor.moveToNext());
        }
    }

    public Cursor validarUsuario(String mail, String pass){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = null;
        cursor = this.getReadableDatabase().query("USUARIO", new String[]{"id_usuario", "nombre", "usuario", "password"} , "usuario LIKE '"+mail+"' and password LIKE '"+pass+"'"  , null, null, null, null );

        return cursor;
    }

}
