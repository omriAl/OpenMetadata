# Pipeline Service

This schema defines the Pipeline Service entity, such as Airflow and Prefect.

**$id:** [**https://open-metadata.org/schema/entity/services/messagingservice.json**](https://open-metadata.org/schema/entity/services/messagingservice.json)

Type: `object`

This schema <u>does not</u> accept additional properties.

## Properties
- **id** `required`
  - Unique identifier of this pipeline service instance.
  - $ref: [../../type/basic.json#/definitions/uuid](../types/basic.md#uuid)
- **name** `required`
  - Name that identifies this pipeline service.
  - Type: `string`
  - Length: between 1 and 128
- **serviceType**
  - Type of pipeline service such as Airflow or Prefect...
  - $ref: [#/definitions/pipelineServiceType](#pipelineservicetype)
- **description**
  - Description of a pipeline service instance.
  - Type: `string`
- **displayName**
  - Display Name that identifies this pipeline service. It could be title or label from the source services.
  - Type: `string`
- **version**
  - Metadata version of the entity.
  - $ref: [../../type/entityHistory.json#/definitions/entityVersion](../types/entityhistory.md#entityversion)
- **updatedAt**
  - Last update time corresponding to the new version of the entity.
  - $ref: [../../type/basic.json#/definitions/dateTime](../types/basic.md#datetime)
- **updatedBy**
  - User who made the update.
  - Type: `string`
- **pipelineUrl** `required`
  - Pipeline Service Management/UI URL.
  - Type: `string`
  - String format must be a "uri"
- **ingestionSchedule**
  - Schedule for running metadata ingestion jobs.
  - $ref: [../../type/schedule.json](../types/schedule.md)
- **href**
  - Link to the resource corresponding to this pipeline service.
  - $ref: [../../type/basic.json#/definitions/href](../types/basic.md#href)
- **changeDescription**
  - Change that lead to this version of the entity.
  - $ref: [../../type/entityHistory.json#/definitions/changeDescription](../types/entityhistory.md#changedescription)


## Type definitions in this schema

### pipelineServiceType

- Type of pipeline service - Airflow or Prefect.
- Type: `string`
- The value is restricted to the following: 
  1. _"Airflow"_
  2. _"Prefect"_
  3. _"Glue"_

_This document was updated on: Thursday, December 9, 2021_