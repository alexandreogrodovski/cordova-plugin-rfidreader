package itaipubinacional.cordova.plugin;

import org.json.JSONArray;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import com.rscja.deviceapi.RFIDWithUHF;

public class RFIDReaderPlugin extends CordovaPlugin {

  private RFIDWithUHF rfidReader;

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {
    //callbackContext.success("sucesso!");
    RFIDWithUHF rfidReader = RFIDWithUHF.getInstance();
    callbackContext.error("falhaaa!");
    return true;
  }
}
