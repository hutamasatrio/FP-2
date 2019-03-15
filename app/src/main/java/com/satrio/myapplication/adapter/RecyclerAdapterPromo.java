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
import com.satrio.myapplication.model.ItemPromo;

import java.util.List;

public class RecyclerAdapterPromo extends RecyclerView.Adapter<RecyclerAdapterPromo.MyViewHolder> {
    private Context mContext ;
    private List<ItemPromo> Produk ;
    ItemPromo dataContent;

    public RecyclerAdapterPromo(Context mContext, List<ItemPromo> Produk) {
        this.mContext = mContext;
        this.Produk = Produk;
    }


    public RecyclerAdapterPromo.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card,parent,false);
        return new RecyclerAdapterPromo.MyViewHolder(view);
    }

    public void onBindViewHolder(RecyclerAdapterPromo.MyViewHolder holder, final int position) {

        dataContent = Produk.get(position);
        holder.tv_book_title.setText(Produk.get(position).getTitle());
        holder.setDisplayImage(dataContent.getImg_url(), mContext);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,ViewProduk.class);

                // passing data to the book activity
                intent.putExtra("Title",Produk.get(position).getTitle());
                intent.putExtra("Description",Produk.get(position).getDescription());
                intent.putExtra("img_url",Produk.get(position).getImg_url());
                intent.putExtra("Harga",Produk.get(position).getHarga());
//                intent.putExtra("Thumbnail",Produk.get(position).getThumbnail());
//                intent.putExtra("Harga",Produk.get(position).getHarga());
                // start the activity
                mContext.startActivity(intent);

            }
        });

    }


    public int getItemCount() {
        return Produk.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //        TextView tv_harga;
        TextView tv_book_title;
        ImageView img_book_thumbnail;
        LinearLayout cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);
//            tv_harga = (TextView) itemView.findViewById(R.id.harga);
            tv_book_title = (TextView) itemView.findViewById(R.id.judul) ;
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.gambar);
            cardView = (LinearLayout) itemView.findViewById(R.id.cardview_id);


        }
        void setDisplayImage(String imageUrl, Context context) {

            ImageView image = itemView.findViewById(R.id.gambar);

            Glide.with(context)
                    .load(imageUrl)
                    .into(image);
        }
    }

}
