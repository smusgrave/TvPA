package com.smusgrave.app.tvpa.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smusgrave.app.tvpa.R;
import com.smusgrave.app.tvpa.model.Show;
import com.smusgrave.app.tvpa.ui.showdetails.ShowDetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShowRecyclerAdapter extends RecyclerView.Adapter<ShowRecyclerAdapter.ViewHolder> {

    private List<Show> shows;

    public ShowRecyclerAdapter() {
        this.shows = new ArrayList<>();
    }

    public ShowRecyclerAdapter(List<Show> shows) {
        this.shows = shows;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View showView = LayoutInflater
                .from(parent.getContext()).inflate(R.layout.show_search_row, parent, false);
        return new ViewHolder(showView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Show show = shows.get(position);

        holder.name.setText(show.name);
        holder.summary.setText(Html.fromHtml(show.summary));

        if (show.image == null) {
            holder.image.setVisibility(View.GONE);
        } else {
            holder.image.setVisibility(View.VISIBLE);
            Picasso.with(holder.image.getContext())
                    .load(show.image.medium)
                    .into(holder.image);
        }

        holder.view.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = ShowDetailsActivity.getIntent(context, show.id);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return shows.size();
    }

    public void add(Show show) {
        shows.add(show);
        notifyDataSetChanged();
    }

    public void add(List<Show> shows) {
        this.shows.addAll(shows);
        notifyDataSetChanged();
    }

    public void clear() {
        this.shows.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final View view;
        @Bind(R.id.search_show_image) ImageView image;
        @Bind(R.id.search_show_name) TextView name;
        @Bind(R.id.search_show_summary) TextView summary;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            ButterKnife.bind(this, view);
        }

    }

}
