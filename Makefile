local-env-create:
	docker-compose -f stack.yaml up -d
	sleep 5
	docker cp data/ddl.sql postgres3:/var/lib/postgresql/data
	docker exec postgres3 psql -h localhost -U postgres -d postgres -a -f ./var/lib/postgresql/data/ddl.sql

local-env-destroy:
	docker-compose -f stack.yaml down