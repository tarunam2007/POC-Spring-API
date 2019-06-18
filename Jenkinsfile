#!groovy

def releasedVersion

node('master') {
  def dockerTool = tool name: 'docker', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
  withEnv(["DOCKER=${dockerTool}/bin"]) {
  
    

     
    stage('Build') {
             git url: 'https://github.com/VishnuKoti/POC-Spring-API.git'
              dir('src') {
	        def mvnHome = tool 'M3'
 	 	sh "${mvnHome}/bin/mvn clean install spring-boot:repackage"
		 dockerCmd 'build --tag upmt/spring:SNAPSHOT1.0 .'
            }
    }
 
    stage('Deploy') {
        stage('Deploy') {
            dir('src') {
                dockerCmd 'run -d -p 4000:4000 --name "snapshot" upmt/spring:SNAPSHOT1.0'
            }
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