def call(String projectName = "Airtel Dev", String channel = "#airtel-dev") {

    slackSend(
        channel: channel,
        color: 'danger',
        message: """❌ ${projectName} Build FAILED

Job: ${env.JOB_NAME}
Build Number: #${env.BUILD_NUMBER}
Branch: ${env.BRANCH_NAME ?: 'development'}
Status: FAILURE

Please check Jenkins Console Output.

Jenkins URL: ${env.BUILD_URL}"""
    )
}
