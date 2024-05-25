pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // 소스코드 체크아웃
                checkout scm
            }
        }
        stage('Download Dependencies') {
            steps {
                // JUnit 5 콘솔 실행기 JAR 파일 다운로드
                sh 'mkdir -p lib'
                sh 'curl -o lib/junit-platform-console-standalone-1.10.0.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.0/junit-platform-console-standalone-1.10.0.jar'
            }
        }
        stage('Build') {
            steps {
                // Java 파일들을 컴파일하여 생성된 클래스 파일을 classes 디렉토리에 저장
                sh 'mkdir -p classes'
                sh 'javac -encoding UTF-8 -d classes src/book/*.java src/test/*.java'
            }
        }
        stage('Test') {
            steps {
                script {
                    // JUnit 5 콘솔 실행기 JAR 파일 경로
                    def junitJar = './lib/junit-platform-console-standalone-1.10.0.jar'
                    def classpath = "classes:${junitJar}"

                    // JUnit 5 테스트 실행
                    sh '''java -cp '${classpath}' org.junit.platform.console.ConsoleLauncher --scan-classpath --include-classname '^.*Test.*$' > test_results.txt'''
                }pipeline {
                     agent any
                     stages {
                         stage('Checkout') {
                             steps {
                                 // 소스코드 체크아웃
                                 checkout scm
                             }
                         }
                         stage('Download Dependencies') {
                             steps {
                                 // JUnit 5 콘솔 실행기 JAR 파일 다운로드
                                 sh 'mkdir -p lib'
                                 sh 'curl -o lib/junit-platform-console-standalone-1.10.0.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.0/junit-platform-console-standalone-1.10.0.jar'
                             }
                         }
                         stage('Build') {
                             steps {
                                 // Java 파일들을 컴파일하여 생성된 클래스 파일을 classes 디렉토리에 저장
                                 sh 'mkdir -p classes'
                                 sh 'javac -encoding UTF-8 -cp lib/junit-platform-console-standalone-1.10.0.jar -d classes src/book/*.java src/test/*.java'
                             }
                         }
                         stage('Test') {
                             steps {
                                 script {
                                     // JUnit 5 콘솔 실행기 JAR 파일 경로
                                     def junitJar = './lib/junit-platform-console-standalone-1.10.0.jar'
                                     def classpath = "classes:${junitJar}"

                                     // JUnit 5 테스트 실행
                                     sh """#!/bin/bash
                                          java -cp ${classpath} org.junit.platform.console.ConsoleLauncher --scan-classpath --include-classname '^.*Test.*$' > test_results.txt
                                     """
                                 }
                             }
                         }
                     }
                     post {
                         always {
                             // 테스트 결과 파일을 저장하기 위해 아카이브
                             archiveArtifacts 'test_results.txt'
                         }
                         failure {
                             echo 'Build or test failed'
                         }
                         success {
                             echo 'Build and test succeeded'
                         }
                     }
                 }

            }
        }
    }
    post {
        always {
            // 테스트 결과 파일을 저장하기 위해 아카이브
            archiveArtifacts 'test_results.txt'
        }
        failure {
            echo 'Build or test failed'
        }
        success {
            echo 'Build and test succeeded'
        }
    }
}
