package towhid1zaman.toyproject.viewpagerdotsindicator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class WearPageIndicatorActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private LinearLayout dotLayout;
    private List<Integer> pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear_page_indicator);

        // Initialize ViewPager2 and dot layout
        viewPager = findViewById(R.id.viewPager);
        dotLayout = findViewById(R.id.dotLayout);

        // Add pages (each page is represented by a color or image resource)
        pages = new ArrayList<>();
        pages.add(R.color.page1_color);
        pages.add(R.color.page2_color);
        pages.add(R.color.page3_color);

        // Set adapter
        viewPager.setAdapter(new CustomPagerAdapter(pages, this));

        // Set up dots for page indicators
        setupPageIndicators();
    }

    private void setupPageIndicators() {
        int pageCount = pages.size();
        ImageView[] dots = new ImageView[pageCount];

        for (int i = 0; i < pageCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageResource(R.drawable.unselected_dot);
            dots[i].setPadding(8, 0, 8, 0);

            dotLayout.addView(dots[i]);
        }

        // Highlight the first dot
        dots[0].setImageResource(R.drawable.selected_dot);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                for (int i = 0; i < pageCount; i++) {
                    dots[i].setImageResource(R.drawable.unselected_dot);
                }
                dots[position].setImageResource(R.drawable.selected_dot);
            }
        });
    }
}