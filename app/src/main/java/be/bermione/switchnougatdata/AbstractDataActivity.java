package be.bermione.switchnougatdata;

import android.app.Activity;
import android.widget.Toast;

import com.stericson.RootShell.RootShell;
import com.stericson.RootShell.exceptions.RootDeniedException;
import com.stericson.RootShell.execution.Command;
import com.stericson.RootShell.execution.Shell;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public abstract class AbstractDataActivity extends Activity {

    protected void changeMobileDataState(final boolean enableData) {

        if (RootShell.isAccessGiven()) {
            try {
                String dataState = enableData ? "enable" : "disable";
                final Command dataCommand = new Command(0, "svc data " + dataState);
                final Shell shell = RootShell.getShell(true);
                shell.add(dataCommand);
                shell. close();

                Toast.makeText(this, String.format("Mobile data %sd", dataState), Toast.LENGTH_LONG).show();

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
