var path = require('path');
config.module.rules.push({
    test: /\.(jpg|png)$/,
    loader: "url-loader"
});

// resourcesに置いたJSONをrequire(...json)で呼べるように
config.resolve.modules.unshift(path.resolve("../../../../frontend/build/processedResources/Js/main"));
