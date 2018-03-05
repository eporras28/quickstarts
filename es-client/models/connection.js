const elasticsearch = require('elasticsearch');

const URL_REGEX = /(https?):\/\/(a-zA-Z0-0\-)+:(0-9)+/

function initializeClient() {
  const parsedUrl = URL_REGEX.exec(process.env.ES_URL);
  const protocol = parsedUrl[1];
  const svc = parsedUrl[2];
  const port = parsedUrl[3];

  if(process.env.ES_USER !== undefined) {
    return new elasticsearch.Client( {
      host: [
        {
          host: svc,
          auth: process.env.ES_USER + ':' + process.env.ES_PASS,
          protocol: protocol,
          port: port
        }
      ]
    });
  } else {
    return new elasticsearch.Client( {
      host: [
        {
          host: svc,
          protocol: protocol,
          port: port
        }
      ]
    });
  }
}

const client = initializeClient();

module.exports = client;
