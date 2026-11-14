package com.example.todoapp;

import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText input;
    ListView list;
    SQLiteDatabase db;
    ArrayList<String> tasks = new ArrayList<>();
    ArrayList<Integer> taskIds = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.taskInput);
        list = findViewById(R.id.taskList);

        db = openOrCreateDatabase("TodoDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS tasks (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "task TEXT)");

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, tasks);
        list.setAdapter(adapter);

        findViewById(R.id.addTask).setOnClickListener(v -> addTask());

        list.setOnItemLongClickListener((parent, view, position, id) -> {
            int taskId = taskIds.get(position);
            db.delete("tasks", "id=?", new String[]{String.valueOf(taskId)});
            loadTasks();
            Toast.makeText(this, "Task deleted", Toast.LENGTH_SHORT).show();
            return true;
        });

        loadTasks();
    }

    void addTask() {
        String task = input.getText().toString().trim();
        if (task.isEmpty()) return;

        db.execSQL("INSERT INTO tasks(task) VALUES(?)",
                new Object[]{task});
        input.setText("");
        loadTasks();
    }

    void loadTasks() {
        tasks.clear();
        taskIds.clear();
        Cursor c = db.rawQuery("SELECT id, task FROM tasks ORDER BY id DESC",
                null);
        while (c.moveToNext()) {
            taskIds.add(c.getInt(0));
            tasks.add(c.getString(1));
        }
        c.close();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        if (db != null) db.close();
        super.onDestroy();
    }
}
