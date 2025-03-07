/*
 *  Copyright 2021 Collate
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import { AxiosResponse } from 'axios';
import { Pipeline } from '../generated/entity/data/pipeline';
import { getURLWithQueryFields } from '../utils/APIUtils';
import APIClient from './index';

export const getPipelines: Function = (
  serviceName: string,
  paging: string,
  arrQueryFields: string
): Promise<AxiosResponse> => {
  const url = `${getURLWithQueryFields(
    `/pipelines`,
    arrQueryFields
  )}&service=${serviceName}${paging ? paging : ''}`;

  return APIClient.get(url);
};

export const getPipelineDetails: Function = (
  id: string,
  arrQueryFields: string
): Promise<AxiosResponse> => {
  const url = getURLWithQueryFields(`/pipelines/${id}`, arrQueryFields);

  return APIClient.get(url);
};

export const getPipelineByFqn: Function = (
  fqn: string,
  arrQueryFields: string
): Promise<AxiosResponse> => {
  const url = getURLWithQueryFields(`/pipelines/name/${fqn}`, arrQueryFields);

  return APIClient.get(url);
};

export const addFollower: Function = (
  pipelineID: string,
  userId: string
): Promise<AxiosResponse> => {
  const configOptions = {
    headers: { 'Content-type': 'application/json' },
  };

  return APIClient.put(
    `/pipelines/${pipelineID}/followers`,
    userId,
    configOptions
  );
};

export const removeFollower: Function = (
  pipelineID: string,
  userId: string
): Promise<AxiosResponse> => {
  const configOptions = {
    headers: { 'Content-type': 'application/json' },
  };

  return APIClient.delete(
    `/pipelines/${pipelineID}/followers/${userId}`,
    configOptions
  );
};

export const patchPipelineDetails: Function = (
  id: string,
  data: Pipeline
): Promise<AxiosResponse> => {
  const configOptions = {
    headers: { 'Content-type': 'application/json-patch+json' },
  };

  return APIClient.patch(`/pipelines/${id}`, data, configOptions);
};
