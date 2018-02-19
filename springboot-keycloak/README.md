# Springboot Keycloak demo application

This simple application allows users to quickly deploy a Springboot-based application with keycloak single sign-on
integrated.

**Deploy the application**
```
$ oc new-app https://raw.githubusercontent.com/ruromero/quickstarts/master/springboot-keycloak/springboot-keycloak-template.yml
--> Deploying template "myproject/springboot-keycloak-template" for "springboot-keycloak-template.yaml" to project myproject

     * With parameters:
        * APPLICATION_NAME=springboot

--> Creating resources ...
    imagestream "s2i-java" created
    imagestream "springboot" created
    service "springboot" created
    route "springboot" created
    deploymentconfig "springboot" created
    buildconfig "springboot" created
--> Success
    Access your application via route 'springboot-myproject.172.17.0.1.nip.io'
    Build scheduled, use 'oc logs -f bc/springboot' to track its progress.
    Run 'oc status' to view your app.
```

Two paths are exposed:

- `/`: Public page accessible by anyone
- `/private`: Private page accessible by any authenticated user. Prompts the user name
