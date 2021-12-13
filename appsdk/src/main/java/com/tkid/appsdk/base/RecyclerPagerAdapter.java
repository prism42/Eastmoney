package com.tkid.appsdk.base;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
@SuppressWarnings("rawtypes")
public final class RecyclerPagerAdapter extends PagerAdapter {

    private final RecyclerView.Adapter mAdapter;

    public RecyclerPagerAdapter(RecyclerView.Adapter adapter) {
        if (adapter == null) {
            throw new IllegalArgumentException("are you ok?");
        }
        mAdapter = adapter;
        mAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {

            @Override
            public void onChanged() {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(int positionStart, int itemCount) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(int positionStart, int itemCount, @Nullable Object payload) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getCount() {
        return mAdapter.getItemCount();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        RecyclerView.ViewHolder holder = mAdapter.createViewHolder(container, 0);
        container.addView(holder.itemView);
        mAdapter.onBindViewHolder(holder, position);
        return holder.itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
