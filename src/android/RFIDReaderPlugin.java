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

  private String action;
  private CallbackContext callbackContext;

  //private RFIDWithUHF rfidReader;

  private JSONArray result;
  private ReadTask readTask;
  private boolean stop = false;
  private int count;

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {
    this.callbackContext = callbackContext;
    try {
      this.init();
      switch (action) {
        case START:
          this.stop = false;
          //this.rfidReader.startInventoryTag(0, 0);
          this.readTask = new ReadTask();
          this.cordova.getThreadPool().execute(readTask);
          break;
        case READ:
          this.callbackContext.success(this.result);
          break;
        case STOP:
          this.stop = true;
          //this.rfidReader.stopInventory();
          break;
      }
    } catch (Exception e) {
      this.callbackContext.error(e.getMessage());
      return false;
    }
    return true;
  }

  private void init() throws Exception {
    if (this.action == null)
      throw new Exception("Action não informada");
    //this.rfidReader = RFIDWithUHF.getInstance();
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
          this.callbackContext.error(e.getMessage());
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
