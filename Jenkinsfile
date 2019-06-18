#!groovy

def releasedVersion

node('master') {
  def dockerTool = tool name: 'docker', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
  withEnv(["DOCKER=${dockerTool}/bin"]) {
  
    

     
    stage('Build') {
             git url: 'https://github.com/VishnuKoti/blog-002.git'
              dir('app') {
	        def mvnHome = tool 'M3'
 	 	sh "${mvnHome}/bin/mvn clean package"
                dockerCmd 'build --tag automate/sparktodo:SNAPSHOT1.0 .'
            }
    }
 
    stage('Deploy') {
        stage('Deploy') {
            dir('app') {
                dockerCmd 'run -d -p 9999:9999 --name "snapshot" automate/sparktodo:SNAPSHOT1.0'
            }
        }
    }

    stage('Tests') {
           try {
            dir('tests/rest-assured') {
             sh './gradlew clean test'
            }
           } finally {
            junit testResults: 'tests/rest-assured/build/*.xml', allowEmptyResults: true
            archiveArtifacts 'tests/rest-assured/build/**'
           }  
      }   
  }
}

def dockerCmd(args) {
    sh "${DOCKER}/docker ${args}"
}

def getReleasedVersion() {
    return (readFile('pom.xml') =~ '<version>(.+)-SNAPSHOT</version>')[0][1]
}