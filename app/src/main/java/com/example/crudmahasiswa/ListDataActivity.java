package com.example.crudmahasiswa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.crudmahasiswa.db.DatabaseHelper;
import com.example.crudmahasiswa.db.MahasiswaBean;

import java.util.List;

public class ListDataActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CharSequence[] dialogItems = {"Update", "Delete"};
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);
        recyclerView = findViewById(R.id.recycler_list_data);

        DatabaseHelper db = new DatabaseHelper(this);
        List<MahasiswaBean> beanList = db.selectUserData();
        final ListDataAdapter adapter = new ListDataAdapter(beanList);

        adapter.setListener(new ListDataAdapter.Listener() {
            @Override
            public void onClick(int position) {
                ListDataAdapter.ViewHolder v = (ListDataAdapter.ViewHolder) recyclerView.findViewHolderForLayoutPosition(position);
                Intent intent = new Intent(ListDataActivity.this, DetailDataActivty.class);
                intent.putExtra("mahasiswa", v.bean);
                startActivity(intent);
            }
        });
        adapter.setLongClickListener(new ListDataAdapter.Listener() {
            @Override
            public void onClick(int position) {
                new AlertDialog.Builder(context)
                        .setTitle("Operation")
                        .setItems(dialogItems, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                switch(i) {
                                    case 0:
                                        Intent intent = new Intent(context, UpdateDataActivty.class);
                                        startActivity(intent);
                                        break;
                                    case 1:

                                        break;
                                }
                            }
                        })
                        .show();
            }
        });

        final LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);



    }
}
