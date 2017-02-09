package be.bermione.switchnougatdata.shortcuts;

import android.os.Bundle;

import be.bermione.switchnougatdata.DisableDataActivity;
import be.bermione.switchnougatdata.R;

public class CreateDisableMobileDataShortcutActivity extends AbstractCreateShortcutActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ShortCutDto shortCutDto = new ShortCutDto(
                DisableDataActivity.class,
                R.string.disable_mobile_data,
                R.mipmap.disable_data_icon
        );

        createShortcut(shortCutDto);

        finish();
    }
}
