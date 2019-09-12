package com.example.crudmahasiswa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudmahasiswa.db.MahasiswaBean;

import java.util.List;

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.ViewHolder> {

    List<MahasiswaBean> beanList;
    private Listener listener;

    public ListDataAdapter(List<MahasiswaBean> beanList) {
        this.beanList = beanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CardView card = (CardView) LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_list_data,
                parent,
                false
        );
        return new ViewHolder(card);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView card = holder.card;
        holder.bean = beanList.get(position);

        TextView textNama = card.findViewById(R.id.text_card_nama);
        textNama.setText(beanList.get(position).getNama());

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener {
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView card;
        MahasiswaBean bean;
        public ViewHolder(CardView card) {
            super(card);
            this.card = card;
        }
    }
}
