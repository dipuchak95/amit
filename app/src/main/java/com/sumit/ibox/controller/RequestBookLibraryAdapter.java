package com.sumit.ibox.controller;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sumit.ibox.R;
import com.sumit.ibox.model.RequestBookLibraryData;

import java.util.ArrayList;
import java.util.Random;

public class RequestBookLibraryAdapter extends RecyclerView.Adapter<RequestBookLibraryAdapter.ViewHolder> {

    private Context context;
    private ArrayList<RequestBookLibraryData> requestBookLibrariesList;
    TouchEvents touchEvents = null;

    public RequestBookLibraryAdapter(Context context, ArrayList<RequestBookLibraryData> requestBookLibrariesList, TouchEvents touchEvents) {
        this.context = context;
        this.requestBookLibrariesList = requestBookLibrariesList;
        this.touchEvents = touchEvents;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_request_book_library_card, parent, false);
        return new RequestBookLibraryAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        RequestBookLibraryData requestBookLibraryData = requestBookLibrariesList.get(position);
        int randomAndroidColor = holder.androidColors[new Random().nextInt(holder.androidColors.length)];
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.OVAL);
        shape.setColor(randomAndroidColor);
        holder.library_card_view_line.setBackgroundColor(randomAndroidColor);

        holder.library_thumb.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_transition_animation));
        holder.cardLayout.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_scale_animation));
        holder.library_card_view_line.setAnimation(AnimationUtils.loadAnimation(context, R.anim.anime_left_to_right));

        holder.reqBookAuthorName.setText(requestBookLibraryData.getBookAuthor());
        holder.requestBookName.setText(requestBookLibraryData.getBookName());
        holder.requestBookName.setText(requestBookLibraryData.getBookName());
        holder.requestBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestBookLibraryData requestBookLibraryData = requestBookLibrariesList.get(position);
                touchEvents.onClick(requestBookLibraryData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return requestBookLibrariesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView requestBookName,reqBookAuthorName,library_thumb;
        ImageView requestBook;
        int[] androidColors;
        View library_card_view_line;
        CardView cardLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            androidColors = itemView.getResources().getIntArray(R.array.androidcolors);
            requestBookName = itemView.findViewById(R.id.req_book_lib_author);
            reqBookAuthorName = itemView.findViewById(R.id.req_book_lib_name);
            requestBook = itemView.findViewById(R.id.req_book_send_request);
            cardLayout = itemView.findViewById(R.id.container);
            library_thumb = itemView.findViewById(R.id.library_thumb);
            library_card_view_line = itemView.findViewById(R.id.library_card_view_line);
        }
    }

    public interface TouchEvents{
        void onClick(RequestBookLibraryData bookData);
    }
}
