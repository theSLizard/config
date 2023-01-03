## Update package indices
sudo apt-get update -y

## Install Erlang packages
sudo apt-get install -y erlang-base \
                        erlang-asn1 erlang-crypto erlang-eldap erlang-ftp erlang-inets \
                        erlang-mnesia erlang-os-mon erlang-parsetools erlang-public-key \
                        erlang-runtime-tools erlang-snmp erlang-ssl \
                        erlang-syntax-tools erlang-tftp erlang-tools erlang-xmerl

## Install rabbitmq-server and its dependencies
sudo apt-get install rabbitmq-server -y --fix-missing

## To start Rabbit-MQ
systemctl start rabbitmq-server

## Config refresh example (from any module - then propagated via Spring Cloud Bus & Rabbit MQ)
curl -XPOST http://192.168.64.8:42311/actuator/refresh

## Also note that Cloud Config currently points to the master branch of the config repo (SpaceFourConfigRepos)