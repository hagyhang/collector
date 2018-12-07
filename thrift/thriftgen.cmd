#!/bin/sh

THRIFT_EXE=xrpcgen-0.9.0
THRIFT_VER=9
PROJECT_NAME=zastatscollector-thrift
PROJECT_DIR=zastatscollector-thrift
VERSION=1.0.0.0

#Java
rm -f zastatscollector-thrift/gen-java/*/*/*/*/*/*
#
$THRIFT_EXE --gen java -o $PROJECT_DIR zastatscollector.thrift

cp -rf $PROJECT_DIR/gen-java/** $PROJECT_DIR/src/
rm -rf $PROJECT_DIR/gen-java

#-------------------------------------------------------------------------------
#Java build & deploy
s
#common variables
ZSERVER_DIR=/zserver
JAVA_LIB_DIR=$ZSERVER_DIR/java/lib
DEPLOY_DIR=$JAVA_LIB_DIR/zap
DEPLOY_JAR="$PROJECT_NAME""$THRIFT_VER"-"$VERSION".jar

#build
ant -f $PROJECT_DIR/build.xml clean
ant -f $PROJECT_DIR/build.xml -Djavac.debug=false -Djar.compress=true -Ddist.jar=dist/$DEPLOY_JAR jar

#deploy to zserver dir
mkdir -p $DEPLOY_DIR
cp -f $PROJECT_DIR/dist/$DEPLOY_JAR $DEPLOY_DIR

#clean
ant -f $PROJECT_DIR/build.xml clean

