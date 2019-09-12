package com.example.crudmahasiswa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.crudmahasiswa.db.DatabaseHelper;
import com.example.crudmahasiswa.db.MahasiswaBean;

import java.util.List;

public class ListDataActivity extends AppCompatActivity {

    RecyclerView recyclerView;

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
                getSupportActionBar().setTitle(v.bean.getAlamat());
            }
        });

        final LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);



    }
}
