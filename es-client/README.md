# Elasticsearch client application

This application connects to an existing Elasticsearch instance and populates some default data
about books.

The following environment variables can be configured to connect to Elasticsearch:

* **ES_URL**: Elasticsearch url. E.g. *http://elasticsearch:9200* (required)
* **ES_USER**: If a secured connection is to be used (optional)
* **ES_PASS**: The password to use to authenticate to Elasticsearch (optional).

If the user and password is set, *https* will be used.

## Usage

```
$ oc new-app nodejs:6~https://github.com/ruromero/quickstarts --context-dir=es-client --name es-client
--> Found image edd4e72 (3 days old) in image stream "openshift/nodejs" under tag "6" for "nodejs:6"

    Node.js 6
    ---------
    Node.js 6 available as docker container is a base platform for building and running various Node.js 6 applications and frameworks. Node.js is a platform built on Chrome's JavaScript runtime for easily building fast, scalable network applications. Node.js uses an event-driven, non-blocking I/O model that makes it lightweight and efficient, perfect for data-intensive real-time applications that run across distributed devices.

    Tags: builder, nodejs, nodejs6

    * A source build using source code from https://github.com/ruromero/quickstarts will be created
      * The resulting image will be pushed to image stream "es-client:latest"
      * Use 'start-build' to trigger a new build
    * This image will be deployed in deployment config "es-client"
    * Port 8080/tcp will be load balanced by service "es-client"
      * Other containers can access this service through the hostname "es-client"

--> Creating resources ...
    imagestream "es-client" created
    buildconfig "es-client" created
    deploymentconfig "es-client" created
    service "es-client" created
--> Success
    Build scheduled, use 'oc logs -f bc/es-client' to track its progress.
    Application is not exposed. You can expose services to the outside world by executing one or more of the commands below:
     'oc expose svc/es-client'
    Run 'oc status' to view your app.
```
