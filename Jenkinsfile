pipeline{
    agent any
    stages{
       stage('Web-BDD-Tasks'){
            steps{
                dir('web-bdd-tasks') {
                     git credentialsId: 'Login_git2', url: 'https://github.com/iameduardoneill/Web-BDD-Tasks'
                     bat 'mvn test'
                    }
                }
        }
    }

    post{
        always{
             junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'  
        }

       unsuccessful{
             emailext attachLog: true, body: 'See the attached log bellow', subject: 'Build $BUILD NUMBER has failed', to: 'edu.hitman01.eh+jenkins@gmail.com'
       }

        fixed{
             junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml, api-test/target/surefire-reports/*.xml, funcional-test/target/surefire-reports/*.xml, funcional-test/target/failsafe-reports/*.xml'  
             emailext attachLog: true, body: 'See the attached log bellow', subject: 'Build is fine!!', to: 'edu.hitman01.eh+jenkins@gmail.com'
        }
    }

}