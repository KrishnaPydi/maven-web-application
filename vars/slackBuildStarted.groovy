def call(String projectName = "Airtel Dev", String channel = "#airtel-dev") {

    slackSend(
        channel: channel,
        color: 'warning',
        message: """🚀 ${projectName} Build STARTED

Job: ${env.JOB_NAME}
Build Number: #${env.BUILD_NUMBER}
Branch: ${env.BRANCH_NAME ?: 'development'}
Status: STARTED

Jenkins URL: ${env.BUILD_URL}"""
    )
}
