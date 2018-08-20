pipeline{
    agent any
    
     stages {
        stage('Build') {
         steps {
             script{
             if(***REMOVED***.BRANCH_NAME=='testci'){
                slackSend "Build Started - ${***REMOVED***.JOB_NAME} ${***REMOVED***.BUILD_NUMBER}"
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
                    slackSend "Build Finished - ${***REMOVED***.JOB_NAME} ${***REMOVED***.BUILD_NUMBER} check the result on: ***REMOVED***://***REMOVED******REMOVED***.***REMOVED***.it "
            }
            }
        }
     }
     }
}