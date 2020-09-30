/*
 * Copyright (c) 2008-2014 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mongodb.event;

import com.mongodb.annotations.Beta;
import com.mongodb.connection.ClusterDescription;
import com.mongodb.connection.ClusterId;

/**
 * An event signifying that the cluster description has changed.
 */
@Beta
public class ClusterDescriptionChangedEvent extends ClusterEvent {
    private final ClusterDescription clusterDescription;

    /**
     * Constructs a new instance of the event.
     *
     * @param clusterId          the cluster id
     * @param clusterDescription the cluster description
     */
    public ClusterDescriptionChangedEvent(final ClusterId clusterId, final ClusterDescription clusterDescription) {
        super(clusterId);
        this.clusterDescription = clusterDescription;
    }

    /**
     * Gets the new cluster description.
     *
     * @return the cluster description
     */
    public ClusterDescription getClusterDescription() {
        return clusterDescription;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ClusterDescriptionChangedEvent that = (ClusterDescriptionChangedEvent) o;

        if (!getClusterId().equals(that.getClusterId())) {
            return false;
        }
        if (!clusterDescription.equals(that.clusterDescription)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return clusterDescription.hashCode();
    }
}
