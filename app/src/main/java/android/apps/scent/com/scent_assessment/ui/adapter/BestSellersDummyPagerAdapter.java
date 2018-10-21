package android.apps.scent.com.scent_assessment.ui.adapter;

import android.app.Activity;
import android.apps.scent.com.scent_assessment.R;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class BestSellersDummyPagerAdapter extends PagerAdapter {

    private Activity activity;

    public BestSellersDummyPagerAdapter(Activity activity) {
        this.activity = activity;
    }

    public Object instantiateItem(@NonNull View collection, int position) {

        int resId = 0;
        switch (position) {
            case 0:
                resId = R.id.page_one;
                break;
            case 1:
                resId = R.id.page_two;
                break;
            case 2:
                resId = R.id.page_three;
                break;
        }
        return activity.findViewById(resId);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == ((View) arg1);
    }
}