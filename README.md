H2 database holds all configurations; initialization is executed when the application is running.
3 records are inserted by default. (See data.sql)

#REST interfaces
/all
lists all configurations in DB

GET: /{id}
get configuration by id

GET: /name/{name}
get configurations by name

GET: /value?applicationName={applicationName}&name={name}
get configuration value by applicationName and conf. name
Example /value?applicationName=SERVICE-A&name=SiteName

POST: /
creates a new configuration with below payload
{
  "name": "SiteName",
  "type": "String",
  "value": "trendyol-test.com",
  "isActive": false,
  "applicationName": "SERVICE-A"
}

PUT: /{id}
updates the configuration with given id by using below payload
{
	"id": 3,
	"name": "SiteName",
	"type": "String",
	"value": "trendyol-test.com",
	"isActive": false,
	"applicationName": "SERVICE-A-test"
}

#Details
Spring framework cache is used in the configuration service
Spring scheduler is used to clean the cache
