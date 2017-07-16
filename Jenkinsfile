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
				 sh './gradlew test --info'
				 junit '**/test-results/test/*.xml'
			}
		}	
		
	}
}
