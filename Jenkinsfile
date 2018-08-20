pipeline{
    agent any
    
     stages {
        stage('Build') {
         steps {
             script{
             if(***REMOVED***.BRANCH_NAME=='testci'){
                slackSend (message: "BUILD START: Job '${***REMOVED***.JOB_NAME} [${***REMOVED***.BUILD_NUMBER}]' (${***REMOVED***.BUILD_URL})")
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
                    slackSend (color: '#00FF00', message: "SUCCESSFUL: Job '${***REMOVED***.JOB_NAME} [${***REMOVED***.BUILD_NUMBER}]' (${***REMOVED***.BUILD_URL})")
            }
            }
        }
     }     
     }
}