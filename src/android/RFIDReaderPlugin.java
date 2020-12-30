package itaipubinacional.cordova.plugin;

// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RFIDReaderPlugin extends CordovaPlugin {
private static final String DURATION_LONG = "long";

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {

    return true;
  }

  protected class ReadTask implements Runnable {

    @Override
    public void run() {
      result = new JSONArray();
      while (!stop) {
        try {
          result.put(this.read());
          Thread.sleep(1000);
        } catch (Exception e) {
          callbackContext.error(e.getMessage());
        }
      }
    }

    private JSONObject read () throws JSONException {
      //String[] result = rfidReader.readTagFromBuffer();
      JSONObject jsonResult = null;
      if (result != null) {
        jsonResult = new JSONObject();
        count ++;
        jsonResult.put("tagId", count);
        //jsonResult.put("tagId", result[0]);
      }
      return jsonResult;
    }
  }
}
