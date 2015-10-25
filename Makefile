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
	@docker-compose rm -f
kill:
	@docker-compose kill
stop:
	@docker-compose stop
rmi:
	@docker images | grep "^cidocker" | awk '{print $$3}'| xargs docker rmi -f
stats:
	@open http://$(shell docker-machine ip ci-docker-compose):8666/haproxy?stats
