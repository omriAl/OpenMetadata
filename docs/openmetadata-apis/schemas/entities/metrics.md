# Metrics

This schema defines the Metrics entity. Metrics are measurements computed from data such as `Monthly Active Users`. Some of the metrics that measures used to determine performance against an objective are called KPIs or Key Performance Indicators, such as `User Retention`.

**$id:**[**https://open-metadata.org/schema/entity/data/metrics.json**](https://open-metadata.org/schema/entity/data/metrics.json)

Type: `object`

This schema <u>does not</u> accept additional properties.

## Properties
- **id** `required`
  - Unique identifier that identifies this metrics instance.
  - $ref: [../../type/basic.json#/definitions/uuid](../types/basic.md#uuid)
- **name** `required`
  - Name that identifies this metrics instance uniquely.
  - Type: `string`
  - Length: between 1 and 128
- **fullyQualifiedName**
  - A unique name that identifies a metric in the format 'ServiceName.MetricName'.
  - Type: `string`
  - Length: between 1 and 256
- **displayName**
  - Display Name that identifies this metric.
  - Type: `string`
- **description**
  - Description of metrics instance, what it is, and how to use it.
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
- **href**
  - Link to the resource corresponding to this entity.
  - $ref: [../../type/basic.json#/definitions/href](../types/basic.md#href)
- **owner**
  - Owner of this metrics.
  - $ref: [../../type/entityReference.json](../types/entityreference.md)
- **tags**
  - Tags for this chart.
  - Type: `array`
    - **Items**
    - $ref: [../../type/tagLabel.json](../types/taglabel.md)
- **service** `required`
  - Link to service where this metrics is hosted in.
  - $ref: [../../type/entityReference.json](../types/entityreference.md)
- **usageSummary**
  - Latest usage information for this database.
  - $ref: [../../type/usageDetails.json](../types/usagedetails.md)
- **changeDescription**
  - Change that lead to this version of the entity.
  - $ref: [../../type/entityHistory.json#/definitions/changeDescription](../types/entityhistory.md#changedescription)

_This document was updated on: Thursday, December 9, 2021_