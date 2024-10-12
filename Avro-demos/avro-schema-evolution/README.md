
# Avro Schema Evolution

## What is schema evolution ?

* Schema evolution is the term used for how the store behaves when schema is changed after data has been written to the store using an older version of that schema.
 
* There are two main types of schema-compatibility backward and forward. 

## Backward Evolution

* The new schema must be able to read data written using previous versions of schemas( basically backwards compatibility )
* The fields added in the new schema will be populated with default value as per data type in the de-serialized data
		
## Forward Evolution

* The previous versions of the schema should be able to read the Data written by the new schema
* The idea is that the schema continues to evolve in the forward direction ( say addition of new fields ) however the older schema should remain unaffected by this.
* The de-serialized data will show all the fields in the new schema ( Which were also part of the older schema
* However the new fields unknown to old schema will be ignored

## Analogy

* Backwards compatibility is like playing a Playstation 4 game on Playstation 5
* Forward compatibility is like trying to play a Playstation 5 game on Playstation 4


## Cases

* Adding an element to an enum is a breaking schema evolution

  Once you define an enum, you can't remove or add elements to it without breaking the schema

* Adding a field to a record without a default is a forward schema evolution

  You can use the old schema to read new data, so it's a forward compatible change

* Removing a field that does not have a default is a backward schema evolution

  You can use the new schema to read old data, so it's a backward compatible change

* Removing or adding a field that has a default is a full schema evolution

  we can read old and new data with either schemas, this is a fully compatible evolution

## Best practices

* Make your primary key required
* Give default values to all fields that could be removed in the future
* Be very careful while using Enums, as they can't evolve over time
* Don't rename fields. You can add aliases instead
* When evolving a schema, ALWAYS give default values
* When evolving a schema, NEVER delete a required field

# Notes 

* Generic Records can generate runtime errors a field does not exist

* In ingestion pipelines, Forward compatibility is more common and important 
  than Backwards compatibility.

  This is because once the schema of your old data changes, you want your old
  consumers/processors to continue as-is without runtime exceptions



References
==========
https://docs.oracle.com/database/nosql-12.1.3.0/GettingStartedGuide/schemaevolution.html

http://rishavrohitblog.blogspot.com/2014/02/avro-schema-evolution.html