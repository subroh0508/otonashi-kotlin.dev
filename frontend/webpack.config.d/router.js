if (config.devServer) {
    config.devServer.historyApiFallback = true;
} else {
    config.devServer = { historyApiFallback: true };
}
