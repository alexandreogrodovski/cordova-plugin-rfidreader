package itaipubinacional.cordova.plugin;

import java.lang.Exception;
import org.json.JSONArray;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import com.rscja.deviceapi.RFIDWithUHF;

public class RFIDReaderPlugin extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {
    try {
      RFIDWithUHF rfidReader = RFIDWithUHF.getInstance();
      if (rfidReader == null)
        throw new Exception("ConfigurationException");
      //rfidReader.startInventoryTag(0,0);
      //rfidReader.startInventoryTag((byte) 0, (byte) 0)
      //rfidReader.stopInventory();
      //rfidReader.readTagFromBuffer();
      //rfidReader.inventorySingleTag();
      //rfidReader.free();
      rfidReader.init();
    } catch (Exception exception) {
      callbackContext.error(exception.getMessage());
    }
    callbackContext.success("sucesso!");
    return true;
  }
}
