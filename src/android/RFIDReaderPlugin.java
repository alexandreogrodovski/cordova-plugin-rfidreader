package itaipubinacional.cordova.plugin;

import java.lang.Exception;
import org.json.JSONArray;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import com.rscja.deviceapi.RFIDWithUHF;

public class RFIDReaderPlugin extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {
    RFIDWithUHF rfidReader = RFIDWithUHF.getInstance();
    try {
      if (rfidReader == null)
        throw new Exception("ConfigurationException");
      //retorno = rfidReader.startInventoryTag(0, 0);
    } catch (Exception exception) {
      callbackContext.error(exception.getMessage());
    }
    callbackContext.success("sucesso!");
    return true;
  }
}
