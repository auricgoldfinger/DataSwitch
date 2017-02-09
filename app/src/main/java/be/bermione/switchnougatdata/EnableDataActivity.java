package be.bermione.switchnougatdata;

import android.os.Bundle;

public class EnableDataActivity extends AbstractDataActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        changeMobileDataState(true);

        finish();
    }
}
