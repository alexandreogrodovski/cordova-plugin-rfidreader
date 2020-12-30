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


// Código do David

RFIDReaderPlugin.prototype.start = function (successCallback, errorCallback) {

	if (errorCallback == null) {
        errorCallback = function () {
        };
    }

    if (typeof errorCallback != "function") {
        console.log("RFIDReaderPlugin.start: errorCallback não é uma função");
        return;
    }

    if (typeof successCallback != "function") {
        console.log("RFIDReaderPlugin.start: successCallback não é uma função");
        return;
    }

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

	if (errorCallback == null) {
        errorCallback = function () {
        };
    }

    if (typeof errorCallback != "function") {
        console.log("RFIDReaderPlugin.stop: errorCallback não é uma função");
        return;
    }

    if (typeof successCallback != "function") {
        console.log("RFIDReaderPlugin.stop: successCallback não é uma função");
        return;
    }

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

	if (errorCallback == null) {
        errorCallback = function () {
        };
    }

    if (typeof errorCallback != "function") {
        console.log("RFIDReaderPlugin.read: errorCallback não é uma função");
        return;
    }

    if (typeof successCallback != "function") {
        console.log("RFIDReaderPlugin.read: successCallback não é uma função");
        return;
    }

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
