pipeline {
    
    agent any
    
    stages {
        stage('Compile') {
           steps {
               sh 'mvn clean compile'
               
           }
        }
        stage('SonarQube Analysis') {
        	steps {
				withSonarQubeEnv('Sonar') {
		          sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.3.0.603:sonar ' + 
		          '-f all/pom.xml ' +
		          '-Dsonar.projectKey=com.huettermann:all:master ' +
		          '-Dsonar.login=$SONAR_UN ' +
		          '-Dsonar.password=$SONAR_PW ' +
		          '-Dsonar.language=java ' +
		          '-Dsonar.sources=. ' +
		          '-Dsonar.tests=. ' +
		          '-Dsonar.test.inclusions=**/*Test*/** ' +
		          '-Dsonar.exclusions=**/*Test*/**'
	          	}
	    	}
        }
        stage('Test') {
           steps {
               sh 'mvn test'
           }
        }
        stage('Install'){
            steps{
        		sh 'mvn install'        
            }
        }
    }
}