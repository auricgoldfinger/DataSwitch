package be.bermione.switchnougatdata;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

import com.stericson.RootShell.RootShell;
import com.stericson.RootShell.exceptions.RootDeniedException;
import com.stericson.RootShell.execution.Command;
import com.stericson.RootShell.execution.Shell;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeoutException;

public abstract class AbstractDataActivity extends Activity {

    protected void changeMobileDataState(final boolean enableData) {

        boolean isMobileDataEnabled = false; // Assume disabled
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            final Class cmClass = Class.forName(cm.getClass().getName());
            final Method method = cmClass.getDeclaredMethod("getMobileDataEnabled");
            method.setAccessible(true); // Make the method callable
            // get the setting for "mobile data"
            isMobileDataEnabled = (Boolean) method.invoke(cm);
        } catch (Exception e) {
            // Some problem accessible private API
            // TODO do whatever error handling you want here
            Log.e(getClass().getSimpleName(), e.getMessage(), e);
        }

        final String newDataState = enableData ? "enable" : "disable";

        if (enableData && !isMobileDataEnabled || !enableData && isMobileDataEnabled) {

            if (RootShell.isAccessGiven()) {
                try {

                    final Command dataCommand = new Command(0, "svc data " + newDataState);
                    final Shell shell = RootShell.getShell(true);
                    shell.add(dataCommand);
                    shell.close();

                    final String msg = String.format("Mobile data %sd", newDataState);
                    Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                    Log.i(getClass().getSimpleName(), msg);

                    RootShell.closeAllShells();

                } catch (IOException | TimeoutException | RootDeniedException e) {
                    e.printStackTrace();
                }
            } else if (!RootShell.isRootAvailable()) {
                final String msg = "Root is not available";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                Log.e(getClass().getSimpleName(), msg);
            } else {
                final String msg = "You must give me root access";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                Log.e(getClass().getSimpleName(), msg);
            }
        } else {
            final String msg = String.format("Mobile data is already %sd", newDataState);
            //Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            Log.i(getClass().getSimpleName(), msg);
        }

    }
}
