package com.satrio.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.satrio.myapplication.R;
import com.satrio.myapplication.room.Distributor;

import java.util.List;

public class RecycleAdapterDAO extends RecyclerView.Adapter<RecycleAdapterDAO.MyViewHolder> {
    private Context mContext;
    private List<Distributor> myList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvAlamat;
        public TextView tvKota;
        public TextView tvNama;
        public TextView tvNik;
        public TextView tvNomor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvKota = itemView.findViewById(R.id.tvKota);
            tvNik = itemView.findViewById(R.id.tvNIK);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNomor = itemView.findViewById(R.id.tvNomor);
        }
    }

    public RecycleAdapterDAO(Context mContext, List<Distributor> albumList) {
        this.mContext = mContext;
        this.myList = albumList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_distributor, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Distributor album = myList.get(i);
        myViewHolder.tvNama.setText(album.getNama());
        myViewHolder.tvNik.setText(album.getNik());
        myViewHolder.tvKota.setText(album.getKota());
        myViewHolder.tvAlamat.setText(album.getAlamat());
        myViewHolder.tvNomor.setText(album.getTelepon());

        myViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
//                FragmentManager fm = ((Activity)mContext).getFragmentManager();
//                UpdateDialog dialogFragment = new UpdateDialog(onclickRecycler);
//                Bundle bundle = new Bundle();
//                bundle.putInt("id",myList.get(i).getId());
//                bundle.putInt("id_list",i);
//                dialogFragment.setArguments(bundle);
//                dialogFragment.show(fm," ");
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

}
