var exec = require('cordova/exec');

exports.initSDK = function(arg0, success, error) {
  exec(success, error, 'KiipChallenge', 'initSDK', [arg0]);
};

exports.showHackerNews = function(arg0, success, error) {
  exec(success, error, 'KiipChallenge', 'showHackerNews', [arg0]);
};
