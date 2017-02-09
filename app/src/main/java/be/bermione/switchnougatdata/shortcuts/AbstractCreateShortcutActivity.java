package be.bermione.switchnougatdata.shortcuts;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

public class AbstractCreateShortcutActivity extends Activity {

    protected void createShortcut(final ShortCutDto shortCutDto) {
        Log.i("CreateShortcut", "Creating first intent called, classname = " + shortCutDto.getShortcutActivity().getName());
//        Intent newShortcutIntent = new Intent();
//        newShortcutIntent.setClassName(shortCutDto.getPackageName(), shortCutDto.getClassName());
        final Intent newShortcutIntent = new Intent(this, shortCutDto.getShortcutActivity());
        newShortcutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        newShortcutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        newShortcutIntent.setAction(Intent.ACTION_MAIN);

        Log.i("CreateShortcut", "Creating addIntent for broadcasting");
        Intent addIntent = new Intent();
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, newShortcutIntent);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getString(shortCutDto.getShortcutName()));
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(getApplicationContext(), shortCutDto.getIcon()));
        addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        addIntent.putExtra("duplicate", false);
        //getApplicationContext().sendBroadcast(addIntent);
        setResult(RESULT_OK, addIntent);
    }
}
