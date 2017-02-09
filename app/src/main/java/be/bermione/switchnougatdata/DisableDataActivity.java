package be.bermione.switchnougatdata;

import android.os.Bundle;

public class DisableDataActivity extends AbstractDataActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        changeMobileDataState(false);

        finish();
    }
}
