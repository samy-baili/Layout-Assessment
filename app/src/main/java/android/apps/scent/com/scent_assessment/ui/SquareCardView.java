package android.apps.scent.com.scent_assessment.ui;

import android.apps.scent.com.scent_assessment.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

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
        setSelectionMode(a.getBoolean(R.styleable.SquareCardView_isSelected, false));

        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = getContext().getResources().getDimensionPixelSize(R.dimen.square_card_size);
        setMeasuredDimension(size, size);
    }

    public void setLabelValue(String label) {
        this.label.setText(label);
    }

    public void setSelectionMode(boolean isSelected) {
        if (isSelected) {
            tab.setVisibility(VISIBLE);
        }
        else {
            tab.setVisibility(INVISIBLE);
        }
    }
}
