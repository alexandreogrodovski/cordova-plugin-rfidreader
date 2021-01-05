package itaipubinacional.cordova.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
//import com.rscja.deviceapi.RFIDWithUHF;

public class RFIDReaderPlugin extends CordovaPlugin {

  private static final String START = "start";
  private static final String STOP = "stop";
  private static final String READ = "read";

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {

    try {
      switch (action) {
        case START:
          callbackContext.success();
          break;
        case STOP:

          break;
        case READ:

          break;
      }
    } catch (Exception e) {

      return false;
    }
    return true;
  }
}
