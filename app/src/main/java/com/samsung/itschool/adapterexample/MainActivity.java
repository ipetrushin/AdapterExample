package com.samsung.itschool.adapterexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv; // не забудьте привязать переменную (findViewById)
    SimpleCursorAdapter adapter; // объявлен в классе, чтобы был доступен вл всех методах

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        DBHelperWithLoader loader = new DBHelperWithLoader(this);
        SQLiteDatabase musicDB = loader.getWritableDatabase();
        // 3) Добавить загрузку БД из файла в папке assets
        // реализовать отображение содержания таблицы
        // с помощью SimpleCursorAdapter

        Cursor tunes = musicDB.rawQuery("SELECT * FROM playlist", null);
        String[] playlist_fields = tunes.getColumnNames();

        // этот адаптер отображает в ListView перечень полей (столбцов)
        ArrayAdapter<String> aa = new ArrayAdapter<>(this, R.layout.item, playlist_fields );
        lv = (ListView) findViewById(R.id.playlist);
        lv.setAdapter(aa);

        // 1)
        // сделать выборку всех полей из таблицы в Cursor
        // db.rawQuery("<SQL QUERY>", null);
        // создать 2 массива: String[] перечень полей таблицы
        String[] fields = new String[] {"title"};
        int[] views = new int[]{ R.id.title };
        // int[] - ссылки на id элементов разметки playlist_item
        // полученный Cursor использовать для создания адаптера
        // готовый адаптер назначить для ListView

    }

    public void onClick(View v) {
        // 2)
        // добавить в разметку недостающие поля
        // считать из текстовых полей
        // исполнителя, название композиции, год, длительность
        // сделать запись в таблицу,
        // обновить данные адаптера
        //
    }
}
