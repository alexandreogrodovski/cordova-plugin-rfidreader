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

RFIDReaderPlugin.prototype.start = function (successCallback, errorCallback) {
  var options = {};
  exec(
    function(result) {
      successCallback(result);
    },
    function(error) {
      errorCallback(error);
    },
    'RFIDReaderPlugin',
    'start',
    [options]
  );
}

RFIDReaderPlugin.prototype.stop = function (successCallback, errorCallback) {
  var options = {};
  exec(
    function(result) {
      successCallback(result);
    },
    function(error) {
      errorCallback(error);
    },
    'RFIDReaderPlugin',
    'stop',
    [options]
  );
}

RFIDReaderPlugin.prototype.read = function (successCallback, errorCallback) {
  var options = {};
  exec(
    function(result) {
      successCallback(result);
    },
    function(error) {
      errorCallback(error);
    },
    'RFIDReaderPlugin',
    'read',
    [options]
  );
}

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
