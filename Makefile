dm-create:
	@docker-machine create --driver virtualbox ci-docker-compose
dm-env:
	@docker-machine env ci-docker-compose
dm-start:
	@docker-machine start ci-docker-compose

up:
	@docker-compose up -d
ps:
	@docker-compose ps
rm:
	@docker-compose rm
stop:
	@docker-compose stop
rmi:
	@docker images | grep "^cidocker" | awk '{print $$3}'| xargs docker rmi -f

