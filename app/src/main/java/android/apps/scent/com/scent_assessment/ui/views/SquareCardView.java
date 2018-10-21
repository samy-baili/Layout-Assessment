package android.apps.scent.com.scent_assessment.ui.views;

import android.apps.scent.com.scent_assessment.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

public class SquareCardView extends CardView {

    private View tab;
    private TextView label;
    private ImageView icon;

    public SquareCardView(@NonNull Context context) {
        super(context);

        init(context);
    }

    public SquareCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initAttrs(context, attrs);
    }

    private void init(Context context) {
        inflate(context, R.layout.square_card_view_layout, this);

        this.tab = findViewById(R.id.tab_selection);
        this.label = findViewById(R.id.label);
        this.icon = findViewById(R.id.icon);

        Resources res = context.getResources();

        setCardElevation(res.getDimensionPixelSize(R.dimen.square_card_elevation));
        setCardBackgroundColor(Color.WHITE);
        setRadius(res.getDimensionPixelSize(R.dimen.square_card_radius));
        setUseCompatPadding(true);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        init(context);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SquareCardView);

        setLabelValue(a.getString(R.styleable.SquareCardView_labelCard));
        setSelectionMode(a.getBoolean(R.styleable.SquareCardView_isSelected, false), a.getInteger(R.styleable.SquareCardView_iconCard, android.R.drawable.stat_sys_warning));

        a.recycle();
    }

    public void setLabelValue(String label) {
        this.label.setText(label);
    }

    public void setSelectionMode(boolean isSelected, int drawable) {
        if (isSelected) {
            tab.setVisibility(VISIBLE);
            setIcon(drawable, Color.BLACK);
        }
        else {
            tab.setVisibility(GONE);
            setIcon(drawable, ContextCompat.getColor(getContext(), R.color.light_grey));
        }
    }

    private void setIcon(@DrawableRes int res, int color) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), res);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
            icon.setImageDrawable(drawable);
        }
    }
}
