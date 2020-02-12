/*
 * Copyright 2020 Hazelcast Inc.
 *
 * Licensed under the Hazelcast Community License (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the
 * License at
 *
 * http://hazelcast.com/hazelcast-community-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.hazelcast.jca;

import javax.resource.ResourceException;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.spi.ManagedConnectionMetaData;

/**
 * Implements the meta data of this hazelcast connections based on the implementation details
 */
final class HazelcastManagedConnectionMetaData implements ManagedConnectionMetaData, ConnectionMetaData {

    public HazelcastManagedConnectionMetaData() {
    }

    /* (non-Javadoc)
     * @see javax.resource.spi.ManagedConnectionMetaData#getEISProductName()
     */
    public String getEISProductName() throws ResourceException {
        return HazelcastManagedConnectionMetaData.class.getPackage().getImplementationTitle();
    }

    /* (non-Javadoc)
     * @see javax.resource.spi.ManagedConnectionMetaData#getEISProductVersion()
     */
    public String getEISProductVersion() throws ResourceException {
        return HazelcastManagedConnectionMetaData.class.getPackage().getImplementationVersion();
    }

    /* (non-Javadoc)
     * @see javax.resource.spi.ManagedConnectionMetaData#getMaxConnections()
     */
    public int getMaxConnections() throws ResourceException {
        // The heap is the limit...
        return Integer.MAX_VALUE;
    }

    /* (non-Javadoc)
     * @see javax.resource.spi.ManagedConnectionMetaData#getUserName()
     */
    public String getUserName() throws ResourceException {
        // No security here
        return "";
    }
}
