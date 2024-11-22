module.exports = {
  project: {
    ios: {},
    android: {
      sourceDir: './android',
      packageName: 'com.lulu.enterprises', // Ensure this matches your AndroidManifest.xml
    },
  },
  dependencies: {}, // Include manually linked dependencies if necessary
  assets: ['./assets/fonts/'], // Optional: Add paths to assets if needed
};
