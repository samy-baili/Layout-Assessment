package android.apps.scent.com.scent_assessment.ui;

import android.apps.scent.com.scent_assessment.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SquareArticleView extends FrameLayout {

    private ImageView articleImage;
    private TextView articleCategory;

    public SquareArticleView(@NonNull Context context) {
        super(context);

        init(context);
    }

    public SquareArticleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initAttrs(context, attrs);
    }

    private void init(Context context) {
        inflate(context, R.layout.square_article_view_layout, this);

        this.articleImage = findViewById(R.id.article_image);
        this.articleCategory = findViewById(R.id.article_category);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        init(context);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SquareArticleView);

        setCategory(a.getString(R.styleable.SquareArticleView_category));
        setImageUrl(a.getString(R.styleable.SquareArticleView_image_url_article));

        a.recycle();
    }

    public void setCategory(String text) {
        this.articleCategory.setText(text);
    }

    public void setImageUrl(String text) {
        Glide.with(this).load(text).into(articleImage);
    }
}
