#!/bin/bash
if [ "$#" -lt "1" ]; then
    echo "Usage:" $(basename $0) "<config_file>"
    echo ""
else
	nohup java -jar -noverify -Djava.security.egd=file:/dev/./urandom target/*.jar --spring.config.location=$1 > out.log 2>&1 &
	echo $! > app.pid    
fi