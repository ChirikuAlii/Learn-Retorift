package id.chirikualii.codingtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.Holder> {


    List<String> dogsList;

    public DogAdapter(List<String> dogsList) {
        this.dogsList = dogsList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        String dogs = dogsList.get(position);
        holder.bind(dogs,position);
    }


    @Override
    public int getItemCount() {
        return dogsList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public Holder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgView);
        }

        public void bind(String dog, int position) {

            Glide.with(itemView)
                    .load(dog)
                    .into(imageView);






        }
    }

}
