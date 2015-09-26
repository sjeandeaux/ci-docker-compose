up:
	docker-compose up -d
ps:
	docker-compose ps
rm:
	docker-compose rm
stop:
	docker-compose stop
rmi:
	docker images | grep "^cidocker" | awk '{print $$3}'| xargs docker rmi -f

data-rmi:
	docker rmi cidockercompose_data
data-exec:
	docker exec -ti cidockercompose_data_1 /bin/sh
