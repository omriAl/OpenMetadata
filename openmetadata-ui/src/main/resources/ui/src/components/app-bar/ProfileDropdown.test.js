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

import { render } from '@testing-library/react';
import React from 'react';
import ProfileDropdown from './ProfileDropdown';

describe('Test ProfileDropdown Component', () => {
  it('Component should render', () => {
    const { getByTestId } = render(<ProfileDropdown name="Test user" />);
    const dropdown = getByTestId('dropdown-profile');

    expect(dropdown).toBeInTheDocument();
  });
});
