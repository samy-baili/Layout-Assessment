package android.apps.scent.com.scent_assessment.ui.adapter;

import android.app.Activity;
import android.apps.scent.com.scent_assessment.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class BestSellersDummyPagerAdapter extends PagerAdapter {

    private LayoutInflater inflater;

    public BestSellersDummyPagerAdapter(Activity activity) {
        this.inflater = LayoutInflater.from(activity);
    }

    @Override
    public @NonNull Object instantiateItem(@NonNull ViewGroup collection, int position) {
        View v = inflater.inflate(R.layout.add_article_views_dummy_layout, collection, false);
        collection.addView(v, position);
        return v;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup collection, int position, @NonNull Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View arg0, @NonNull Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.9f;
    }
}