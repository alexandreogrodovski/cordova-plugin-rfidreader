package itaipubinacional.cordova.plugin;
// The native Toast API
import android.widget.Toast;
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
						callbackContext.success(this.result);
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
