package com.example.crudmahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.crudmahasiswa.db.MahasiswaBean;

public class DetailDataActivty extends AppCompatActivity {

    EditText nomorInput;
    EditText namaInput;
    EditText tglLahirInput;
    EditText jenkelInput;
    EditText alamatInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data_activty);

        nomorInput = findViewById(R.id.tfNomerInputDet);
        namaInput = findViewById(R.id.tfInputNamaDet);
        tglLahirInput = findViewById(R.id.tfInputTglLahirDet);
        jenkelInput = findViewById(R.id.tfInputJenkelDet);
        alamatInput = findViewById(R.id.tfInputAlamatDet);

        MahasiswaBean bean = getIntent().getParcelableExtra("mahasiswa");

        nomorInput.setText(bean.getIdMahasiswa()+"");
        namaInput.setText(bean.getNama());
        tglLahirInput.setText(bean.getTglLahir());
        jenkelInput.setText(bean.getJenKel());
        alamatInput.setText(bean.getAlamat());
    }
}
