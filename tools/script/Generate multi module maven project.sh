#!/bin/zsh

# Developer Information
DEVELOPER_NAME="Paul Marcelin Bejan"
DEVELOPER_EMAIL="paulmarcelinbejan.developer@gmail.com"
DEVELOPER_ORGANIZATION="Paul Marcelin Bejan"
DEVELOPER_ORGANIZATION_URL="https://github.com/paulmarcelinbejan"

# Project Information
PROJECT_URL="https://github.com/paulmarcelinbejan/Minerva"
PROJECT_NAME="minerva"
PROJECT_DESCRIPTION="Minerva Architecture - Event Driven Architecture"

GROUP_ID="io.github.paulmarcelinbejan"
ARTIFACT_ID="minerva"

# Maven Modules
MAVEN_MODULES=(
    "minerva-config-provider"
    "minerva-orchestrator"
    "minerva-processing-scheduler"
    "minerva-manager-loaders"
    "minerva-manager-engines"
    "minerva-manager-exporters"
    "minerva-loader"
    "minerva-engine"
    "minerva-exporter"
    "minerva-cleaner"
    "minerva-dlq"
    "minerva-batch-reader"
    "minerva-batch-reader-csv"
    "minerva-batch-reader-mongodb"
    "minerva-batch-writer"
    "minerva-batch-writer-csv"
    "minerva-batch-writer-mongodb"
)

# Base Directory
SCRIPT_DIRECTORY=$(pwd)

# Create Parent pom.xml
echo "Creating parent pom.xml..."

cat >"$SCRIPT_DIRECTORY/pom.xml" <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <developers>
        <developer>
            <name>${DEVELOPER_NAME}</name>
            <email>${DEVELOPER_EMAIL}</email>
            <organization>${DEVELOPER_ORGANIZATION}</organization>
            <organizationUrl>${DEVELOPER_ORGANIZATION_URL}</organizationUrl>
        </developer>
    </developers>

    <url>${PROJECT_URL}</url>
    <name>${PROJECT_NAME}</name>
    <description>${PROJECT_DESCRIPTION}</description>

    <groupId>${GROUP_ID}</groupId>
    <artifactId>${ARTIFACT_ID}</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>pom</packaging>

    <modules>
$(for module in ${MAVEN_MODULES[@]}; do echo "        <module>${module}</module>"; done)
    </modules>

    <properties>
        <!-- JAVA -->
        <java.version>21</java.version>
        <!-- MAVEN -->
        <maven-compiler-plugin.version>3.8.1</maven-compiler-plugin.version>
        <maven-javadoc-plugin.version>3.6.3</maven-javadoc-plugin.version>
        <maven-surefire-plugin.version>3.2.5</maven-surefire-plugin.version>
        <!-- SPRING -->
        <springframework.version>6.1.4</springframework.version>
        <spring-boot.version>3.2.3</spring-boot.version>
        <spring-cloud.version>2023.0.3</spring-cloud.version>
        <!-- LOMBOK -->
        <lombok.version>1.18.32</lombok.version>
        <!-- MAPSTRUCT -->
        <mapstruct.version>1.6.0.Beta1</mapstruct.version>
        <lombok-mapstruct-binding.version>0.2.0</lombok-mapstruct-binding.version>
        <!-- TOOLBOX -->
        <paulmarcelinbejan-toolbox.version>1.0.3-SNAPSHOT</paulmarcelinbejan-toolbox.version>
    </properties>

    <dependencyManagement>
        <dependencies>

            <!-- Spring dependencies -->
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-framework-bom</artifactId>
                <version>\${springframework.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>\${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>\${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <!-- ToolBox dependencies -->
            <dependency>
                <groupId>io.github.paulmarcelinbejan.toolbox</groupId>
                <artifactId>toolbox</artifactId>
                <version>\${paulmarcelinbejan-toolbox.version}</version>
                <scope>import</scope>
                <type>pom</type>
            </dependency>

            <!-- ${ARTIFACT_ID} dependencies -->
$(for module in ${MAVEN_MODULES[@]}; do echo "            <dependency>\n                <groupId>${GROUP_ID}</groupId>\n                <artifactId>${module}</artifactId>\n                <version>\${project.version}</version>\n            </dependency>"; done)
        
        </dependencies>
    </dependencyManagement>

    <dependencies>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>\${maven-compiler-plugin.version}</version>
                <configuration>
                    <source>\${java.version}</source>
                    <target>\${java.version}</target>
                    <encoding>\${project.build.sourceEncoding}</encoding>
                    <annotationProcessorPaths>
                        <path>
                            <groupId>org.mapstruct</groupId>
                            <artifactId>mapstruct-processor</artifactId>
                            <version>\${mapstruct.version}</version>
                        </path>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                            <version>\${lombok.version}</version>
                        </path>
                        <dependency>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok-mapstruct-binding</artifactId>
                            <version>\${lombok-mapstruct-binding.version}</version>
                        </dependency>
                    </annotationProcessorPaths>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-javadoc-plugin</artifactId>
                <version>\${maven-javadoc-plugin.version}</version>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>\${maven-surefire-plugin.version}</version>
            </plugin>
        </plugins>
    </build>
</project>
EOF

echo "Creating gitignore..."
cat >"${SCRIPT_DIRECTORY}/.gitignore" <<EOF
##############################
# Java
##############################
.mtj.tmp/
*.class
*.jar
*.war
*.ear
*.nar
hs_err_pid*
replay_pid*

##############################
# Maven
##############################
target/
pom.xml.tag
pom.xml.releaseBackup
pom.xml.versionsBackup
pom.xml.next
pom.xml.bak
release.properties
dependency-reduced-pom.xml
buildNumber.properties
.mvn/timing.properties
.mvn/wrapper/maven-wrapper.jar

##############################
# Gradle
##############################
bin/
build/
.gradle
.gradletasknamecache
gradle-app.setting
!gradle-wrapper.jar

##############################
# IntelliJ
##############################
out/
.idea/
.idea_modules/
*.iml
*.ipr
*.iws

##############################
# Eclipse
##############################
.settings/
bin/
tmp/
.metadata
.classpath
.project
*.tmp
*.bak
*.swp
*~.nib
local.properties
.loadpath
.factorypath

##############################
# NetBeans
##############################
nbproject/private/
build/
nbbuild/
dist/
nbdist/
nbactions.xml
nb-configuration.xml

##############################
# Visual Studio Code
##############################
.vscode/
.code-workspace

##############################
# OS X
##############################
.DS_Store

##############################
# ${ARTIFACT_ID}
##############################



EOF

echo "Creating lombok config..."
cat >"${SCRIPT_DIRECTORY}/lombok.config" <<EOF
# Copy the Qualifier annotation from the instance variables to the constructor
# see https://github.com/rzwitserloot/lombok/issues/745
lombok.copyableAnnotations += org.springframework.beans.factory.annotation.Qualifier
lombok.copyableAnnotations += org.springframework.beans.factory.annotation.Value
EOF

# Create Module Directories and pom.xml Files
for module in ${MAVEN_MODULES[@]}; do
    MODULE_DIR="$SCRIPT_DIRECTORY/$module"
    echo "Creating module: $module..."

    # Create base path
    BASE_PATH="$MODULE_DIR/src/main/java/$(echo $GROUP_ID | tr '.' '/')"
    TEST_PATH="$MODULE_DIR/src/test/java/$(echo $GROUP_ID | tr '.' '/')"

    # Divide module into multiple folders
    MODULE_PATH=$(echo "$module" | tr '-' '/')

    # Create the directories
    mkdir -p "$BASE_PATH/$MODULE_PATH"
    mkdir -p "$TEST_PATH/$MODULE_PATH"

    cat >"$MODULE_DIR/pom.xml" <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>${GROUP_ID}</groupId>
        <artifactId>${ARTIFACT_ID}</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <relativePath>../</relativePath>
    </parent>

    <artifactId>${module}</artifactId>

    <dependencies>

    </dependencies>

</project>
EOF
done

echo "Multi-module Maven project structure created successfully."
