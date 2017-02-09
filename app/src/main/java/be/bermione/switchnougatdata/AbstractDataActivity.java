package be.bermione.switchnougatdata;

import android.app.Activity;
import android.widget.Toast;

import com.stericson.RootShell.RootShell;
import com.stericson.RootShell.exceptions.RootDeniedException;
import com.stericson.RootShell.execution.Command;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

abstract class AbstractDataActivity extends Activity {

    protected void changeMobileDataState(final boolean enableData) {

        if (RootShell.isAccessGiven()) {
            try {
                final Command dataCommand = new Command(0, "svc data " + (enableData ? "enable" : "disable"));
                RootShell.getShell(true).add(dataCommand);

            } catch (IOException | TimeoutException | RootDeniedException e) {
                e.printStackTrace();
            }
        } else if (!RootShell.isRootAvailable()) {
            Toast.makeText(this, "Root is not available", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "You must give me root access", Toast.LENGTH_LONG).show();
        }

    }
}
