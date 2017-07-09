package mahesh.webservice.com.webservicetestassignment;

import android.content.Context;
import android.os.StrictMode;
import android.support.multidex.BuildConfig;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import mahesh.webservice.com.webservicetestassignment.activity.network.BitmapLruCache;
import mahesh.webservice.com.webservicetestassignment.activity.network.OkHttpStack;
import mahesh.webservice.com.webservicetestassignment.activity.utils.StringUtils;


public class App extends MultiDexApplication {
    /* To enable Multi-Dex, you have 3 options -
           1. Declare android.support.multidex.MultiDexApplication as your application class in AndroidManifest.xml
           2. Extend MultiDexApplication like we are doing here
           3. Override attachBaseContext() in your application class as shown below
       /*

        */
    /*
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    */
    private static final String TAG = App.class.getSimpleName();
    private static Context sAppContext;
    private RequestQueue mRequestQueue = null;
    // Volley image cache
    private BitmapLruCache mBitmapLruCache;
    // Volley image loader
    private ImageLoader mImageLoader;
    private static App sInstance;

    @Override
    public void onCreate() {
        if (BuildConfig.DEBUG) {
            StrictMode.enableDefaults();
        }
        super.onCreate();
        //support for vector drawable icons pre lolipop version
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        sInstance = this;
        sAppContext = getApplicationContext();
//        ErrorReporter errReporter = new ErrorReporter();
//        errReporter.Init(this);
//        errReporter.SaveLog(this, "Drriight");
        // Initialize the SDK before executing any other operations,
//        FacebookSdk.sdkInitialize(sAppContext);
//        AppEventsLogger.activateApp(this);
//        Fabric.with(this, new Crashlytics());
    }

    public static App getInstance() {
        return sInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(sAppContext, new OkHttpStack());
        }
        return mRequestQueue;
    }

    public <T> Request addToRequestQueue(Request<T> req, String tag) {
        req.setTag(StringUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
        return req;
    }

    public <T> Request addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
        return req;
    }

    public void cancelPendingRequests(Object tag) {
        if (getRequestQueue() != null) {
            final Object requestTag = StringUtils.isEmpty(String.valueOf(tag)) ? TAG : tag;
            getRequestQueue().cancelAll(requestTag);
        }
    }

    /**
     * Returns an image loader instance to be used with Volley.
     *
     * @return {@link com.android.volley.toolbox.ImageLoader}
     */
    public ImageLoader getVolleyImageLoader() {
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(
                    getRequestQueue(),
                    App.getInstance().getImageCache()
            );
        }
        return mImageLoader;
    }

    /**
     * Returns a bitmap cache to use.
     *
     * @return {@link BitmapLruCache}
     */
    private BitmapLruCache getImageCache() {
        if (mBitmapLruCache == null) {
            mBitmapLruCache = new BitmapLruCache();
        }
        return mBitmapLruCache;
    }


    public static Context getAppContext() {
        return sAppContext;
    }

    public static void logInfo(String s) {
        Log.i("chk", s);
    }
}