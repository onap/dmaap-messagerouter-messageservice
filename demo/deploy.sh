#!/bin/bash

set -e

export NEXUS_DOCKER_REPO=$(cat /opt/config/nexus_docker_repo.txt)

# do not change this, it is already matched with the git repo file structure
DOCKER_FILE_DIR='./docker_files'

# commands to run docker and docker-compose
DOCKER_COMPOSE_EXE='/opt/docker/docker-compose'

cd "${DOCKER_FILE_DIR}"

while ! ifconfig |grep "docker0" > /dev/null; 
   do sleep 1
   echo 'waiting for docker operational'
done

echo "prep any files with local configurations"
if ls __* 1> /dev/null 2>&1; then
   IP_DOCKER0=$(ifconfig docker0 |grep "inet addr" | cut -d: -f2 |cut -d" " -f1)
   TEMPLATES=$(ls -1 __*)
   for TEMPLATE in $TEMPLATES
   do
      FILENAME=${TEMPLATE//_}
      if [ ! -z "${IP_DOCKER0}" ]; then
         sed -e "s/{{ ip.docker0 }}/${IP_DOCKER0}/" "$TEMPLATE" > "$FILENAME"
      fi
   done
fi

if [ -z "$MTU" ]; then
  export MTU=$(ifconfig docker0 |grep MTU |sed -e 's/.*MTU://' -e 's/\s.*$//')
fi
 
echo "starting docker operations"
${DOCKER_COMPOSE_EXE} up -d --build
