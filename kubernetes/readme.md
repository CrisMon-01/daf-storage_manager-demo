# deployment for kubernetes

Depending if the ***REMOVED***ironment for the deployment is test or prod replace xxx with test|prod.
In order to perform the deployment do the following

## add the secret for the `ssl_keystore_pwd`

Since I wasn't able to found where the secrets for test are stored the workaround is to:
0. load kubernetes variable for the current ***REMOVED***
1. get the actual secrets `kubectl get secrets ***REMOVED***-secret --output yaml > secrets-xxx.yml`
2. add the new secret value in the file `secret-xxx.yml` encoded as base64 (`echo -n superpassword | base64`)
3. update the secret `kubectl apply -f secrets-xxx.yml`


## deploy to test

`kubectl apply -f ***REMOVED***_storage_manager_xxx.yml` where `xxx` is the ***REMOVED***ironment
