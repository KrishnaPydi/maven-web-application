def call(String projectName = "Airtel Dev", String channel = "#airtel-dev") {

    slackSend(
        channel: channel,
        color: 'good',
        message: """✅ ${projectName} Build SUCCESS

Job: ${env.JOB_NAME}
Build Number: #${env.BUILD_NUMBER}
Branch: ${env.BRANCH_NAME ?: 'development'}
Status: SUCCESS

Jenkins URL: ${env.BUILD_URL}"""
    )
}
