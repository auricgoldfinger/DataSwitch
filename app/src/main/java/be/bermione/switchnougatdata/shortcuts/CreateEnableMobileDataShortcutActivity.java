package be.bermione.switchnougatdata.shortcuts;

import android.os.Bundle;

import be.bermione.switchnougatdata.EnableDataActivity;
import be.bermione.switchnougatdata.R;

public class CreateEnableMobileDataShortcutActivity extends AbstractCreateShortcutActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ShortCutDto shortCutDto = new ShortCutDto(
                EnableDataActivity.class,
                R.string.enable_mobile_data,
                R.mipmap.enable_data_icon
        );

        createShortcut(shortCutDto);

        finish();
    }
}
