# Generate Code

* Put the avro schema file under `src/main/resources/avro`
* Run `mvn install`. This will generate the necessary Java classes under a package structure as defined in the `namespace` section 
  of the schema file

* For example, for the schema mentioned below, the java classes will be generated under the package `com.njkol.avro.models.user`

```json
{
 "namespace": "com.njkol.avro.models.user",
 "type": "record",
 "name": "User",
 "fields": [
     {"name": "name", "type": "string"},
     {"name": "favourite_color", "type": "string"}
 ]
}
```