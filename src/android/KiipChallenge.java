package cordova-plugin-kiip-challenge;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import kennedy.kyle.r.kiipmobilechallengelibrary.HackerNews;

/**
 * This class echoes a string called from JavaScript.
 */
public class KiipChallenge extends CordovaPlugin {
    HackerNews mHackerNews;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("initSDK")) {
            // String message = args.getString(0);
            this.initSDK(callbackContext);
            return true;
        }
        if (action.equals("showHackerNews")){
          this.showHackerNews(callbackContext);
          return true;
        }
        return false;
    }

    private void initSDK(CallbackContext callbackContext) {
        if (mHackerNews == null) {
          mHackerNews = new HackerNews();
        }
        Context context = this.cordova.getActivity(); //.getApplicationContext();
        mHackerNews.initSDK(context);
        callbackContext.success("initSDK has completed");
    }

    private void showHackerNews(String message, CallbackContext callbackContext) {
        if(mHackerNews == null) {
          callbackContext.error("initSDK must be called first.");
          return;
        }
        mHackerNews.showHackerNews();
        callbackContext.success("showHackerNews has completed");
    }
}
