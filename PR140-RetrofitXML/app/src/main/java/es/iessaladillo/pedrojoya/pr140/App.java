package es.iessaladillo.pedrojoya.pr140;

import android.app.Application;

import com.facebook.stetho.Stetho;

@SuppressWarnings("WeakerAccess")
public class App extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
