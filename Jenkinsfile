pipeline {
    agent any
    environment {
        LANG = 'ko_KR.UTF-8'
        LC_ALL = 'ko_KR.UTF-8'
        JAVA_TOOL_OPTIONS = '-Dfile.encoding=UTF-8'
    }
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

                    // JUnit 5 테스트 실행 및 결과를 UTF-8로 인코딩하여 저장
                    sh 'java -Dfile.encoding=UTF-8 -cp lib/junit-platform-console-standalone-1.10.0.jar:classes org.junit.platform.console.ConsoleLauncher --scan-classpath --include-classname \'^.*Test.*$\' | iconv -f UTF-8 -t UTF-8 > test_results.txt'
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
