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

		docker.image('mongo').withRun { mongo ->
			stage('Integration test') {
				steps {
					echo 'Integration tests here ...'
				}
			}	
		}
				
	}
}
