package itaipubinacional.cordova.plugin;

import java.lang.Exception;
import org.json.JSONArray;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import com.rscja.deviceapi.RFIDWithUHF;
import com.rscja.deviceapi.exception.ConfigurationException;

public class RFIDReaderPlugin extends CordovaPlugin {

  //private RFIDWithUHF rfidReader;

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {

    try {
      //RFIDWithUHF rfidReader = RFIDWithUHF.getInstance();
      //retorno = rfidReader.startInventoryTag(0, 0);
      throw new Exception("Mensagem de erro");
    } catch (Exception exception) {
      callbackContext.error(exception.getMessage());
    }
    callbackContext.success("sucesso!");
    return true;
  }
}
