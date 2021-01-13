package itaipubinacional.cordova.plugin;

import org.json.JSONArray;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import com.rscja.deviceapi.RFIDWithUHF;
import com.rscja.deviceapi.exception.ConfigurationException;

public class RFIDReaderPlugin extends CordovaPlugin {

  private RFIDWithUHF rfidReader;

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {
    try {
      RFIDWithUHF rfidReader = RFIDWithUHF.getInstance();
      rfidReader.startInventoryTag(0, 0);
    } catch (ConfigurationException exception) {
      callbackContext.error(exception.getMessage());
    }
    callbackContext.success("sucesso!");
    return true;
  }
}
