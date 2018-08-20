def notifySlack(String buildStatus = 'STARTED') {
    // Build status of null means success.
    buildStatus = buildStatus ?: 'SUCCESS'

    def color

    if (buildStatus == 'SUCCESS') {
        color = '#BDFFC3'
    } else {
        color = '#FF9FA1'
    }

    def msg = "${buildStatus}: `${***REMOVED***.JOB_NAME}` #${***REMOVED***.BUILD_NUMBER}:\n${***REMOVED***.BUILD_URL}"

    slackSend(color: color, message: msg)
}

pipeline{
    agent any
    //slackSend (message: "BUILD START: Job '${***REMOVED***.JOB_NAME} [${***REMOVED***.BUILD_NUMBER}]' (${***REMOVED***.BUILD_URL})")
     stages {
        try{
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
                   // slackSend (color: '#00FF00', message: "SUCCESSFUL: Job '${***REMOVED***.JOB_NAME} [${***REMOVED***.BUILD_NUMBER}]' (${***REMOVED***.BUILD_URL})")
            }
            }
        }
     }     
     }
    }
    catch (e) {
        currentBuild.result = 'FAILURE'
        throw e
    } finally {
        notifySlack(currentBuild.result)
    }
}