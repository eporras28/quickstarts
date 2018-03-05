const elasticsearch = require('elasticsearch');

function initializeClient() {
  if(process.env.ES_USER !== undefined) {
    return new elasticsearch.Client( {
      host: [
        {
          host: process.env.ES_SVC,
          auth: process.env.ES_USER + ':' + process.env.ES_PASS,
          protocol: 'https',
          port: 9200
        }
      ]
    });
  } else {
    return new elasticsearch.Client( {
      host: [
        {
          host: process.env.ES_SVC,
          protocol: 'http',
          port: 9200
        }
      ]
    });
  }
}

const client = initializeClient();

module.exports = client;
