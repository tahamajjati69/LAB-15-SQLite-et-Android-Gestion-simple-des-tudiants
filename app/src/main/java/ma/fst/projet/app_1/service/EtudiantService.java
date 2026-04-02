package ma.fst.projet.app_1.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ma.fst.projet.app_1.classes.Etudiant;
import ma.fst.projet.app_1.util.MySQLiteHelper;

public class EtudiantService {

    private static final String TABLE_NAME = "etudiant";

    private static final String KEY_ID = "id";
    private static final String KEY_NOM = "nom";
    private static final String KEY_PRENOM = "prenom";

    private static final String[] COLUMNS = {KEY_ID, KEY_NOM, KEY_PRENOM};

    private final MySQLiteHelper helper;

    public EtudiantService(Context context) {
        this.helper = new MySQLiteHelper(context);
    }

    public void create(Etudiant e) {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NOM, e.getNom());
        values.put(KEY_PRENOM, e.getPrenom());

        db.insert(TABLE_NAME, null, values);

        Log.d("EtudiantService", "Inserted: " + e.getNom());

        db.close();
    }

    public void update(Etudiant e) {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NOM, e.getNom());
        values.put(KEY_PRENOM, e.getPrenom());

        db.update(
                TABLE_NAME,
                values,
                KEY_ID + " = ?",
                new String[]{String.valueOf(e.getId())}
        );

        db.close();
    }

    public Etudiant findById(int id) {
        Etudiant e = null;

        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.query(
                TABLE_NAME,
                COLUMNS,
                KEY_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null
        );

        if (c != null && c.moveToFirst()) {
            e = new Etudiant();
            e.setId(c.getInt(0));
            e.setNom(c.getString(1));
            e.setPrenom(c.getString(2));
        }

        if (c != null) c.close();
        db.close();

        return e;
    }

    // ➤ DELETE
    public void delete(int id) {
        SQLiteDatabase db = helper.getWritableDatabase();

        db.delete(
                TABLE_NAME,
                KEY_ID + " = ?",
                new String[]{String.valueOf(id)}
        );

        db.close();
    }

    // ➤ FIND ALL
    public List<Etudiant> findAll() {
        List<Etudiant> list = new ArrayList<>();

        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Etudiant e = new Etudiant();
                e.setId(c.getInt(0));
                e.setNom(c.getString(1));
                e.setPrenom(c.getString(2));

                list.add(e);
            } while (c.moveToNext());
        }

        c.close();
        db.close();

        return list;
    }
}