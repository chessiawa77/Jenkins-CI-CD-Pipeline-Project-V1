pipeline {
  agent any
  tools {
      maven 'localMaven'
      jdk 'localJDK'
  }
  stages {
      stage('Git checkout') {
          steps {
              git branch: 'main', url: 'https://github.com/cvamsikrishna11/Jenkins-CI-CD-Pipeline-Project-V1.git'
              sh 'java -version'
          }
      }
      stage('Build') {
          steps {
              sh "mvn clean package"
          }
          post {
              success {
                 archiveArtifacts artifacts: '**/*.war', followSymlinks: false
              }
          }
      }
  stage('Unit Test'){
      steps {
          sh 'mvn test'
      }
  }
  stage('Integration Test'){
      steps {
        sh 'mvn verify -DskipUnitTests'
      }
  }
  stage ('Checkstyle Code Analysis'){
      steps {
          sh 'mvn checkstyle:checkstyle'
      }
      post {
          success {
              echo 'Generated Analysis Result'
          }
      }
  }
  stage ('Sonarqube scan'){
      steps {
            sh '''
            mvn sonar:sonar \
            -Dsonar.projectKey=javawebapp \
            -Dsonar.host.url=http://xx.xx.xx.xx:9000 \
            -Dsonar.login=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
          '''
      }
  }
  }
}
white_check_mark
eyes
raised_hands







Levi Awa
7:06 PM
package com.example;
/**
* This is a class.
*/
public class Greeter {
/**
 * This is a constructor.
 */
public Greeter() {
}
/**
 * This is a method.
 */
public final String greet(final String someone) {
  String DB_PASSWORD = "Admin@12345";
  return String.format("Hello Levi, %s!", someone);
}
}
