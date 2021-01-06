package itaipubinacional.cordova.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Random;
import java.util.Date;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class RFIDReaderPlugin extends CordovaPlugin {

  private static final String START = "start";
  private static final String STOP = "stop";
  private static final String READ = "read";

  private CallbackContext callbackContext;
  private JSONArray jsonArray = new JSONArray();
  private boolean execute;

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {
    this.callbackContext = callbackContext;
    try {
      switch (action) {
        case START:
          execute = true;
          cordova
            .getThreadPool()
            .execute(new ReadTask());
          callbackContext.success();
          break;
        case STOP:
          execute = false;
          callbackContext.success();
          break;
        case READ:
          callbackContext.success(jsonArray.toString());
          break;
      }
    } catch (Exception e) {
      callbackContext.error(e.getMessage());
      return false;
    }
    return true;
  }

  protected class ReadTask implements Runnable {

    @Override
    public void run () {
      try {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        dateFormat.setTimeZone(timeZone);
        while (execute) {
          JSONObject jsonObject = new JSONObject();
          jsonObject.put("tagId", new Random().nextInt(1000000));
          jsonObject.put("readDateTime", dateFormat.format(new Date()));
          jsonArray.put(jsonObject);
          Thread.sleep(1000);
        }
      } catch (Exception e) {
        callbackContext.error(e.getMessage());
      }
    }
  }
}
