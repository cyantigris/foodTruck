# foodTruck
## Description:
This is a backend service for finding truck list in San Fransico by using distance, name, status, and facilityType.

## Entry Point:
FoodTruckApplication

## Structure:
|- controller -> APIs <br>
|- db -> gaven food truck list <br>
|- entity -> related entities and DTOs <br>
|- pojo -> constants and csv read functions <br>
|- service -> search service <br>
    |- impl -> service implementations <br>

## APIs:
### Get Search Result: /search/results/
##### Type: post.
#### Parameters: 
- <b>distance(km): </b>Chosen distance from center( Estee Lauder store location in Macy's department store in SF).<br>
  <b>Value "-1" means to get all.<b><br>
- <b>applicant: </b>food truck name. <br>
- <b>truckStatus: </b>food truck status. <br>
- <b>facilityType: </b>facility Type for food truck. <br>

#### Return structure example:

```json
{
  "code": [Integer code for return type],
  "message": [
    {
      "applicant": "applicant name",
      "address": "truck address",
      "status": "applicant status",
      "foodItems": "item name",
      "facilityType": "facility type",
      "dayshours": "working hours",
      "latitude":  "truck latitude",
      "longitude": "truck longitude"}
  ], ...
}
```


### Test Connection: /search/test/
##### Type: get.
##### Return value if succues: "OK".