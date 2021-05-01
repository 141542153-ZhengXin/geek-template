#!/bin/bash

echo restart geek-template
source ./catalina.sh stop
source ./catalina.sh start
exit