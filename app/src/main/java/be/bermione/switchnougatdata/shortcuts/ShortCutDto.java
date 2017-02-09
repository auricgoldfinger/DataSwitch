package be.bermione.switchnougatdata.shortcuts;

import be.bermione.switchnougatdata.AbstractDataActivity;

public class ShortCutDto {

    private final Class<? extends AbstractDataActivity> shortcutActivity;
    private final int shortcutName;
    private final int icon;

    public ShortCutDto(final Class<? extends AbstractDataActivity> shortcutActivity, int shortcutName, int icon) {
        this.shortcutActivity = shortcutActivity;
        this.shortcutName = shortcutName;
        this.icon = icon;
    }

    public Class<? extends AbstractDataActivity> getShortcutActivity() {
        return shortcutActivity;
    }

    public int getShortcutName() {
        return shortcutName;
    }

    public int getIcon() {
        return icon;
    }
}
