package com.mapformcpe.popularmapsforminecraftpe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdpaterIteam extends RecyclerView.Adapter<AdpaterIteam.ViewHolder> {
    Context context;
    int layoutInflater;
    List<Skinmodel> listskin;

    public AdpaterIteam(Context context, int layoutInflater, List<Skinmodel> listskin) {
        this.context = context;
        this.layoutInflater = layoutInflater;
        this.listskin = listskin;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.iteam_icon,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Skinmodel skinmodel=listskin.get(position);
        holder.imgSkin.setBackgroundResource(skinmodel.getAnh());
        holder.txtSkin.setText(skinmodel.getType());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ShowSkin.class);
                intent.putExtra("i_skin",skinmodel.type);
                intent.putExtra("anh",skinmodel.anh);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listskin.size();
    }

    class ViewHolder  extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imgSkin;
        TextView txtSkin;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.cardapp);
            imgSkin=itemView.findViewById(R.id.img_icon);
            txtSkin=itemView.findViewById(R.id.txt_icon);
        }
    }
}
