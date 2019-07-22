package com.example.heroessignal.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.heroessignal.Model.Hero;
import com.example.heroessignal.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.HeroesViewHolder> {

    private List<Hero> heroes;

    public ListAdapter(List<Hero> heroes) {
        this.heroes = heroes;
    }

    @NonNull
    @Override
    public HeroesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.heroes_item, viewGroup, false);
        HeroesViewHolder heroesViewHolder = new HeroesViewHolder(view);
        return heroesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HeroesViewHolder heroesViewHolder, int i) {
        Hero hero = heroes.get(i);
        heroesViewHolder.tvNameHero.setText(hero.getName());
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    public class HeroesViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNameHero;

        public HeroesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameHero = itemView.findViewById(R.id.tvNameHero);
        }
    }
}
