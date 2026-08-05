node {
    def mavenHome = tool name: "maven-3.9.15"

    // Build Started Notification
    slackSend(
        channel: '#airtel-dev',
        color: '#FFFF00',
        message: "🚀 BUILD STARTED: ${env.JOB_NAME} #${env.BUILD_NUMBER}\n${env.BUILD_URL}"
    )

    try {

        stage('GIT CHECKOUT') 
        {
            git branch: 'development',
                credentialsId: '9de63073-05c4-4f89-ab88-a3a681b846ef',
                url: 'https://github.com/KrishnaPydi/maven-web-application.git'
        }

        stage('BUILD') 
        {
            sh "${mavenHome}/bin/mvn clean package"
        }

        stage('SQ Report') 
        {
            sh "${mavenHome}/bin/mvn clean sonar:sonar"
        }

        stage('Nexus')
        {
            sh "${mavenHome}/bin/mvn clean deploy"
        }

        stage('Tomcat')
        {
            deploy adapters: [
                tomcat9(
                    alternativeDeploymentContext: '',
                    credentialsId: 'bf6a717d-ba77-47dc-938c-0c54bdd00661',
                    path: '',
                    url: 'http://98.94.53.27:8080/'
                )
            ],
            contextPath: null,
            war: '**/maven-web-application.war'
        }

        // Build Success Notification
        slackSend(
            channel: '#airtel-dev',
            color: 'good',
            message: "✅ BUILD SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}\n${env.BUILD_URL}"
        )

    } catch (Exception e) {

        // Build Failure Notification
        slackSend(
            channel: '#airtel-dev',
            color: 'danger',
            message: "❌ BUILD FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}\n${env.BUILD_URL}"
        )

        throw e
    }
}
