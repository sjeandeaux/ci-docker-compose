up:
	docker-compose up -d
ps:
	docker-compose ps
rm:
	docker-compose rm
stop:
	docker-compose stop

data-rmi:
	docker rmi cidockercompose_data
data-exec:
	docker exec -ti cidockercompose_data_1 /bin/sh
