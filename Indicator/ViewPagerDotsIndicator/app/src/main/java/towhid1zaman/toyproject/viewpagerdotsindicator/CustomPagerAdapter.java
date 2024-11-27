package towhid1zaman.toyproject.viewpagerdotsindicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomPagerAdapter extends RecyclerView.Adapter<CustomPagerAdapter.PageViewHolder> {

    private final List<Integer> pages;
    private final Context context;

    public CustomPagerAdapter(List<Integer> pages, Context context) {
        this.pages = pages;
        this.context = context;
    }

    @NonNull
    @Override
    public PageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.page_item, parent, false);
        return new PageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PageViewHolder holder, int position) {
        // Set the background color or content of the page
        holder.itemView.setBackgroundResource(pages.get(position));
    }

    @Override
    public int getItemCount() {
        return pages.size();
    }

    public static class PageViewHolder extends RecyclerView.ViewHolder {
        public PageViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
