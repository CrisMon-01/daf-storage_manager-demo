pipeline{
    agent any
    
     stages {
        stage('Build') {
         steps {
             script{
             if(***REMOVED***.BRANCH_NAME=='testci'){
                sh '''
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
                    // kubectl delete -f  ***REMOVED***-storage-manager-test.yml
                    sh '''
                    cd kubernetes
                    sh config-map-test.sh              
                    kubectl apply -f  ***REMOVED***-storage-manager-test.yml
                    '''
            }
            }
        }
     }
     }
}