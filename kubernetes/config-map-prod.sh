#!/usr/bin/***REMOVED*** bash
kubectl delete configmap storage-manager-conf
kubectl create configmap storage-manager-conf --from-file=../conf/prod/***REMOVED***.conf
