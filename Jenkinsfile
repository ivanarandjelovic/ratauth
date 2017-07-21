pipeline {
	agent any
	
	stages {
	
//		stage('Checkout') {
//			steps {
//				checkout scm
//			}
//		}
	
		stage('Build') {
			steps {
				 sh './gradlew clean build --info'
			}
		}
	
		stage('Test') {
			steps {
				 sh './gradlew cleanTest test --info'
				 junit '**/test-results/test/*.xml'
				 jacoco()
			}
		}	

		stage('Integration test') {
			steps {
				script {
					docker.image('mongo').withRun { mongo ->
						echo 'Integration tests running ...'
						sh './gradlew cleanIntegrationTest integrationTest --info'
				 		junit '**/test-results/integrationTest/*.xml'
					}
				}
			}	
		}
				
	}
}
