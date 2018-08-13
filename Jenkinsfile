pipeline{
    agent any
    
     stages {
        stage('Build') {
         steps {
             script{
             if(***REMOVED***.BRANCH_NAME=='testci'){
                sh '''
                rm -rf ***REMOVED***;
                git clone ***REMOVED***://github.com/italia/***REMOVED***.git;
                cd ***REMOVED***;
                sbt -DSTAGING=true clean compile; sbt publishLocal;
                cd ..; rm -rf ***REMOVED***;
                sbt " -DSTAGING=true clean compile; docker:publish"                
                '''
                }
            }
         }
        }
        stage('Staging'){
            steps{
            script{
                if(***REMOVED***.BRANCH_NAME=='testci'){
                    sh '''
                    cd kubernetes
                    sh config-map-test.sh
                    kubectl delete -f  ***REMOVED***-storage-manager-test.yaml
                    kubectl create -f  ***REMOVED***-storage-manager-test.yaml
                    '''
            }
            }
        }
     }
     }
}