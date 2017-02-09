package be.bermione.switchnougatdata;

import android.app.Activity;
import android.os.Bundle;

public class VoidActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        finish();
    }
}
