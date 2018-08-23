#!/usr/bin/***REMOVED*** bash
kubectl --kubeconfig=../../../.kube/config.***REMOVED***-***REMOVED*** delete configmap storage-manager-conf
kubectl --kubeconfig=../../../.kube/config.***REMOVED***-***REMOVED*** create configmap storage-manager-conf --from-file=../conf/test/***REMOVED***.conf
