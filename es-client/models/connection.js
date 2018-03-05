const elasticsearch = require('elasticsearch');

function initializeClient() {
  if(process.env.ES_USER !== undefined) {
    return new elasticsearch.Client( {
      host: [
        {
          host: process.env.ES_HOST,
          auth: process.env.ES_USER + ':' + process.env.ES_PASS
        }
      ]
    });
  } else {
    return new elasticsearch.Client( {
      host: [
        {
          host: process.env.ES_HOST
        }
      ]
    });
  }
}

const client = initializeClient();

module.exports = client;
