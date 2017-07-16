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
				 sh './gradlew build --info'
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
				docker.image('mongo').withRun {c ->
					echo 'Integration tests here ...'
				}
			}
		}	
		
	}
}
