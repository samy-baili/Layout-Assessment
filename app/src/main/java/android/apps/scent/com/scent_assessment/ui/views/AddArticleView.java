package android.apps.scent.com.scent_assessment.ui.views;

import android.apps.scent.com.scent_assessment.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.core.content.ContextCompat;

public class AddArticleView extends FrameLayout {

    private ImageView articleImage;
    private TextView articleBrand;
    private TextView articleDescription;
    private TextView articlePrice;
    private TextView articleNewPrice;
    private View divider;

    public AddArticleView(Context context) {
        super(context);

        init(context);
    }

    public AddArticleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initAttr(context, attrs);
    }

    private void init(Context context) {
        inflate(context, R.layout.add_article_view_layout, this);

        this.articleImage = findViewById(R.id.article_image);
        this.articleBrand = findViewById(R.id.article_brand);
        this.articleDescription = findViewById(R.id.article_description);
        this.articlePrice = findViewById(R.id.article_price);
        this.articleNewPrice = findViewById(R.id.article_new_price);
        this.divider = findViewById(R.id.divider);
    }

    private void initAttr(Context context, AttributeSet attrs) {
        init(context);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AddArticleView);

        setBrand(a.getString(R.styleable.AddArticleView_brand));
        setDescription(a.getString(R.styleable.AddArticleView_description));
        setPrice(a.getString(R.styleable.AddArticleView_price));
        setNewPrice(a.getString(R.styleable.AddArticleView_new_price));
        setImageUrl(a.getString(R.styleable.AddArticleView_image_url));
        displayDivider(a.getBoolean(R.styleable.AddArticleView_display_divider, true));

        a.recycle();
    }

    public void setBrand(String text) {
        this.articleBrand.setText(text);
    }

    public void setDescription(String text) {
        this.articleDescription.setText(text);
    }

    public void setPrice(String text) {
        this.articlePrice.setText(text);
    }

    public void setNewPrice(String text) {
        if (text != null && !text.isEmpty()) {
            this.articleNewPrice.setText(text);
            strikeThroughPrice();
        }
    }

    public void setImageUrl(String text) {
        Glide.with(this).load(text).into(articleImage);
    }

    public void displayDivider(boolean display) {
        divider.setVisibility(display ? VISIBLE : INVISIBLE);
    }

    private void strikeThroughPrice() {
        articlePrice.setPaintFlags(articlePrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        articlePrice.setTextColor(ContextCompat.getColor(getContext(), R.color.light_grey));
    }
}
