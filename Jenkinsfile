pipeline {
    agent any
    
    environment {
        LT_USERNAME = 'devanshsingh'  // Set your LambdaTest username here
        LT_ACCESS_KEY = 'LT_kjmzzJCYu70kReE7lwE0w2MOXLWg2q72EMh68BOot6fYI1c'  // Set your LambdaTest access key here
    }

    stages {
        stage('Setup LambdaTest Tunnel') {
            steps {
                script {
                    // Start LambdaTest Tunnel
                    sh """
                        lt-tunnel --user ${LT_USERNAME} --access-key ${LT_ACCESS_KEY} &
                    """
                }
            }
        }
        
        stage('Run Tests') {
            steps {
                script {
                    // Run your tests using Maven (or any other tool you are using)
                    // Ensure your tests are in the correct path in your project
                    sh "mvn clean test"
                }
            }
        }
        
        stage('Stop LambdaTest Tunnel') {
            steps {
                script {
                    // Stop the LambdaTest Tunnel once the tests are done
                    sh "pkill lt-tunnel || true"
                }
            }
        }
    }
    
    post {
        always {
            // Clean up any other resources if needed
            cleanWs()
        }
    }
}
