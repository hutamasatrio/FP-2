package com.satrio.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.satrio.myapplication.fragment.Fragment3;
import com.satrio.myapplication.R;
import com.satrio.myapplication.room.Distributor;

import java.util.List;

public class RecyclerAdapterDistributor extends RecyclerView.Adapter<RecyclerAdapterDistributor.ViewHolder> {

    public Fragment3 DistributorContext;
    public List<Distributor> mData ;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvNomor, tvAlamat, tvKota, tvNIK;
        FrameLayout mLayoutRiwayat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNIK = itemView.findViewById(R.id.tvNIK);
            tvKota = itemView.findViewById(R.id.tvKota);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvNomor = itemView.findViewById(R.id.tvNomor);
            //mLayoutRiwayat = itemView.findViewById(R.id.);
        }
    }
    public RecyclerAdapterDistributor (List<Distributor> mData, Fragment3 mContext){
        this.DistributorContext = mContext;
        this.mData = mData;}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_distributor, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {
        final Distributor travelDB = mData.get(i);
        holder.tvNama.setText(travelDB.getNama());
        holder.tvNIK.setText(travelDB.getNik());
        holder.tvKota.setText(travelDB.getKota());
        holder.tvAlamat.setText(travelDB.getAlamat());
        holder.tvNomor.setText(travelDB.getTelepon());

//        holder.mLayoutRiwayat.setOnClickListener(new View.OnClickListener() {
//            String DataDB = String.valueOf(travelDB.getId());
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(DistributorContext.getActivity(), RecyclerAdapterDistributor.class);
//                intent.putExtra("data", DataDB);
//                DistributorContext.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return  mData.size();
    }

}

