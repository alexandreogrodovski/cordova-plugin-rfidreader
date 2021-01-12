function RFIDReaderPlugin() {}

RFIDReaderPlugin.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.rfidReaderPlugin = new RFIDReaderPlugin();
  return window.plugins.rfidReaderPlugin;
};

cordova.addConstructor(RFIDReaderPlugin.install);

var exec = require('cordova/exec');

RFIDReaderPlugin.prototype.test = function (successCallback, errorCallback) {
  var options = {};
  exec(
    function(result) {
      successCallback(result);
    },
    function(error) {
      errorCallback(error);
    },
    'RFIDReaderPlugin',
    'test',
    [options]
  );
}
