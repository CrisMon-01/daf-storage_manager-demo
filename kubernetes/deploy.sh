#!/usr/bin/***REMOVED*** bash

set -e

# cd ../../bin
# . ./setVersions.sh
# cd -

export STORAGE_MANAGER_VERSION=1.0.0-SNAPSHOT

# test for template
***REMOVED***subst < ***REMOVED***_storage_manager.yml > output.yml

kubectl delete -f output.yml

kubectl create -f output.yml

rm output.yml
