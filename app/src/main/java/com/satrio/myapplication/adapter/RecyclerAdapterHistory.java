package com.satrio.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.satrio.myapplication.R;
import com.satrio.myapplication.ViewProduk;
import com.satrio.myapplication.model.ItemNew;
import com.satrio.myapplication.model.Request;

import java.util.List;

public class RecyclerAdapterHistory extends RecyclerView.Adapter<RecyclerAdapterHistory.MyViewHolder> {
    private Context mContext ;
    private List<Request> Produk ;
    Request dataContent;

    public RecyclerAdapterHistory(Context mContext, List<Request> Produk) {
        this.mContext = mContext;
        this.Produk = Produk;
    }


    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_history,parent,false);
        return new MyViewHolder(view);
    }

    public void onBindViewHolder(MyViewHolder holder, final int position) {

        dataContent = Produk.get(position);
        holder.tv_book_title.setText(Produk.get(position).getNamabarang());
        holder.setDisplayImage(dataContent.getGambarproduk(), mContext);
        holder.alamat.setText(Produk.get(position).getAlamatpemesanan());
        holder.harga.setText(Produk.get(position).getHargatotal());
        holder.atm.setText(Produk.get(position).getAtmpemesanan());
        holder.jumlah.setText(Produk.get(position).getJumlahbarang());
        //holder.deskripsi.setText(Produk.get(position).getDeskripsibarang());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(mContext,ViewProduk.class);
//
//                // passing data to the book activity
//                intent.putExtra("Title",Produk.get(position).getTitle());
//                intent.putExtra("Description",Produk.get(position).getDescription());
//                intent.putExtra("img_url",Produk.get(position).getImg_url());
//                intent.putExtra("Harga",Produk.get(position).getHarga());
////                intent.putExtra("Thumbnail",Produk.get(position).getThumbnail());
////                intent.putExtra("Harga",Produk.get(position).getHarga());
////                // start the activity
//                mContext.startActivity(intent);

            }
        });

    }


    public int getItemCount() {
        return Produk.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //        TextView tv_harga;
        TextView tv_book_title,
                harga, atm, jumlah, deskripsi, alamat;
        ImageView img_book_thumbnail;
        LinearLayout cardView ;


        public MyViewHolder(View itemView) {
            super(itemView);

            tv_book_title = (TextView) itemView.findViewById(R.id.titlehistory) ;
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.gambarhistory);
            cardView = (LinearLayout) itemView.findViewById(R.id.linear);
            harga = (TextView) itemView.findViewById(R.id.hargahistory);
            atm = (TextView) itemView.findViewById(R.id.atm);
            jumlah = (TextView) itemView.findViewById(R.id.jumlahpembelian);
            //deskripsi = (TextView) itemView.findViewById(R.id.deskhistory) ;
            alamat = (TextView) itemView.findViewById(R.id.alamatpembelian) ;

        }
        void setDisplayImage(String imageUrl, Context context) {

            ImageView image = itemView.findViewById(R.id.gambarhistory);

            Glide.with(context)
                    .load(imageUrl)
                    .into(image);
        }
    }

}
