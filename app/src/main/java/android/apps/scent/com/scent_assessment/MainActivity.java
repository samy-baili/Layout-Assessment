package android.apps.scent.com.scent_assessment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
//        RecyclerView recyclerView = findViewById(R.id.left_panel_recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
