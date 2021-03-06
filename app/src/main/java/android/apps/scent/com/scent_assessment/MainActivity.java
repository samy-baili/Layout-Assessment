package android.apps.scent.com.scent_assessment;

import android.apps.scent.com.scent_assessment.ui.adapter.BestSellersDummyPagerAdapter;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        ViewPager pager = findViewById(R.id.best_sellers_view_pager);
        pager.setAdapter(new BestSellersDummyPagerAdapter(this));
        pager.setOffscreenPageLimit(3);

        Glide.with(this).load(getString(R.string.banner_url)).into((ImageView) findViewById(R.id.banner));
    }


}
