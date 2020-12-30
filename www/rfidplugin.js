// Empty constructor
function RFIDReaderPlugin() {}

// The function that passes work along to native shells
// Message is a string, duration may be 'long' or 'short'
RFIDReaderPlugin.prototype.show = function(message, duration, successCallback, errorCallback) {
  var options = {};
  options.message = message;
  options.duration = duration;
  cordova.exec(successCallback, errorCallback, 'RFIDReaderPlugin', 'show', [options]);
}

// Installation constructor that binds RFIDReaderPlugin to window
RFIDReaderPlugin.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.rfidReaderPlugin = new RFIDReaderPlugin();
  return window.plugins.rfidReaderPlugin;
};
cordova.addConstructor(RFIDReaderPlugin.install);
